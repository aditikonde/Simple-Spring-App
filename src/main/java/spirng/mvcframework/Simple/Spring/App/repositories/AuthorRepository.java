package spirng.mvcframework.Simple.Spring.App.repositories;

import org.springframework.data.repository.CrudRepository;
import spirng.mvcframework.Simple.Spring.App.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
}
