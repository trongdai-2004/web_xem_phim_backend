package com.example.web_xem_phim.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Entity
@Data
@Table(name = "movie")
public class Movie {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id_movie")
        private int idMovie;
        @Column(name = "title", length = 256)
        private String title;
        @Column(name = "slug", length = 256)
        private String slug;
        @Column(name = "director", length = 256)
        private String director;
        @Column(name = "actors", length = 512)
        private String actors;
        @Column(name = "description", columnDefinition = "text")
        private String description;
        @Column(name = "release_year")
        private int releaseYear;
        @Column(name ="duration_minutes")
        private int durationMinutes;
        @Column(name = "country")
        private String country;
        @Column(name = "poster_url", length = 512)
        private String posterUrl;
        @Column(name = "banner_url", length = 512)
        private String bannerUrl;
        @Column(name = "trailer_url", length = 512)
        private String trailerUrl;
        @Column(name = "is_series")
        private boolean isSeries;
        @Column(name = "is_vip")
        private boolean isVip;
        @Column(name = "view_count")
        private long viewCount;
        @Column(name = "average_rating")
        private double averageRating;
        @Column(name = "created_date")
        private Date createdDate;


        @ManyToMany(fetch = FetchType.LAZY, cascade = {
                CascadeType.PERSIST, CascadeType.MERGE,
                CascadeType.DETACH, CascadeType.REFRESH,
        } )
        @JoinTable(
                name= "movie_genre",
                joinColumns = @JoinColumn(name = "id_movie"),
                inverseJoinColumns = @JoinColumn(name = "id_genre")
        )
        private List<Genre> genreList;

        @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private List<Episode> episodeList;
        @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private List<Review>reviewList;
        @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private List<FavoriteMovie>favoriteMovieList;

    }

