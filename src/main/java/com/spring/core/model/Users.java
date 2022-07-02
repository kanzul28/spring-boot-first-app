package com.spring.core.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@Table(name = "users")
public class Users {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;




    @Column(name = "username", nullable = false, length = 45)
    private String username;

    @Column(name = "password", nullable = false, length = 45)
    private String password;

    @Column(name = "is_active")
    private boolean is_active;

    @OneToMany(mappedBy = "users")
    private List<Transaksi> transaksi;

    @OneToOne(mappedBy = "users")
    private UserDetail user_detail;


}
