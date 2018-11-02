package sig.eu.demo.persistency;

import org.springframework.data.jpa.repository.JpaRepository;
import sig.eu.demo.entities.Privilege;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

    Privilege findByName(String name);

    @Override
    void delete(Privilege privilege);

}
