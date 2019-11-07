package com.lambdaschool.crudyrestaurants.controllers;

import com.lambdaschool.crudyrestaurants.models.Restaurant;
import com.lambdaschool.crudyrestaurants.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController
{
    @Autowired
    private RestaurantService restaurantService;

    // http://localhost:2019/restaurants/restaurants
    @GetMapping(value = "/restaurants",
                produces = {"application/json"})
    public ResponseEntity<?> listAllRestaurants()
    {
        List<Restaurant> myRestaurants = restaurantService.findAll();
        return new ResponseEntity<>(myRestaurants,
                                    HttpStatus.OK);
    }

    // http://localhost:2019/restaurants/restaurant/3
    @GetMapping(value = "/restaurant/{restaurantId}",
                produces = {"application/json"})
    public ResponseEntity<?> getRestaurantById(
            @PathVariable
                    Long restaurantId)
    {
        Restaurant r = restaurantService.findRestaurantById(restaurantId);
        return new ResponseEntity<>(r,
                                    HttpStatus.OK);
    }

    // http://localhost:2019/restaurants/restaurant/name/Supreme%20Eats
    @GetMapping(value = "/restaurant/name/{name}",
                produces = {"application/json"})
    public ResponseEntity<?> getRestaurantByName(
            @PathVariable
                    String name)
    {
        Restaurant r = restaurantService.findRestaurantByName(name);
        return new ResponseEntity<>(r,
                                    HttpStatus.OK);
    }

    // localhost:2019/restaurants/restaurant/state/st
    @GetMapping(value = "/restaurant/state/{findstate}",
                produces = "application/json")
    public ResponseEntity<?> findRestaurantByState(
            @PathVariable
                    String findstate)
    {
        List<Restaurant> rtnList = restaurantService.findByState(findstate);
        return new ResponseEntity<>(rtnList,
                                    HttpStatus.OK);
    }

    // localhost:2019/restaurants/restaurant/likename/eat
    @GetMapping(value = "/restaurant/likename/{restname}",
                produces = "application/json")
    public ResponseEntity<?> findRestaurantByNameLike(
            @PathVariable
                    String restname)
    {
        List<Restaurant> rtnList = restaurantService.findByNameLike(restname);
        return new ResponseEntity<>(rtnList,
                                    HttpStatus.OK);
    }

}
