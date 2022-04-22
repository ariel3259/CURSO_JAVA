package com.bootcamp.ApiEcommerce.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("products")
public class Articles {
    @MongoId(FieldType.INT64)
    private int id;
    private String name;
    private Double price;
    private Integer stock;
}
