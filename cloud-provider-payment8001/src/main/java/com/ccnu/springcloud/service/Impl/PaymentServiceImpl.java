package com.ccnu.springcloud.service.Impl;

import com.ccnu.springcloud.dao.PaymentDao;
import com.ccnu.springcloud.entities.Payment;
import com.ccnu.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    public int create(Payment payment){
        return paymentDao.create(payment);
    }


    public Payment getPaymentById( Long id){
        return paymentDao.getPaymentById(id);
    }
}
