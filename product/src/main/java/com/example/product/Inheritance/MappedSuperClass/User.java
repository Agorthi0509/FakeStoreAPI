package com.example.product.Inheritance.MappedSuperClass;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@MappedSuperclass
public class User {
    @Id
    private Long id;
    private String name;
    private String email;
    private String password;
}
