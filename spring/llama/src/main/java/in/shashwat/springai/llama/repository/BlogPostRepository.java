package in.shashwat.springai.llama.repository;

import in.shashwat.springai.llama.model.BlogPost;
import org.springframework.data.repository.ListCrudRepository;

public interface BlogPostRepository extends ListCrudRepository<BlogPost, Integer> {
}
