package com.spring.core.repository;


import com.spring.core.model.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface TransaksiRepo extends JpaRepository<Transaksi, Long> {
    @Query("select c from Transaksi c")
    public List<Transaksi> getList();

    @Query("select c from Transaksi c WHERE c.id = :id")
    public Transaksi getByID(@Param("id") Long id);


}
