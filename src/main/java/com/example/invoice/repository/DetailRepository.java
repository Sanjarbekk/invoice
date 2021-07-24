package com.example.invoice.repository;

import com.example.invoice.model.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailRepository extends JpaRepository<Detail, Long> {

    List<Detail> findAllByProductId(Long productId);

}