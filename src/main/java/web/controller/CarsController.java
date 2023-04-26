package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

import java.util.Optional;

@Controller
public class CarsController {

    private final CarService carService;

    @Autowired
    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("cars")
    public String getCars(@RequestParam(value = "count", defaultValue = "5") Optional<Integer> count, ModelMap model) {
        model.addAttribute("cars", carService.getListCar(count.orElse(0)));
        return "cars";
    }
}
