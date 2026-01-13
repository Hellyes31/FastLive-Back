package Fastlive.stream;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "streamer_stats")
public class StreamerStatsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "twitch_user_id", nullable = false)
    private Long twitchUserId;

    @Column(name = "followers_count", nullable = false)
    private Long followersCount;

    @Column(name = "viewers_avg", nullable = false)
    private Long viewersAvg;

    @Column(name = "stream_start_hour", nullable = false)
    private Instant streamStartHour;

    @Column(name = "stream_end_hour", nullable = false)
    private Instant streamEndHour;

    @Column(name = "last_updated")
    private Instant lastUpdated;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTwitchUserId() {
        return twitchUserId;
    }

    public void setTwitchUserId(Long twitchUserId) {
        this.twitchUserId = twitchUserId;
    }

    public Long getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(Long followersCount) {
        this.followersCount = followersCount;
    }

    public Long getViewersAvg() {
        return viewersAvg;
    }

    public void setViewersAvg(Long viewersAvg) {
        this.viewersAvg = viewersAvg;
    }

    public Instant getStreamStartHour() {
        return streamStartHour;
    }

    public void setStreamStartHour(Instant streamStartHour) {
        this.streamStartHour = streamStartHour;
    }

    public Instant getStreamEndHour() {
        return streamEndHour;
    }

    public void setStreamEndHour(Instant streamEndHour) {
        this.streamEndHour = streamEndHour;
    }

    public Instant getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Instant lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
