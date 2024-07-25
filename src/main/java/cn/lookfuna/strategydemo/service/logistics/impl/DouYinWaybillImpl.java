package cn.lookfuna.strategydemo.service.logistics.impl;

import cn.lookfuna.strategydemo.domain.dto.LogisticsCreateOrderDto;
import cn.lookfuna.strategydemo.domain.dto.LogisticsCreateOrderResDto;
import cn.lookfuna.strategydemo.domain.dto.WaybillCancelDto;
import cn.lookfuna.strategydemo.service.logistics.BaseLogisticsWaybill;
import cn.lookfuna.strategydemo.service.logistics.WaybillNameEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Title DouYinOrderUtils
 * @Description 抖音订单电子面单
 * @Version 1.0
 */
@Slf4j
@Component
public class DouYinWaybillImpl extends BaseLogisticsWaybill {



    @Override
    public String getWaybillName() {
        return WaybillNameEnum.DOU_YIN.getCode();
    }

    @Override
    public boolean useFlag(String customerOrderSource) {
        return "DOUYIN".equals(customerOrderSource) || "DYXD".equals(customerOrderSource) || "douyin".equals(customerOrderSource);
    }


    @Override
    public LogisticsCreateOrderResDto createOrder(LogisticsCreateOrderDto o) {
        log.info("通过 抖音 下单");
        return new LogisticsCreateOrderResDto("抖音");
    }

    @Override
    public boolean cancelOrder(WaybillCancelDto cancelDto) {
        return false;
    }
}
