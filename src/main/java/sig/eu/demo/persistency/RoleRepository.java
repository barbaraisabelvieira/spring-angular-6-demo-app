package sig.eu.demo.persistency;

import org.springframework.data.jpa.repository.JpaRepository;
import sig.eu.demo.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

    @Override
    void delete(Role role);

}
