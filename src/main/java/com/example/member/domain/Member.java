package com.example.member.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Entity
@Data
public class Member {

    @Id
    private Long id;

    private String name;
}
