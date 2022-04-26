package com.bootcamp.ApiCrud.Entity;

import com.bootcamp.ApiCrud.Model.Furniture;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "furniture",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = { "code" })
    }
)
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FurnitureEntity extends Furniture {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) @Setter
    int id;
    private int code;
}
