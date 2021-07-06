package com.dht.mybatispagehelper.service;

import com.dht.mybatispagehelper.entity.Payment;
import com.github.pagehelper.PageInfo;

public interface PaymentService {
    PageInfo<Payment> getAllPage(Integer pageNum, Integer pageSize);

    int addPayment(Payment payment);
}
