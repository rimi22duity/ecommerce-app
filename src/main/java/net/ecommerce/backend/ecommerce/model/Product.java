package net.ecommerce.backend.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;

/**
 * @author duity
 * @since 4/28/24
 */

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Product {

    @Id
    @SequenceGenerator(name = "productSeq", sequenceName = "productSeq", allocationSize = 1)
    @GeneratedValue(generator = "productSeq")
    private long id;
    private String title;
    private String description;
    private boolean availability;
    private double price;
    private String imageUrl;
}
