package net.ecommerce.backend.ecommerce.utils;

import net.ecommerce.backend.ecommerce.dto.ProductRequestDto;
import net.ecommerce.backend.ecommerce.model.Product;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

import java.beans.BeanProperty;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Component
@Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface ProductMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateProductFromDTO(ProductRequestDto productRequestDto, @MappingTarget Product product);
}
