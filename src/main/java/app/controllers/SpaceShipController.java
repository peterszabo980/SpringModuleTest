package app.controllers;

import app.models.SpaceShip;
import app.models.SpaceShipClass;
import app.services.SpaceShipService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class SpaceShipController {

    private final SpaceShipService spaceShipService;

    public SpaceShipController(SpaceShipService spaceShipService) {
        this.spaceShipService = spaceShipService;
    }

    @GetMapping(value = {"/spaceship"})
    public String saveNewSpaceShip(Model model) {
        model.addAttribute("newShip", new SpaceShip());
        model.addAttribute("shipClasses", SpaceShipClass.values());

        return "spaceship_new";
    }

    @GetMapping(value = {"/ships"})
    public String getAllShips(Model model) {
        List<SpaceShip> spaceShips = spaceShipService.getAll();
        model.addAttribute("spaceships", spaceShips);

        return "ships";
    }

    @GetMapping(value = {"/ships/active"})
    public String getActiveShips(Model model) {
        List<SpaceShip> spaceShips = spaceShipService.getActiveShips();
        model.addAttribute("spaceships", spaceShips);

        return "ships";
    }

    @GetMapping(value = {"/ships/{name}"})
    public String getShipCrew(@PathVariable String name, Model model) {
        SpaceShip spaceShip = spaceShipService.findByName(name);
        model.addAttribute("spaceships", spaceShip);

        return "crew";
    }


}
