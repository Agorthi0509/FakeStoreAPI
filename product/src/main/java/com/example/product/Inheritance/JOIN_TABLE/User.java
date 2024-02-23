package com.example.product.Inheritance.JOIN_TABLE;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Inheritance(strategy= InheritanceType.JOINED)
@Entity(name = "JT_User")
public class User {
    @Id
    private Long id;
    private String name;
    private String email;
    private String password;
}
