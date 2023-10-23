package org.example.services.planet;

import org.example.entity.Planet;

public interface PlanetCrudService {

    void create(Planet planet);

    Planet read(String id);

    void update(Planet planet);

    void delete(Planet planet);
}
