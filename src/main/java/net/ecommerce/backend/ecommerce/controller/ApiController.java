package net.ecommerce.backend.ecommerce.controller;

import net.ecommerce.backend.ecommerce.dto.ProductRequestDto;
import net.ecommerce.backend.ecommerce.model.Product;
import net.ecommerce.backend.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @author duity
 * @since 4/28/24
 */

@RestController
public class ApiController {

    @Autowired
    private ProductService productService;

    @PostMapping("/saveProduct")
    public ResponseEntity<String> getProduct(@RequestBody ProductRequestDto requestDto) {
        Product product = Product.builder()
                .availability(requestDto.isAvailability())
                .description(requestDto.getDescription())
                .price(requestDto.getPrice())
                .title(requestDto.getTitle())
                .imageUrl(requestDto.getImageUrl())
                .build();

        Product savedProduct = productService.saveProduct(product);

        return Objects.nonNull(savedProduct) ? ResponseEntity.ok(savedProduct.toString()) : ResponseEntity.notFound().build();
    }
}
