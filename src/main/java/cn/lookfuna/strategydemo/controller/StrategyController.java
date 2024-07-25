package cn.lookfuna.strategydemo.controller;

import cn.lookfuna.strategydemo.domain.dto.LogisticsCreateOrderDto;
import cn.lookfuna.strategydemo.domain.dto.LogisticsCreateOrderResDto;
import cn.lookfuna.strategydemo.service.logistics.LogisticWaybillExec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title StrategyController
 * @Description 接口
 * @Version 1.0
 */
@RestController
@RequestMapping("/execute")
public class StrategyController {

    @Autowired
    LogisticWaybillExec logisticWaybillExec;

    @GetMapping("/{strategyName}")
    public String executeStrategy(@PathVariable String strategyName) {
        LogisticsCreateOrderResDto order = logisticWaybillExec.createOrder(strategyName, new LogisticsCreateOrderDto());
        return "来源: " + order.getRemark();
    }
}
