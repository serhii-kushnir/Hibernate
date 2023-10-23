package org.example.services.planet;

import org.example.entity.Planet;

public interface PlanetCrudService {

    void create(final Planet planet);

    Planet read(final String id);

    void update(final Planet planet);

    void delete(final Planet planet);
}
