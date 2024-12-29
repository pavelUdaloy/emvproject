package elizaveta.management.viden.project.rep;

import elizaveta.management.viden.project.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Integer> {

    @Modifying
    @Query("DELETE FROM RefreshToken rt WHERE rt.user.id = :userId")
    void removeByUserId(int userId);

    @Query("SELECT rt FROM RefreshToken rt " +
            "WHERE rt.token = :token " +
            "AND rt.expiredAt > :to")
    Optional<RefreshToken> findByTokenAndTime(String token, LocalDateTime to);

    @Modifying
    @Query(value = "DELETE FROM refresh_tokens WHERE expired_at < :to", nativeQuery = true)
    void removeByExpirationTime(String to);
}