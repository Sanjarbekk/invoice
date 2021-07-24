package com.example.invoice.repository;

import com.example.invoice.model.Detail;
import com.example.invoice.service.dto.DetailFeedDTO;
import com.example.invoice.service.mapper.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface DetailFeedMapper extends EntityMapper<DetailFeedDTO, Detail> {

    DetailFeedDTO toDto(Detail detail);

}