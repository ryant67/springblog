package com.example.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @RequestMapping(method = RequestMethod.GET, path = "/posts")
    @ResponseBody
    public String posts() {
        return "You are now viewing all Posts!";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/posts/{id}")
    @ResponseBody
    public String indPosts(@PathVariable int id) {
        return "You are now viewing a Post with the ID of " + id + "!";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/posts/create")
    @ResponseBody
    public String createPostForm() {
        return "You are now viewing the form to create a new Post!";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/posts/create")
    @ResponseBody
    public String createPost() {
        return "You have now created a new Post!";
    }

}
