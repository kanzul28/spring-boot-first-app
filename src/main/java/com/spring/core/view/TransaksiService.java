package com.spring.core.view;

import com.spring.core.model.Transaksi;

import java.util.Map;

public interface TransaksiService {
    public Map save(Transaksi transaksi,Long idpayt);
    public Map updateStatus(Transaksi transaksi,Long idpayt);

}
