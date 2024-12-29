package elizaveta.management.viden.project.config.security;

import elizaveta.management.viden.project.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AccountDetails implements UserDetails {

    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> grantedAuthorities;

    public static AccountDetails fromAccountToAccountDetails(User user) {
        AccountDetails accountDetails = new AccountDetails();
        accountDetails.email = user.getEmail();
        accountDetails.password = user.getPassword();
        accountDetails.grantedAuthorities = List.of(new SimpleGrantedAuthority(user.getTitle()));
        return accountDetails;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.unmodifiableCollection(grantedAuthorities);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
