package com.spring.core.view;

import com.spring.core.model.Transaksi;
import org.springframework.data.domain.Page;

import javax.transaction.Status;
import java.awt.print.Pageable;
import java.util.Map;

public interface TransaksiService {
    public Map save(Transaksi transaksi);
    public Map updateStatus(Transaksi transaksi, Long id);

    Page<Status> findByStatus(String status, Pageable pageable);

}
