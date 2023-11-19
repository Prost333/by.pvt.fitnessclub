package by.pvt.fitnesclub.mapper;

import by.pvt.fitnesclub.dto.SaleRequest;
import by.pvt.fitnesclub.dto.SaleResponse;
import by.pvt.fitnesclub.entity.Sale;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SaleMapper {
    SaleResponse toResponse(Sale sale);

    Sale toEntity(SaleRequest saleRequest);
}
