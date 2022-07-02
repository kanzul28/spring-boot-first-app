package com.spring.core.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_detail")
public class UserDetail {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_detail_id", referencedColumnName = "id")
    private Users users;

}
