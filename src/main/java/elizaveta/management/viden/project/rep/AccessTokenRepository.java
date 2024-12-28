package elizaveta.management.viden.project.rep;

import elizaveta.management.viden.project.entity.AccessToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface AccessTokenRepository extends JpaRepository<AccessToken, Integer> {

    @Modifying
    @Query("DELETE FROM AccessToken at WHERE at.user.id = :userId")
    void removeByUserId(int userId);

    @Query("SELECT at FROM AccessToken at " +
            "WHERE at.token = :token " +
            "AND at.user.email = :email " +
            "AND at.expiredAt > :to")
    Optional<AccessToken> findByLoginAndToken(String email, String token, LocalDateTime to);
}