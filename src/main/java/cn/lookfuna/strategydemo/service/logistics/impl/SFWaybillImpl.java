package cn.lookfuna.strategydemo.service.logistics.impl;

import cn.lookfuna.strategydemo.domain.dto.LogisticsCreateOrderDto;
import cn.lookfuna.strategydemo.domain.dto.LogisticsCreateOrderResDto;
import cn.lookfuna.strategydemo.domain.dto.WaybillCancelDto;
import cn.lookfuna.strategydemo.service.logistics.BaseLogisticsWaybill;
import cn.lookfuna.strategydemo.service.logistics.WaybillNameEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Title SFWaybailImpl
 * @Description 顺丰
 * @Version 1.0
 */
@Slf4j
@Component
public class SFWaybillImpl extends BaseLogisticsWaybill {

    @Override
    public String getWaybillName() {
        return WaybillNameEnum.SF.getCode();
    }

    @Override
    public boolean useFlag(String customerOrderSource) {
        return false;
    }


    @Override
    public LogisticsCreateOrderResDto createOrder(LogisticsCreateOrderDto o) {
        log.info("通过 顺丰 下单");
        return new LogisticsCreateOrderResDto("顺丰");
    }

    @Override
    public boolean cancelOrder(WaybillCancelDto cancelDto) {
        return false;
    }
}
