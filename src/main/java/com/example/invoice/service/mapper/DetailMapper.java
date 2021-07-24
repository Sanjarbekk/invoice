package com.example.invoice.service.mapper;

import com.example.invoice.model.Detail;
import com.example.invoice.service.dto.DetailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ProductMapper.class, OrderMapper.class})
public interface DetailMapper extends EntityMapper<DetailDTO, Detail> {

    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "order.id", target = "orderId")
    DetailDTO toDto(Detail detail);

    @Mapping(source = "productId", target = "product")
    @Mapping(source = "orderId", target = "order")
    Detail toEntity(DetailDTO detailDTO);

    default Detail fromId(Long id) {
        if (id == null) {
            return null;
        }
        Detail detail = new Detail();
        detail.setId(id);
        return detail;
    }
}
