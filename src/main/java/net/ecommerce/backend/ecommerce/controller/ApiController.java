package net.ecommerce.backend.ecommerce.controller;

import net.ecommerce.backend.ecommerce.dto.ProductRequestDto;
import net.ecommerce.backend.ecommerce.model.Product;
import net.ecommerce.backend.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
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

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/saveProduct")
    public ResponseEntity<String> addProduct(@RequestBody ProductRequestDto requestDto) throws IOException {
        Product product = Product.builder()
                .availability(requestDto.isAvailable())
                .description(requestDto.getDescription())
                .price(requestDto.getPrice())
                .title(requestDto.getTitle())
                .imageUrl(requestDto.getImageUrl())
                .build();

        Product savedProduct = productService.saveProduct(product);

        return Objects.nonNull(savedProduct)
                ? ResponseEntity.ok(savedProduct.toString())
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/products")
    public ResponseEntity<String> getProducts() {
        ArrayList<Product> products = productService.getProducts();

        return Objects.nonNull(products)
                ? ResponseEntity.ok(products.toString())
                : ResponseEntity.notFound().build();

    }

    @PutMapping("/editProduct/{id}")
    public ResponseEntity<String> editProduct(@PathVariable Long id,
                                              @RequestBody ProductRequestDto productRequestDto) {
        Product editedProduct = productService.editProduct(id, productRequestDto);

        return Objects.nonNull(editedProduct)
                ? ResponseEntity.ok(editedProduct.toString())
                : ResponseEntity.notFound().build();

    }
}
