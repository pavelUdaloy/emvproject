package elizaveta.management.viden.project.config.security;

import elizaveta.management.viden.project.entity.User;
import elizaveta.management.viden.project.rep.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    /**
     * Load admin details by admin email.
     *
     * @param email the username identifying the user whose data is required
     * @return email, password and role
     */
    @Override
    @Transactional(readOnly = true)
    public AccountDetails loadUserByUsername(String email) {
        Optional<User> user = userRepository.findByLogin(email);

        if (user.isEmpty()) {
            throw new RuntimeException("User with email " + email + " cannot find.");
        }

        return AccountDetails.fromAccountToAccountDetails(user.get());
    }
}
