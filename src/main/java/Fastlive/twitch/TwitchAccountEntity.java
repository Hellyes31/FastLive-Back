package Fastlive.twitch;

import Fastlive.user.UserEntity;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "twitch_accounts")
public class TwitchAccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private UserEntity user;

    @Column(name = "twitch_user_id", nullable = false, unique = true)
    private Long twitchUserId;

    @Column(name = "twitch_login", nullable = false)
    private String twitchLogin;

    @Column(name = "display_name", nullable = false)
    private String displayName;

    @Column(name = "profileImageUrl", nullable = false)
    private String profileImageUrl;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Long getTwitchUserId() {
        return twitchUserId;
    }

    public void setTwitchUserId(Long twitchUserId) {
        this.twitchUserId = twitchUserId;
    }

    public String getTwitchLogin() {
        return twitchLogin;
    }

    public void setTwitchLogin(String twitchLogin) {
        this.twitchLogin = twitchLogin;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
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
