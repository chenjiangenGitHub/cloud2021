package com.ccnu.springcloud.controller;


import com.ccnu.springcloud.entities.CommonResult;
import com.ccnu.springcloud.entities.Payment;
import com.ccnu.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderFeginController {

    @Autowired
    private PaymentFeignService paymentFeignService;


    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("consumer/payment/feign/timeout")
    public String paymentFeignTimeOut(){
        //默认feign客户端只等待1秒钟
        return paymentFeignService.paymentFeignTimeOut();
    }
}
