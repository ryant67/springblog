package com.example.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String posts() {
        return "You are now viewing all Posts!";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String indPosts(@PathVariable long id) {
        return "You are now viewing a Post with the ID of " + id + "!";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createPostForm() {
        return "You are now viewing the form to create a new Post!";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return "You have now created a new Post!";
    }
}
