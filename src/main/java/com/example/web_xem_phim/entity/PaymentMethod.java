package com.example.web_xem_phim.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "payment_method")
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_payment_method")
    private int idPaymentMethod;
    @Column(name = "payment_name", length = 256)
    private String paymentName;
    @Column(name = "description",length = 512)
    private String description;
    @Column(name = "payment_fee")
    private double paymentFee;
    @OneToMany(mappedBy = "paymentMethod", fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH,
    })
    private List<SubscriptionOrder> subscriptionOrderList;

}
