package com.example.member.domain;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Data
public class Member {

    @Id
    private Integer id;

    private String name;
}
