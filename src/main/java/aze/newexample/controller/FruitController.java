package aze.newexample.controller;

import aze.newexample.entity.Fruit;
import aze.newexample.service.FruitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/fruit")
@RequiredArgsConstructor
public class FruitController {

    private final FruitService fruitService;

    @PostMapping("/create")
    public Fruit createFruit(@RequestBody Fruit fruit) {
        return fruitService.create(fruit);
    }
}
