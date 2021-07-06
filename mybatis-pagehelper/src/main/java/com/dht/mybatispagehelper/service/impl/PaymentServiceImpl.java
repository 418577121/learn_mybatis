package com.dht.mybatispagehelper.service.impl;

import com.dht.mybatispagehelper.entity.Payment;
import com.dht.mybatispagehelper.mapper.PaymentMapper;
import com.dht.mybatispagehelper.service.PaymentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public PageInfo<Payment> getAllPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Payment> allPage = paymentMapper.getAllPage();
        PageInfo<Payment> pageInfo = new PageInfo<>(allPage);
        return pageInfo;
    }

    @Override
    public int addPayment(Payment payment) {
        return paymentMapper.addPayment(payment);
    }
}
