package com.example.invoice.web.rest;

import com.example.invoice.service.DetailService;
import com.example.invoice.service.dto.DetailDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * REST controller for managing Detail.
 */
@RestController
@RequestMapping("/api")
public class DetailResource {

    private final Logger log = LoggerFactory.getLogger(DetailResource.class);

    private final DetailService detailService;

    public DetailResource(DetailService detailService) {
        this.detailService = detailService;
    }

    @PostMapping("/detail")
    ResponseEntity<DetailDTO> createCategory(@Valid @RequestBody DetailDTO detailDTO) {
        log.debug("Create New Detail : {}", detailDTO);
        DetailDTO result = detailService.save(detailDTO);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/details")
    ResponseEntity<List<DetailDTO>> getAllDetails() {
        log.debug("Get All Details");
        List<DetailDTO> result = detailService.findAll();
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/detail/{id}")
    public ResponseEntity<Void> deleteDetail(@PathVariable Long id) {
        log.debug("REST request to delete Detail : {}", id);
        detailService.delete(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<DetailDTO> getDetailById(@PathVariable Long id) {
        log.debug("REST request to get Detail : {}", id);
        DetailDTO result = detailService.findOneDto(id);
        return ResponseEntity.ok(result);
    }
}
