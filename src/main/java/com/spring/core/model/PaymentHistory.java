package com.spring.core.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "payment_history")

public class PaymentHistory {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pembayaran_ke",length = 11)
    private int pembayaran_ke;

    @Column(name = "jumlah")
    private double jumlah;

    @Column(name = "bukti_pembayaran", nullable = false, length = 45)
    private String bukti_pembayaran;

    @OneToMany(mappedBy = "payment_history")
    private List<Transaksi> transaksi;


}
