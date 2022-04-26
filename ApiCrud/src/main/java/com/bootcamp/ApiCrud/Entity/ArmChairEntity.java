package com.bootcamp.ApiCrud.Entity;

import com.bootcamp.ApiCrud.Model.ArmChair;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(
        name = "arm_chair",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = { "code" })
        }
)
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ArmChairEntity extends ArmChair {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter
    private int id;
    private int code;
}
