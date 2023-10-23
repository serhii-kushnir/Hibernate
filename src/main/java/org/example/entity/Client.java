package org.example.entity;

import jakarta.persistence.*;

import lombok.Data;

import java.util.List;

/*
 *
 */
@Entity
@Table(name = "clients")
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private List<Ticket> tickets;
}
