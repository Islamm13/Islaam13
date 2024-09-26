package aze.newexample.service;

import aze.newexample.entity.Fruit;
import aze.newexample.repository.FruitRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FruitService {

    private final FruitRepository fruitRepository;

    public Fruit create(Fruit updateFruit) {
        return fruitRepository.save(updateFruit);
    }

    public Optional<Fruit> getFruit(Long id) {
        return fruitRepository.findById(id);
    }

    public Fruit updateFruit(Long id, Fruit updatedFruit) {
        Fruit existingFruit = fruitRepository.findById(id).orElseThrow(() -> new RuntimeException("Bele Bir "
                + id + "Yoxdu Xalaoglu"));
        existingFruit.setName(updatedFruit.getName());
        existingFruit.setId(updatedFruit.getId());
        existingFruit.setPrice(updatedFruit.getPrice());
        existingFruit.setAmount(updatedFruit.getAmount());
        return fruitRepository.save(existingFruit);

    }

    public void deleteFruit(Long id) {
        if (!fruitRepository.existsById(id)) {
            throw new EntityNotFoundException("Fruit with ID " + id + " not found.");
        }
        fruitRepository.deleteById(id);
    }
}
