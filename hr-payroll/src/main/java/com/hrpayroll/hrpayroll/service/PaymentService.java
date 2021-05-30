package com.hrpayroll.hrpayroll.service;

import com.hrpayroll.hrpayroll.entity.Payment;
import com.hrpayroll.hrpayroll.entity.Worker;
import com.hrpayroll.hrpayroll.feignClients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(long workerId, int days) {
        Worker worker = workerFeignClient.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
