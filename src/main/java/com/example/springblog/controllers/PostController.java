package com.example.springblog.controllers;

import com.example.springblog.models.Post;
import com.example.springblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

    private PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String posts(Model model) {
        List<Post> allPosts = postDao.findAll();
        model.addAttribute("allPosts", allPosts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String indPosts(@PathVariable long id) {
        return "You are now viewing a Post with the ID of " + id + "!";
    }

    @GetMapping("/posts/create")
    public String createPostForm() {
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@RequestParam(name="title")String title, @RequestParam(name="description")String description) {
        Post post = new Post();
        post.setTitle(title);
        post.setBody(description);
        postDao.save(post);
        return "redirect:/posts";
    }
}
