package com.example.invoice.service;

import com.example.invoice.model.Detail;
import com.example.invoice.repository.DetailFeedMapper;
import com.example.invoice.repository.DetailRepository;
import com.example.invoice.service.dto.DetailDTO;
import com.example.invoice.service.dto.DetailFeedDTO;
import com.example.invoice.service.mapper.DetailMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DetailService {

    private final Logger log = LoggerFactory.getLogger(DetailService.class);

    private final DetailMapper detailMapper;

    private final DetailFeedMapper detailFeedMapper;

    private final DetailRepository detailRepository;

    public DetailService(DetailMapper detailMapper, DetailFeedMapper detailFeedMapper, DetailRepository detailRepository) {
        this.detailMapper = detailMapper;
        this.detailFeedMapper = detailFeedMapper;
        this.detailRepository = detailRepository;
    }

    /**
     * Save a detail
     *
     * @param detailDTO the Entity to save
     * @return the persisted entity
     */
    @Transactional(readOnly = true)
    public DetailDTO save(DetailDTO detailDTO) {
        log.debug("Request to save Detail : {}", detailDTO);
        Detail detail = detailMapper.toEntity(detailDTO);
        detail = detailRepository.save(detail);
        return detailMapper.toDto(detail);
    }

    /**
     * Get all the details
     *
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<DetailDTO> findAll() {
        log.debug("Request to get all Details");
        return detailRepository.findAll().stream()
                .map(detailMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Get one detail by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public DetailDTO findOneDto(Long id) {
        log.debug("Request to get Detail : {}", id);
        return detailRepository.findById(id)
                .map(detailMapper::toDto)
                .orElse(null);
    }

    /**
     * Delete the detail by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Detail : {}", id);
        detailRepository.deleteById(id);
    }

    public List<DetailFeedDTO> getAllByProductId(Long productId) {
        return detailRepository.findAllByProductId(productId).stream()
                .map(detailFeedMapper::toDto)
                .collect(Collectors.toList());
    }
}