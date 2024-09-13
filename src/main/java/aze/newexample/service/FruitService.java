package aze.newexample.service;

import aze.newexample.entity.Fruit;
import aze.newexample.repository.FruitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FruitService {

    private final FruitRepository fruitRepository;

    public Fruit create(Fruit fruit) {
        return fruitRepository.save(fruit);
    }
}
