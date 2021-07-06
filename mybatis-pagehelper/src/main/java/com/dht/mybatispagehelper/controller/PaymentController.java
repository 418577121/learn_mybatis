package com.dht.mybatispagehelper.controller;

import com.dht.mybatispagehelper.config.RedisUtil;
import com.dht.mybatispagehelper.entity.Payment;
import com.dht.mybatispagehelper.service.PaymentService;
import com.github.pagehelper.PageInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Resource
    private RedisUtil redisUtil;

    @GetMapping("/getAllPage")
    public PageInfo<Payment> list(@RequestParam(value="pageNum",defaultValue="1")Integer pageNum, @RequestParam(value="pageSize",defaultValue="10")Integer pageSize) {
        PageInfo<Payment> allPage = paymentService.getAllPage(pageNum, pageSize);
        redisUtil.set("k1", allPage, 1000);
        return allPage;
    }

    @PostMapping("/addPayment")
    public ResponseEntity add(@RequestBody Payment payment) {
        int result = paymentService.addPayment(payment);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get")
    public PageInfo<Payment> list1() {
        if (redisUtil.get("k1") == null) {
            PageInfo<Payment> allPage = paymentService.getAllPage(1, 10);
            redisUtil.set("k1", allPage, 1000);
            return allPage;
        } else {
            PageInfo<Payment> all =  (PageInfo<Payment>) redisUtil.get("k1");
            return all;
        }
    }
}
