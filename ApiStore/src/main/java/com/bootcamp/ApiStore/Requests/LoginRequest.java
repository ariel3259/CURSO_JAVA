package com.bootcamp.ApiStore.Requests;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    @NotBlank
    @ApiModelProperty(required = true)
    private String email;
    @NotBlank
    @ApiModelProperty(required = true)
    private String password;
}
