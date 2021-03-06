package com.example.invoice.web.rest;


import com.example.invoice.service.DetailService;
import com.example.invoice.service.OrderFeedService;
import com.example.invoice.service.dto.DetailFeedDTO;
import com.example.invoice.service.dto.OrderFeedDTO;
import com.example.invoice.web.rest.vm.OrderVM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiServer {

    private final Logger log = LoggerFactory.getLogger(ApiServer.class);

    private final DetailService detailService;

    private final OrderFeedService orderFeedService;

    public ApiServer(DetailService detailService, OrderFeedService orderFeedService) {
        this.detailService = detailService;
        this.orderFeedService = orderFeedService;
    }

    @GetMapping("/product/details/{productId}")
    ResponseEntity<List<DetailFeedDTO>> getAllDetailsByProductId(@PathVariable Long productId) {
        List<DetailFeedDTO> result = detailService.getAllByProductId(productId);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/make/order")
    ResponseEntity<OrderFeedDTO> createOrder(@PathVariable OrderVM orderVM) {
        OrderFeedDTO result = orderFeedService.makeOrder(orderVM);
        return ResponseEntity.ok(result);
    }
}