package com.example.web_xem_phim.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "subscription_plan")
public class SubscriptionPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plan")
    private int idPlan;
    @Column(name = "plan_name", length = 256)
    private String planName;
    @Column(name = "description", length = 512)
    private String description;
    @Column(name = "duration_days")
    private int durationDays;
    @Column(name="price")
    private double price;
    @OneToMany(mappedBy = "subscriptionPlan", fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH,
    })
    private List<SubscriptionOrder>subscriptionOderList;

}
