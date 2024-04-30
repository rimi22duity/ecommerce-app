package net.ecommerce.backend.ecommerce.service;

import lombok.extern.java.Log;
import net.ecommerce.backend.ecommerce.dto.ProductRequestDto;
import net.ecommerce.backend.ecommerce.model.Product;
import net.ecommerce.backend.ecommerce.repository.ProductRepository;
import net.ecommerce.backend.ecommerce.utils.ProductMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

/**
 * @author duity
 * @since 4/28/24
 */

@Service
public class ProductService {

    public final Logger log = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper mapper;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public ArrayList<Product> getProducts() {
        return  new ArrayList(productRepository.findAll());
    }

    public Product getProductById(Long id) {
        return Optional.of(productRepository.findById(id)).get().orElse(null);
    }

    public Product editProduct(long id, ProductRequestDto productRequestDto) {
        Product dbProduct = getProductById(id);
        mapper.updateProductFromDTO(productRequestDto, dbProduct);
        return productRepository.save(dbProduct);
    }

    public void deleteProduct(long id) {
        try {
            productRepository.deleteById(id);
        } catch(Exception e) {
            log.error("Exception Message: {}", e.getCause());
        }
    }

//    public Page<Product> getRequestedFilters(int page, int limit, String productName, Sort.Direction sortType) {
//        Page<Product> productPage = null;
//        if (productName == null && sortType == null) {
//            productPage = getProduct(page, limit);
//        }
//
//        if (productName != null && sortType == null) {
//
//        }
//    }

    public Page<Product> getProduct(int page, int limit) {
        Pageable pageable = PageRequest.of(page, limit);
        return productRepository.findAll(pageable);
    }

    public Page<Product> findProductsByName(int page, int limit, String productName) {
        Pageable pageable = PageRequest.of(page, limit);
        return productRepository.findByTitleIgnoringCase(productName, pageable);
    }

    public Page<Product> getProductsOrderedByPrice(int page, int limit, String productName, Sort.Direction sortType) {
        Sort sort = Sort.by(sortType, "price");
        Pageable pageable = PageRequest.of(page, limit, sort);
        return productRepository.findByTitleIgnoringCase(productName, pageable);
    }




}
