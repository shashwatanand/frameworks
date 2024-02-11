package in.shashwat.spring.demo.controller;

import in.shashwat.spring.demo.model.BlogPost;
import in.shashwat.spring.demo.repository.BlogPostRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/blogposts")
public class BlogPostController {
    private BlogPostRepository blogRepository;

    public BlogPostController(BlogPostRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @GetMapping
    public List<BlogPost> findAll() {
        return blogRepository.findAll();
    }
}
