package com.pluralsight.demoWeb;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

//    @RequestMapping(path="/", method = RequestMethod.GET)
//    public String index(){
//        return "Hellow Spring World";
//    }

    @RequestMapping(path="/", method = RequestMethod.GET)
    public String index(@RequestParam(defaultValue = "Spring World") String name){
        return "Hello " + name;
    }
}
