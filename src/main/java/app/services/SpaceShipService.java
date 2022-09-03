package app.services;

import app.models.SpaceShip;
import app.repositories.SpaceShipRepo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SpaceShipService {

    private final SpaceShipRepo spaceShipRepo;

    public SpaceShipService(SpaceShipRepo spaceShipRepo) {
        this.spaceShipRepo = spaceShipRepo;
    }

    public List<SpaceShip> getAll() {
        return new ArrayList<>((Collection) spaceShipRepo.findByisActiveTrue());
    }
}
