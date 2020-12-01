package spirng.mvcframework.Simple.Spring.App.repositories;

import org.springframework.data.repository.CrudRepository;
import spirng.mvcframework.Simple.Spring.App.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Integer> {
}
