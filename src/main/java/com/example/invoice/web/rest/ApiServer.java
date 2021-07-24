package com.example.invoice.web.rest;


import com.example.invoice.service.DetailService;
import com.example.invoice.service.dto.DetailFeedDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiServer {

    private final Logger log = LoggerFactory.getLogger(ApiServer.class);

    private final DetailService detailService;

    public ApiServer(DetailService detailService) {
        this.detailService = detailService;
    }

    @GetMapping("/product/details/{productId}")
    ResponseEntity<List<DetailFeedDTO>> getAllDetailsByProductId(@PathVariable Long productId) {
        List<DetailFeedDTO> result = detailService.getAllByProductId(productId);
        return ResponseEntity.ok(result);
    }
}