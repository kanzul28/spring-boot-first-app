package com.spring.core.view;

import com.spring.core.model.Transaksi;

import java.util.Map;

public interface TransaksiService {
    public Map save(Transaksi obj);
    public Map updateStatus(Transaksi obj);

}
