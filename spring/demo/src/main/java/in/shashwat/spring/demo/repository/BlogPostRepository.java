package in.shashwat.spring.demo.repository;

import in.shashwat.spring.demo.model.BlogPost;
import org.springframework.data.repository.ListCrudRepository;

public interface BlogPostRepository extends ListCrudRepository<BlogPost, Integer> {
}
