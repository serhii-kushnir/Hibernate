package org.example.services.planet;

import org.example.entity.Planet;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test CRUD operations on Planet")
class PlanetServiceTest {

    @Test
    public void testPlanetCRUD() {
        // Create Patient
        final PlanetService planetService = new PlanetService();
        final Planet planet = new Planet();
        planet.setId("ERT");
        planet.setName("Earth");
        planetService.create(planet);

        // Read Patient
        final String planetId = planet.getId();
        final Planet readPlanet = planetService.read(planetId);
        assertEquals(planet.getName(), readPlanet.getName());

        // Update Patient
        final String updatePlanetName = "New Earth";
        readPlanet.setName(updatePlanetName);
        planetService.update(readPlanet);
        final Planet updatedPlanet = planetService.read(planetId);
        assertEquals(updatePlanetName, updatedPlanet.getName());

         // Delete Planet
        planetService.delete(updatedPlanet);
        assertNull(planetService.read(planetId));
    }
}
