package com.example.invoice.service;

import com.example.invoice.model.Category;
import com.example.invoice.repository.CategoryRepository;
import com.example.invoice.service.dto.CategoryDTO;
import com.example.invoice.service.dto.ProductDTO;
import com.example.invoice.service.mapper.CategoryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CategoryService {

    private final Logger log = LoggerFactory.getLogger(CategoryService.class);

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    private final ProductService productService;

    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper, ProductService productService) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
        this.productService = productService;
    }

    /**
     * Save a category
     *
     * @param categoryDTO the Entity to save
     * @return the persisted entity
     */
    @Transactional(readOnly = true)
    public CategoryDTO save(CategoryDTO categoryDTO) {
        log.debug("Request to save Category : {}", categoryDTO);
        Category category = categoryMapper.toEntity(categoryDTO);
        category = categoryRepository.save(category);
        return categoryMapper.toDto(category);
    }

    /**
     * Get all the categories
     *
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {
        log.debug("Request to get all Categories");
        return categoryRepository.findAll().stream()
                .map(categoryMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Get one category by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public CategoryDTO findOneDto(Long id) {
        log.debug("Request to get Category : {}", id);
        return categoryRepository.findById(id)
                .map(categoryMapper::toDto)
                .orElse(null);
    }

    /**
     * Delete the category by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Category : {}", id);
        categoryRepository.deleteById(id);
    }

    public CategoryDTO getCategoryByProductId(Long productId) {
        log.debug("get  Category by Product Id : {}", productId);
        Long categoryId = getCategoryId(productId);
        return findOneDto(categoryId);
    }

    private Long getCategoryId(Long productId) {
        ProductDTO productDTO = productService.findOneDto(productId);
        return productDTO.getCategoryId();
    }
}