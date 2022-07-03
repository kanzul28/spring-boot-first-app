package com.spring.core.view.impl;


import com.spring.core.model.PaymentHistory;
import com.spring.core.model.Transaksi;
import com.spring.core.model.Users;
import com.spring.core.repository.PaymentHistoryRepo;
import com.spring.core.repository.TransaksiRepo;
import com.spring.core.repository.UsersRepo;
import com.spring.core.view.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    public Map save(Transaksi transaksi, Long iduser, Long idpayt) {
        Map map = new HashMap();
        try {
            PaymentHistory payt = paymentRepo.getbyID(idpayt);
            transaksi.setPaymentHistory(payt);
//            Users users = userRepo.getbyID(iduser);
//            Users users = userRepo.save(transaksi.getUsers())
            Transaksi obj = transaksiRepo.save(transaksi);
            Transaksi save = transaksiRepo.save(obj);

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
    public Map updateStatus(Transaksi transaksi, Long iduser, Long idpayt) {
        Map map = new HashMap();
        try {
            PaymentHistory payt = paymentRepo.getbyID(idpayt);
            Transaksi obj = transaksiRepo.getByID(transaksi.getId());

            if(obj == null ){
                map.put("statusCode", "404");
                map.put("statusMessage", "Data id tidak ditemukan");
                return map;
            }

//            obj.setTenor(transaksi.getTenor());
//            obj.setTotal_pinjaman(transaksi.getTotal_pinjaman());
//            obj.setBunga_persen(transaksi.getBunga_persen());
            obj.setStatus("Lunas");
            obj.setPaymentHistory(payt);
            transaksiRepo.save(obj);

            map.put("data", obj);
            map.put("statusCode", "200");
            map.put("statusMessage", "Update Sukses");
            return map;

        } catch (Exception e) {
            e.printStackTrace();
            map.put("statusCode", "500");
            map.put("statusMessage", e);
            return map;
        }
    }



}