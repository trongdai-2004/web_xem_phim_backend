package com.example.web_xem_phim.entity;

import jakarta.persistence.*;

import lombok.Data;

import java.sql.Timestamp;


@Entity
@Data
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_review")
    private long idReview;
    @Column(name = "rating_point")
    private float ratingPoint;
    @Column(name = "comment", columnDefinition = "text")
    private String comment;
    @Column(name = "created_at")
    private Timestamp createdAt;

    @ManyToOne(cascade = {
            CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.DETACH,CascadeType.REFRESH

    })
    @JoinColumn(name = "id_movie", nullable = false)
    private Movie movie;


    @ManyToOne(cascade = {
            CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.DETACH,CascadeType.REFRESH

    })
    @JoinColumn(name = "id_user", nullable = false)

    private User user;

}
