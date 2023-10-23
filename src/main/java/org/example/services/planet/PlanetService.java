package org.example.services.planet;

import org.example.entity.Planet;

public final class PlanetService implements PlanetCrudService {
    private final PlanetCrudServiceImpl planetCrudService = new PlanetCrudServiceImpl();

    @Override
    public void create(final Planet planet) {
        planetCrudService.create(planet);
    }

    @Override
    public Planet read(final String id) {
        return planetCrudService.read(id);
    }

    @Override
    public void update(final Planet planet) {
        planetCrudService.update(planet);
    }

    @Override
    public void delete(final Planet planet) {
        planetCrudService.delete(planet);
    }
}
