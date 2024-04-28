package net.ecommerce.backend.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

/**
 * @author duity
 * @since 4/28/24
 */

@Getter
@Setter
public class ProductRequestDto {

    private String title;
    private String description;
    private boolean availability;
    private double price;
    private String imageUrl;
    private ArrayList<String> sizes;
}
