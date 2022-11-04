package com.spring.core.view.impl;


import com.spring.core.model.PaymentHistory;
import com.spring.core.model.Transaksi;
import com.spring.core.model.Users;
import com.spring.core.repository.PaymentHistoryRepo;
import com.spring.core.repository.TransaksiRepo;
import com.spring.core.repository.UsersRepo;
import com.spring.core.view.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Status;
import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional

public class TransaksiPaymentImple implements TransaksiService {

    @Autowired
    public TransaksiRepo transaksiRepo;
    @Autowired
    public PaymentHistoryRepo paymentRepo;
//    @Autowired
//    public UsersRepo userRepo;


    @Override
    public Map save(Transaksi transaksi) {
        Map map = new HashMap();
        try {
            Transaksi save = transaksiRepo.save(transaksi);
//            Users users = userRepo.getbyID(iduser);
//            Users users = userRepo.save(transaksi.getUsers())
            map.put("data", save);
            map.put("code", "200");
            map.put("status", "success");
            return map;
        } catch (Exception e) {
            map.put("code", "500");
            map.put("status", "failed");
            return map;
        }

    }

    @Override
    public Map updateStatus(Transaksi transaksi) {
        Map map = new HashMap();
        try {
            Transaksi update = transaksiRepo.getbyID(transaksi.getId());
            update.setStatus(transaksi.getStatus());
            Transaksi doSave = transaksiRepo.save(update);

//            obj.setTenor(transaksi.getTenor());
//            obj.setTotal_pinjaman(transaksi.getTotal_pinjaman());
//            obj.setBunga_persen(transaksi.getBunga_persen());
            map.put("data", doSave);
            map.put("code", "200");
            map.put("status", "Update Sukses");

        } catch (Exception e) {
            e.printStackTrace();
            map.put("statusCode", "500");
            map.put("statusMessage", "failed");
            return map;
        }
        return map;
    }


    @Override
    public Page<Status> findByStatus(String status, Pageable pageable) {
        return null;
    }




}