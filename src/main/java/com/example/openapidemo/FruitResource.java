package com.example.openapidemo;

import com.example.openapidemo.domain.Fruit;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

@Tag(name = "fruits")
@RestController
@RequestMapping("/fruits")
public class FruitResource {
    private final Set<Fruit> fruits = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public FruitResource() {
        fruits.add(new Fruit("Apple", "Winter Fruit"));
        fruits.add(new Fruit("Pineapple", "Tropical Fruit"));
    }

    @Operation(summary = "Get fruits")
    @GetMapping
    public Set<Fruit> list() {
        return fruits;
    }

    @Operation(summary = "Add new fruit")
    @PostMapping
    public Set<Fruit> add(@RequestBody Fruit fruit) {
        fruits.add(fruit);
        return fruits;
    }

    @Operation(summary = "Delete fruits")
    @DeleteMapping
    public Set<Fruit> delete(@RequestBody Fruit fruit) {
        fruits.removeIf(f -> f.getName().equals(fruit.getName()));
        return fruits;
    }
}
