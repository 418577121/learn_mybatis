package com.dht;

import com.dht.entity.Payment;
import com.dht.mapper.PaymentMapper;
import org.apache.ibatis.datasource.DataSourceFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {
    @Test
    public void test() {
        System.out.println("我是junit测试!");
    }

    @Test
    public void init() throws IOException {
        // 使用配置类创建 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            PaymentMapper mapper = session.getMapper(PaymentMapper.class);
            Payment blog = mapper.selectPayment(1);
            System.out.println(blog);
        }
    }

    @Test
    public void javaCode() {
    }

}
