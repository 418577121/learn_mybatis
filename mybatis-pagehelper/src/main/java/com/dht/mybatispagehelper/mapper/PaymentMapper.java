package com.dht.mybatispagehelper.mapper;

import com.dht.mybatispagehelper.entity.Payment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PaymentMapper {
    @Select("select * from payment")
    List<Payment> getAllPage();

    @Insert("insert into payment(serial) values(#{payment.serial})")
    int addPayment(@Param("payment") Payment payment);
}
