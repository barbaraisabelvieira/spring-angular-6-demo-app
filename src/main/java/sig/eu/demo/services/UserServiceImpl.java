package sig.eu.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sig.eu.demo.entities.User;
import sig.eu.demo.persistency.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl { //implements UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    //@Override
    public User create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    //@Override
    public User delete(int id) {
        User user = findById(id);
        if (user != null) {
            repository.delete(user);
        }
        return user;
    }

    //@Override
    public List findAll() {
        return repository.findAll();
    }

    //@Override
    public User findById(int id) {
        Optional<User> user = repository.findById(id);
        return ((Optional)user).isPresent() ? user.get() : new User();
    }

    //@Override
    public User update(User user) {
        return null;
    }

    //@Override
    public boolean authenticate(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        System.out.println("[User]" + user.toString());
        Optional<User> tmp = repository.findByEmail(user.getEmail());
        if (((Optional)tmp).isPresent()) {
            System.out.println("[User found]" + tmp.toString());
            boolean result = tmp.get().getPassword().equals(user.getPassword());
            System.out.println("[Result]" + result);

            return tmp.get().getPassword().equals(user.getPassword());
        }
        return false;
    }
}
