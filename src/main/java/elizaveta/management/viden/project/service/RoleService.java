package elizaveta.management.viden.project.service;

import elizaveta.management.viden.project.entity.Role;
import elizaveta.management.viden.project.rep.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    @Transactional(readOnly = true)
    public Role findById(int id) {
        Optional<Role> role = roleRepository.findById(id);
        if (role.isEmpty()) {
            log.error("Cannot find role with id = {}", id);
            throw new UsernameNotFoundException("Cannot find role with id = " + id);
        }
        return role.get();
    }

    @Transactional(readOnly = true)
    public Role findByName(String name) {
        Optional<Role> role = roleRepository.findByName(name);
        if (role.isEmpty()) {
            log.error("Cannot find role with name = {}", name);
            throw new UsernameNotFoundException("Cannot find role with name = " + name);
        }
        return role.get();
    }
}
