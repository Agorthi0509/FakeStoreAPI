package com.example.product.Inheritance.TABLE_PER_CLASS;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity(name = "TPC_User")
public class User {
    @Id
    private Long id;
    private String name;
    private String email;
    private String password;
}
