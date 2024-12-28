package elizaveta.management.viden.project.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "access_tokens")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccessToken {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "access_tokens_seq")
    @SequenceGenerator(name = "access_tokens_seq", sequenceName = "access_tokens_SEQ", allocationSize = 1)
    private int id;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false, name = "created_at")
    private LocalDateTime createdAt;

    @Column(nullable = false, name = "expired_at")
    private LocalDateTime expiredAt;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER) // todo lazy
    @JoinColumn(name = "user_id", referencedColumnName = "id", columnDefinition = "UUID")
    private User user;

    @OneToOne(mappedBy = "accessToken", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    // todo lazy
    private RefreshToken refreshToken;
}
