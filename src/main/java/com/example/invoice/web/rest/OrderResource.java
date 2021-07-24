package com.example.invoice.web.rest;

import com.example.invoice.service.OrderService;
import com.example.invoice.service.dto.OrderDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderResource {

    private final Logger log = LoggerFactory.getLogger(OrderResource.class);

    private final OrderService orderService;

    public OrderResource(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order")
    ResponseEntity<OrderDTO> createOrder(@Valid @RequestBody OrderDTO orderDTO) {
        log.debug("Create New Order : {}", orderDTO);
        OrderDTO result = orderService.save(orderDTO);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/orders")
    ResponseEntity<List<OrderDTO>> getAllOrders() {
        log.debug("Get All Orders");
        List<OrderDTO> result = orderService.findAll();
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/order/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        log.debug("REST request to delete Order : {}", id);
        orderService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id) {
        log.debug("REST request to get Order : {}", id);
        OrderDTO result = orderService.findOneDto(id);
        return ResponseEntity.ok(result);
    }
}