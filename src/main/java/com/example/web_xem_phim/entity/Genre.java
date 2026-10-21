package com.example.web_xem_phim.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_genre")
    private int idGenre;
    @Column(name = "genre_name",length = 256)
    private String genreName;
    @Column(name = "slug",length = 256)
    private String slug;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH,
    } )
    @JoinTable(
            name= "movie_genre",
            joinColumns = @JoinColumn(name = "id_genre"),
            inverseJoinColumns = @JoinColumn(name = "id_movie")
    )
    private List<Movie> movieList;


}
