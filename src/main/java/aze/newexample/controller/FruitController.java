package aze.newexample.controller;

import aze.newexample.entity.Fruit;
import aze.newexample.service.FruitService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/fruit")
@RequiredArgsConstructor
public class FruitController {

    private final FruitService fruitService;

    @PostMapping("/create")
    public Fruit createFruit(@RequestBody Fruit updateFruit) {
        return fruitService.create(updateFruit);
    }


    @GetMapping("/{id}")
    public Optional<Fruit> getById(@PathVariable Long id) {
        return fruitService.getFruit(id);
    }


    @PutMapping("/{id}")
    public Fruit update(@PathVariable Long id, @RequestBody Fruit updateFruit) {
        return fruitService.updateFruit(id, updateFruit);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            fruitService.deleteFruit(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {

            return ResponseEntity.notFound().build();
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
