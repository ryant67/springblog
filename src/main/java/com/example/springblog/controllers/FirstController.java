package com.example.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//Controller - informing our compiler that this class contains methods for our URL Patterns.
@Controller
public class FirstController {

    //GetMapping - controls GET requests made to a specific URL Pattern.
    @GetMapping("/test")
    //ResponseBody - which returns a String as the response when visiting the URL Pattern.
    @ResponseBody
    //The method that is executed when visiting the URL Pattern.
    public String test() {
        return "Hello from Spring!";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/bubbles")
    @ResponseBody
    public String bubbles() {
        return "buububuu!";
    }

    //Establishing PathVariables in the URL Pattern with curly braces.
    @GetMapping("/greeting/{name}")
    @ResponseBody
    //@PathVariable Annotation used to grab the value of the PathVariable.
    public String greeting(@PathVariable String name) {
        //Implementing the PathVariable with concatenation.
        return "Greetings " + name;
    }

    @GetMapping("/roll-dice")
    public String numSelection() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String resultsPage(@PathVariable int n, Model model) {
        int randomNumber = (int) Math.floor(Math.random() * ((7 - 1) + 1));

        boolean results = n == randomNumber;

        model.addAttribute("results", results);
        model.addAttribute("randomNumber", randomNumber);

        return "roll-dice";
    }
}
