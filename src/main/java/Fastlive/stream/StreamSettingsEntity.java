package Fastlive.stream;

import Fastlive.user.UserEntity;
import jakarta.persistence.*;


@Entity
@Table(name = "stream_settings")
public class StreamSettingsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private UserEntity user;

    @Column(name = "stream_title", nullable = false)
    private String streamTitle;

    @Column(name = "stream_description")
    private String streamDescription;

    @Column(name = "game_category_id", nullable = false)
    private Long gameCategoryId;

    @Column
    private String tags;

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

    public String getStreamTitle() {
        return streamTitle;
    }

    public void setStreamTitle(String streamTitle) {
        this.streamTitle = streamTitle;
    }

    public String getStreamDescription() {
        return streamDescription;
    }

    public void setStreamDescription(String streamDescription) {
        this.streamDescription = streamDescription;
    }

    public Long getGameCategoryId() {
        return gameCategoryId;
    }

    public void setGameCategoryId(Long gameCategoryId) {
        this.gameCategoryId = gameCategoryId;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
