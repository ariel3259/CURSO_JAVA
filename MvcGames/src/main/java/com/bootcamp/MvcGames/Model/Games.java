package com.bootcamp.MvcGames.Model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Games {
    
    private long id;
    @NotEmpty 
    private String name;
    @NotEmpty 
    private String description;
    @NotEmpty 
    private String gender;
    @NotEmpty 
    private String publisher;
    @NotEmpty 
    private String studio;
    @NotNull
    private double price;
}