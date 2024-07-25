package cn.lookfuna.strategydemo.service.logistics.impl;

import cn.lookfuna.strategydemo.domain.dto.LogisticsCreateOrderDto;
import cn.lookfuna.strategydemo.domain.dto.LogisticsCreateOrderResDto;
import cn.lookfuna.strategydemo.domain.dto.WaybillCancelDto;
import cn.lookfuna.strategydemo.service.logistics.BaseLogisticsWaybill;
import cn.lookfuna.strategydemo.service.logistics.WaybillNameEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class JingDongWaybillImpl extends BaseLogisticsWaybill {



    @Override
    public String getWaybillName() {
        return WaybillNameEnum.JIN_DONG.getCode();
    }

    @Override
    public boolean useFlag(String customerOrderSource) {
        return "jingDong".equals(customerOrderSource) ;
    }

    @Override
    public LogisticsCreateOrderResDto createOrder(LogisticsCreateOrderDto o) {
        log.info("通过 京东 下单");
        return new LogisticsCreateOrderResDto("京东");
    }

    @Override
    public boolean cancelOrder(WaybillCancelDto cancelDto) {
        return false;
    }
}
