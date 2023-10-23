package org.example.entity;

import jakarta.persistence.*;

import lombok.Data;

import java.util.List;

@Entity
@Table(name = "planets")
@Data
public class Planet {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "fromPlanet", fetch = FetchType.LAZY)
    private List<Ticket> departures;

    @OneToMany(mappedBy = "toPlanet", fetch = FetchType.LAZY)
    private List<Ticket> arrivals;
}
