package com.pluralsight.NorthwindTradersAPI;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(@RequestParam(value = "country", defaultValue = "World") String country) {
        return "Hello " + country;
    }
}
