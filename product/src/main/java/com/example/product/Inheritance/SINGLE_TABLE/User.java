package com.example.product.Inheritance.SINGLE_TABLE;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "user-type",
        discriminatorType = DiscriminatorType.INTEGER
)
@DiscriminatorValue("0")
@Entity(name = "ST_User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String password;
}
