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


import org.springframework.data.domain.Pageable;

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

    @PostMapping("")
    public ResponseEntity<Map> save(@RequestBody Transaksi objModel) {
        Map save = servis.save(objModel);
        return new ResponseEntity<Map>(save, HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<Map> update(@RequestBody Transaksi objModel ) {
        Map update = servis.updateStatus(objModel);
        return new ResponseEntity<Map>(update, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<Map>  getList() {
        Map map = new HashMap();
        map.put("data",transaksiRepo.findAll());
        map.put("code", "200");
        map.put("status", "success");
        return new ResponseEntity<Map>(map, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<Page<Transaksi>> list(
            @RequestParam() Integer page,
            @RequestParam() Integer size,
            @RequestParam() String status) {
        Pageable show_data = PageRequest.of(page, size);
        Page<Transaksi> list = transaksiRepo.findByStatusLike("%"+status+"%", show_data);
        return new ResponseEntity<Page<Transaksi>>(list, new HttpHeaders(), HttpStatus.OK);
    }



}
