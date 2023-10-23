package org.example.services.planet;

import org.example.entity.Planet;

public class PlanetService implements PlanetCrudService {
    private final PlanetCrudServiceImpl planetCrudService = new PlanetCrudServiceImpl();

    @Override
    public void create(Planet planet) {
        planetCrudService.create(planet);
    }

    @Override
    public Planet read(String id) {
        return planetCrudService.read(id);
    }

    @Override
    public void update(Planet planet) {
        planetCrudService.update(planet);
    }

    @Override
    public void delete(Planet planet) {
        planetCrudService.delete(planet);
    }
}
