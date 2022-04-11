package com.example.javamicro_service.space;


import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// script dir -> curl , web utility to make client requests


@RestController
@RequestMapping("/space")
// prefix endpoint starter for all URI
// applied to all the endpoints
public class SpaceShipRestController {
    // adding default object parameters to ships array
    private static List<SpaceShip> ships = new ArrayList<>(List.of(new SpaceShip("Mike", 50)));

    // GET http request to execute public func
    @GetMapping("/ship")
    // converts List of spaceships to json file
    public List<SpaceShip> ships() {
        // returns static SpaceShip list
        return ships;
    }

    // POST spaceship from the endpoint
    @PostMapping("/ship")
    public List<SpaceShip> ships(@RequestBody SpaceShip ship){
        // add created spaceship to the static list
        ships.add(ship);
        // return the list to see the outcome
        return ships;

    }

    @DeleteMapping("/ship/{captain}")
    // path parameter {captain} , pathvariable in spring
    public List <SpaceShip> deleteships(@PathVariable String captain ) {
        // filter ships collection from the static list
        List<SpaceShip> collect = ships.stream().filter((s) -> s.getCaptain().equalsIgnoreCase(captain))
                .collect(Collectors.toList());
        ships.removeAll(collect);
        return ships;

    }



}
