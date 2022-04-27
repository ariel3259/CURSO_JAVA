package com.bootcamp.Day11FirstProject.Model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    private Integer id;

    @ApiModelProperty(required = true)
    private String name;

    @ApiModelProperty(required = true)
    private String lastName;

    @ApiModelProperty(required = true)
    private Integer dni;

}
