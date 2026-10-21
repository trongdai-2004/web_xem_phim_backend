package com.example.web_xem_phim.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;


@Entity
@Data
@Table(name ="watch_history")
public class WatchHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_history")
    private long idHistory;
    @Column(name ="watched_Seconds")
    private int watchedSeconds;
    @Column(name = "is_completed")
    private boolean isCompleted;
    @Column(name = "updated_at")
    private Timestamp updatedAt;
    @ManyToOne(cascade = {
            CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.DETACH,CascadeType.REFRESH

    })
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @ManyToOne(cascade = {
            CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.DETACH,CascadeType.REFRESH

    })
    @JoinColumn(name = "id_episode", nullable = false)
    private Episode episode;
}
