package org.example.entity;

import jakarta.persistence.*;

import lombok.Data;

@Entity
@Table(name = "planet")
@Data
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
}
