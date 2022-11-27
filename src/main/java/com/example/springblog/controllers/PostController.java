package com.example.springblog.controllers;

import com.example.springblog.models.Post;
import com.example.springblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import java.util.List;

@Controller
public class PostController {

    private PostRepository postDao;
    private UserRepository userDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @GetMapping("/posts")
    public String posts(Model model) {
        //Instantiates the list to hold all the Post Objects
        List<Post> allPosts = postDao.findAll();
        model.addAttribute("allPosts", allPosts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String idPosts(@PathVariable long id, Model model) {
        Post idPosts = postDao.getById(id);
        model.addAttribute("post", idPosts);
        return "posts/show";
    }

//    NOT USING FORM MODEL BINDING:
//    @GetMapping("/posts/create")
//    public String createPostForm() {
//        return "posts/create";
//    }

    //USING FORM MODEL BINDING:
    @GetMapping("/posts/create")
    public String createPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

//    NOT USING FORM MODEL BINDING
//    @PostMapping("/posts/create")
//    public String createPost(@RequestParam(name="title")String title, @RequestParam(name="description")String description) {
//        Post post = new Post();
//        post.setTitle(title);
//        post.setBody(description);
//        User user = userDao.getById(1L);
////        User user = userDao.findById(1L);
//        post.setUser(user);
//        postDao.save(post);
//        return "redirect:/posts";
//    }

    //USING FORM MODEL BINDING
    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {
        User user = getById(1L);
        //User user = userDao.getReferenceById(1L);
        post.setUser(user);
        postDao.save(post);
        return "redirect:/posts";
    }

    @Getmapping("/posts/{id}/edit")
    public String editPost(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.getReferenceById(id));
        return "posts/editPost";
    }

    @PostMapping("/posts/edit")
    public String editPost(@ModelAttribute Post post) {
        System.out.println(post.getId());
        User user = userDao.getById(1L);
        post.setUser(user);
        //post.setId(post);
        post.Dao.save(post);
        return "redirect:/posts";
    }
}
