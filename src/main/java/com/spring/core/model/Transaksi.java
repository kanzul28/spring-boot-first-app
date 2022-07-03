package com.spring.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;



import javax.persistence.*;

@Data
@Entity
@Table(name = "transaksi")
public class Transaksi {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "tenor",length = 11)
    private int tenor;

    @Column(name = "total_pinjaman")
    private double total_pinjaman;

    @Column(name = "bunga_persen")
    private double bunga_persen;

    @Column(name = "status", nullable = false, length = 45)
    private String status;

    @JsonIgnore
    @ManyToOne(targetEntity = Users.class, cascade = CascadeType.ALL)
    private Users users;

//    @ManyToOne
//    @JoinColumn(name = "payment_hystory_id")
//    PaymentHistory payment_history;


    @JsonIgnore
    @ManyToOne(targetEntity = PaymentHistory.class, cascade = CascadeType.ALL)
    private PaymentHistory paymentHistory;












}
