package com.example.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FirstController {
    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "Hello from Spring!";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/bubbles")
    @ResponseBody
    public String bubbles() {
        return "buububuu!";
    }

    @GetMapping("/greeting/{name}")
    @ResponseBody
    public String greeting(@PathVariable String name) {
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
