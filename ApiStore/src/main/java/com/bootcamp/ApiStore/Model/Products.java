package com.bootcamp.ApiStore.Model;



import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"code"})
    }
)
public class Products {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "code")
    @NotBlank
    @ApiModelProperty(required = true)
    private int code;

    @Column(name = "name")
    @NotBlank
    @ApiModelProperty(required = true)
    private String name;

    @Column(name = "stock")
    @NotBlank
    @ApiModelProperty(required = true)
    private int stock;

    @Column(name = "price")
    @NotBlank
    @ApiModelProperty(required = true)
    private double price;
}
