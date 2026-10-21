package com.example.web_xem_phim.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "episode")
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_episode")
    private int idEpisode;
    @Column(name="episode_number")
    private int episodeNumber;
    @Column(name= "episode_title", length = 256)
    private String episodeTitle;
    @Column(name = "video_url", length = 512)
    private String videoUrl;
    @Column(name="subtitle_url", length = 512)
    private String subtitleUrl;
    @Column(name = "duration_seconds")
    private int durationSeconds;
    @ManyToOne(cascade = {
            CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.DETACH,CascadeType.REFRESH

    })
    @JoinColumn(name = "id_movie", nullable = false)
    private Movie movie;
    @OneToMany(mappedBy = "episode", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<WatchHistory> watchHistoryList;
}
