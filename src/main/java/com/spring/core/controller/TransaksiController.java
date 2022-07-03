package com.spring.core.controller;


import com.spring.core.model.Transaksi;
import com.spring.core.repository.PaymentHistoryRepo;
import com.spring.core.repository.TransaksiRepo;
import com.spring.core.view.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/transaksi/")

public class TransaksiController {

    @Autowired
    public TransaksiRepo transaksiRepo;

    @Autowired
    public PaymentHistoryRepo paymentHistoryRepo;

    @Autowired
    public TransaksiService servis;

    @PostMapping("/save/{idpayment}")
    public ResponseEntity<Map> save(@PathVariable(value = "idpayment") Long idpayment, @RequestBody Transaksi objModel) {
        Map map = new HashMap();
        Map obj = servis.save(objModel, idpayment);
        return new ResponseEntity<Map>(obj, HttpStatus.OK);
    }

    @PutMapping("/update/{idpayment")
    public ResponseEntity<Map> update(@PathVariable(value = "idpayment") Long idpayment, @RequestBody Transaksi objModel ) {
        Map map = servis.updateStatus(objModel, idpayment);
        return new ResponseEntity<Map>(map, HttpStatus.OK);
    }

    @GetMapping("/listByStatusLike")
    public ResponseEntity<Page<Transaksi>> listByStatusLike(
            @RequestParam() Integer page,
            @RequestParam() Integer size,
            @RequestParam() String status) {
        Pageable show_data = (Pageable) PageRequest.of(page, size);
        Page<Transaksi> list = transaksiRepo.findByStatusLike("%"+status+"%", show_data);
        return new ResponseEntity<Page<Transaksi>>(list, new HttpHeaders(), HttpStatus.OK);
    }



}
