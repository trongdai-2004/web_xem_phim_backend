package com.example.web_xem_phim.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.apachecommons.CommonsLog;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "user")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int idUser;
    @Column(name = "username", length = 256)
    private String username;
    @Column(name="password", length = 512)
    private String password;
    @Column(name = "firstname", length = 256)
    private String firstName;
    @Column(name = "lastname", length = 256)
    private String lastName;
    @Column(name = "email", length = 256)
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "gender")
    private char gender;
    @Column(name = "avatar", columnDefinition = "LONGTEXT")
    @Lob
    private String avatar;
    @Column(name ="is_vip")
    private boolean isVip;
    @Column(name="vip_expriration_date")
    private Date vipExprirationDate;


    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH,
    } )
    @JoinTable(
            name= "user_role",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_role")
    )


    private List<Role> roleList;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH,
    })
    private List<Review>reviewList;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<FavoriteMovie>favoriteMovieList;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<WatchHistory>wathHistoryList;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH,
    })
    private List<SubscriptionOrder>subscriptionOrderList;

}
