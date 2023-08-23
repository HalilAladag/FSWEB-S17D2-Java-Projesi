package rest;

import jakarta.annotation.PostConstruct;
import model.Developer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tax.Taxable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DeveloperController {
    private Map<Integer, Developer> developers;
    private Taxable taxable;

    @PostConstruct
    public void init() {
    developers = new HashMap<>();
    this.taxable = taxable;
    }
@GetMapping("workintech/developers")
public List <Developer> getAllDevelopers() {
        return new ArrayList<>(developers.values());
}
    @GetMapping("/developers/{id}")
public Developer getDeveloperByıD (@PathVariable int id)     {
        return developers.get(id);
}
@PostMapping("workintech/developers")
    public Developer createDeveloper(@RequestBody Developer developer) {
    if (developer.getExperience() == Developer.experience.JUNIOR) {
        developer.setSalary(developer.getSalary() - taxable.getSimpleTaxRate());
    } else if (developer.getExperience() == Developer.experience.MID) {
        developer.setSalary(developer.getSalary() - taxable.getMiddleTaxRate());
    } else if (developer.getExperience() == Developer.experience.SENIOR) {
        developer.setSalary(developer.getSalary() - taxable.getUpperTaxRate());
    }

    developers.put(developer.getId(), developer);
    return developer;
}
    @PutMapping("/developers/{id}")
public Developer updateDeveloper(@PathVariable int id, @RequestBody Developer updatedDeveloper) {
        if (developers.containsKey(id)) {
            developers.put(id, updatedDeveloper);
            return updatedDeveloper;
        } else {
            throw new RuntimeException("Developer not found with ID: " + id);
        }
    }
    @DeleteMapping("/developers/{id}")
    public void deleteDeveloper(@PathVariable int id) {
        developers.remove(id);
    }
}
