package com.example.springblog;

import org.springframework.stereotype.Controller;
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
}
