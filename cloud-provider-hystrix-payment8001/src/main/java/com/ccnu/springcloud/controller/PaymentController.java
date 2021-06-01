package com.ccnu.springcloud.controller;

import com.ccnu.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
//全局的fallback方法，如果使用单独的话，需要falllback方法需要和标注了注解方法的参数一致，全局的则不用
//@DefaultProperties(defaultFallback = "paymentInfo_TimeOutHandler")
public class PaymentController {

    @Autowired
    public PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;


    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id){
        String result=paymentService.paymentInfo_ok(id);
        log.info("****result:"+result);
        return result;
    }

    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    public String paymentInfoTimeOut(@PathVariable("id") Integer id){
        String result=paymentService.paymentInfoTimeOut(id);
        log.info("****result:"+result);
        return result;
    }


    //服务熔断
    @GetMapping(value = "/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result=paymentService.paymentCircuitBreaker(id);
        log.info("****result:"+result);
        return result;
    }



}
