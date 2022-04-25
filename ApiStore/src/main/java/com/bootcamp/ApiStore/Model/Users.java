package com.bootcamp.ApiStore.Model;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"email"})
})
public class Users {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    @ApiModelProperty(required = true)
    private String name;

    @Column(name = "last_name")
    @ApiModelProperty(required = true)
    private String lastName;

    @Column(name = "email")
    @ApiModelProperty(required = true)
    private String email;

    @Column(name = "password")
    @ApiModelProperty(required = true)
    private String password;
}
