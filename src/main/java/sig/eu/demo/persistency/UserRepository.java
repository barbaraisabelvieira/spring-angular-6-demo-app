package sig.eu.demo.persistency;

import org.springframework.data.repository.CrudRepository;
import sig.eu.demo.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository  extends CrudRepository<User, Integer> {

    void delete(User user);

    List<User> findAll();

    User save(User user);

    Optional<User> findByEmail(String email);

    Optional<User> findById(int id);


}
