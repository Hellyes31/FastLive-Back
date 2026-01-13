package Fastlive.user;

import Fastlive.oauth.OAuthTokenEntity;
import Fastlive.profile.ProfileSettingsEntity;
import Fastlive.stream.StreamSessionEntity;
import Fastlive.stream.StreamSettingsEntity;
import Fastlive.twitch.TwitchAccountEntity;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String username;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    // Relations

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private TwitchAccountEntity twitchAccount;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private StreamSettingsEntity streamSettings;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private ProfileSettingsEntity profileSettings;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<StreamSessionEntity> streamSessions;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<OAuthTokenEntity> oauthTokens;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}
