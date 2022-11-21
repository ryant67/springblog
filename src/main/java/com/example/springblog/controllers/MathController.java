package com.example.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/add/{numOne}/and/{numTwo}")
    @ResponseBody
    //Changed the public int --> public String to allow concatenation explaining the math equation.
    public String add(@PathVariable int numOne, @PathVariable int numTwo) {
        return "The sum of " + numOne + " and " + numTwo + " = " + (numOne + numTwo);
    }

    @GetMapping("/subtract/{numThree}/from/{numFour}")
    @ResponseBody
    public int subtract(@PathVariable int numThree, @PathVariable int numFour) {
        return numFour - numThree;
    }

    @GetMapping("/multiply/{numFive}/and/{numSix}")
    @ResponseBody
    public int multiply(@PathVariable int numFive, @PathVariable int numSix) {
        return numFive * numSix;
    }

    @GetMapping("/divide/{numSeven}/by/{numEight}")
    @ResponseBody
    public double divide(@PathVariable double numSeven, @PathVariable double numEight) {
        return numSeven / numEight;
    }
}
