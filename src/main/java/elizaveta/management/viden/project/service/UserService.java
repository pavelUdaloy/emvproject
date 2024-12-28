package elizaveta.management.viden.project.service;

import elizaveta.management.viden.project.entity.User;
import elizaveta.management.viden.project.rep.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User checkAndCreate(String email, String password, String title, String firstName, String lastName) {
        Optional<User> optionalUser = userRepository.findByLogin(email);
        if (optionalUser.isPresent()) {
            log.error("User with email {} already exists", email);
            throw new RuntimeException("User with email " + email + " already exists");
        }
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setTitle(title);
        user.setFirstName(firstName);
        user.setLastName(lastName);

        try {
            return userRepository.save(user);
        } catch (Exception e) {
            log.error("Error per saving new user to db, email = {}", email);
            throw new RuntimeException("Error per saving new user to db");
        }
    }

    @Transactional(readOnly = true)
    public User findByEmail(String email) {
        Optional<User> user = userRepository.findByLogin(email);
        if (user.isEmpty()) {
            log.error("Cannot find user with email = {}", email);
            throw new UsernameNotFoundException("Cannot find user with email = " + email);
        }
        return user.get();
    }

    @Transactional(readOnly = true)
    public User checkAccount(String email, String password) {
        User user = findByEmail(email);

        if (!user.getPassword().equals(password)) {
            log.error("Password for user with email {} not correct", email);
            throw new RuntimeException("Password for user with email " + email + " not correct");
        }

        return user;
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
