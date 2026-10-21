package com.example.web_xem_phim.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "subscription_order")
public class SubscriptionOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private int idOrder;
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "total_price")
    private double totalPrice;
    @Column(name = "payment_status")
    private String paymentStatus;
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
    @JoinColumn(name = "id_plan", nullable = false)
    private SubscriptionPlan subscriptionPlan;

    @ManyToOne(cascade = {
            CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.DETACH,CascadeType.REFRESH

    })
    @JoinColumn(name = "id_payment_method", nullable = false)
    private PaymentMethod paymentMethod;

}
