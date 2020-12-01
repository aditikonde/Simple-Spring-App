package spirng.mvcframework.Simple.Spring.App.repositories;

import org.springframework.data.repository.CrudRepository;
import spirng.mvcframework.Simple.Spring.App.model.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
}
