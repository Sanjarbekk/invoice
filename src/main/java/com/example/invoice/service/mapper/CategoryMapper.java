package com.example.invoice.service.mapper;

import com.example.invoice.model.Category;
import com.example.invoice.service.dto.CategoryDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface CategoryMapper extends EntityMapper<CategoryDTO, Category> {

}
