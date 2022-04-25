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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "clients",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = { "dni" })
        }
)
public class Clients {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @ApiModelProperty(required = true)
    @NotBlank
    private String name;

    @Column(name = "last_name")
    @ApiModelProperty(required = true)
    @NotBlank
    private String lastName;

    @Column(name = "phone")
    @ApiModelProperty(required = true)
    @NotBlank
    private int phone;

    @Column(name = "dni")
    @ApiModelProperty(required = true)
    @NotBlank
    private int dni;

    @Column(name = "email")
    @ApiModelProperty(required = true)
    @NotBlank
    private String email;
}
