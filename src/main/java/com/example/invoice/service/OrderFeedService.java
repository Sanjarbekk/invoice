package com.example.invoice.service;

import com.example.invoice.repository.OrderRepository;
import com.example.invoice.service.dto.InvoiceDTO;
import com.example.invoice.service.dto.OrderDTO;
import com.example.invoice.service.dto.OrderFeedDTO;
import com.example.invoice.service.mapper.OrderMapper;
import com.example.invoice.web.rest.vm.OrderVM;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
public class OrderFeedService extends OrderService {

    private final InvoiceService invoiceService;

    public OrderFeedService(OrderRepository orderRepository, OrderMapper orderMapper, InvoiceService invoiceService) {
        super(orderRepository, orderMapper);
        this.invoiceService = invoiceService;
    }

    @Transactional(readOnly = true)
    public OrderFeedDTO makeOrder(OrderVM orderVM) {
        LocalDate date = LocalDate.now();
        OrderDTO orderDTO = new OrderDTO( date, orderVM.getCustomerId());
        orderDTO = save(orderDTO);
        return makeInvoice(orderDTO, orderVM);
    }

    private OrderFeedDTO makeInvoice(OrderDTO orderDTO, OrderVM orderVM) {
        InvoiceDTO invoiceDTO = new InvoiceDTO(orderVM.getQuantity(), orderDTO.getDate(), orderDTO.getDate(), orderDTO.getId());
        OrderFeedDTO result = new OrderFeedDTO();
        try {
            invoiceDTO  = invoiceService.save(invoiceDTO);
            result.setStatus("SUCCESS");
            result.setCreatedInvoiceId(invoiceDTO.getId());

        } catch (Exception exception) {
            result.setStatus("FAILED");
        }
        return result;
    }
}
