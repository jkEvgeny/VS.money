package ru.virtusystems.money.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.virtusystems.money.model.Policyholder;
import ru.virtusystems.money.repository.PolicyholderRepository;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private PolicyholderRepository repository;

    @GetMapping("/get")
    public Policyholder getUser(@RequestParam(name = "id") Integer id) {
        return repository.findById(id).orElse(new Policyholder());
    }

    @GetMapping("/getAll")
    public List<Policyholder> getAll() {
        return repository.findAll();
    }

    @GetMapping(path = "/test")
    public String test(@RequestParam(required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
}
