package com.swvalerian.SpringSecurityDemo.rest;

import com.swvalerian.SpringSecurityDemo.model.Developer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperRestController {
    // ВМЕСТО БД РЕПОЗИТОРИЯ
    private List<Developer> DEVELOPER = Stream.of(
            new Developer(1l, "Antuan", "Ekzuperi"),
            new Developer(2l,"Alexandr", "Duma"),
            new Developer(3l,"Sergey","Sinicin")
    ).collect(Collectors.toList());

    @GetMapping
    public List<Developer> getAll() {
        return DEVELOPER;
    }

    @GetMapping("/{id}")
    public Developer getDeveloperById(@PathVariable("id") Long id) {

        return this.getAll().stream().filter(dev -> dev.getId().equals(id)).findFirst().orElse(null);
    }

}
