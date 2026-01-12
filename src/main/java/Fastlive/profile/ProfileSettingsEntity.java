package Fastlive.profile;


import Fastlive.user.UserEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.util.Map;

@Entity
@Table(name = "profile_settings")
public class ProfileSettingsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private UserEntity user;

    @Column(nullable = false)
    private String bio;

    @Column(name = "banner_image", nullable = false)
    private String bannerImage;

    @Column(name = "avatar_image", nullable = false)
    private String avatarImage;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "social_links", nullable = false)
    private Map<String, Object> socialLinks;

    // getters / setters

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

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getBannerImage() {
        return bannerImage;
    }

    public void setBannerImage(String bannerImage) {
        this.bannerImage = bannerImage;
    }

    public String getAvatarImage() {
        return avatarImage;
    }

    public void setAvatarImage(String avatarImage) {
        this.avatarImage = avatarImage;
    }

    public Map<String, Object> getSocialLinks() {
        return socialLinks;
    }

    public void setSocialLinks(Map<String, Object> socialLinks) {
        this.socialLinks = socialLinks;
    }
}
