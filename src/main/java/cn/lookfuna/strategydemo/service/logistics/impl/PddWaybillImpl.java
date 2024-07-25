package cn.lookfuna.strategydemo.service.logistics.impl;

import cn.lookfuna.strategydemo.domain.dto.LogisticsCreateOrderDto;
import cn.lookfuna.strategydemo.domain.dto.LogisticsCreateOrderResDto;
import cn.lookfuna.strategydemo.domain.dto.WaybillCancelDto;
import cn.lookfuna.strategydemo.service.logistics.BaseLogisticsWaybill;
import cn.lookfuna.strategydemo.service.logistics.WaybillNameEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * @Title PddWaybillImpl
 * @Description 拼多多电子面单接口实现类
 * @Version 1.0
 */
@Slf4j
@Component
public class PddWaybillImpl extends BaseLogisticsWaybill {
    @Override
    public String getWaybillName() {
        return WaybillNameEnum.PDD.getCode();
    }

    /**
     * 是否使用此实现类
     * @param customerOrderSource   客户订单来源
     * @return                      是否
     */
    @Override
    public boolean useFlag(String customerOrderSource) {
        return "pdd".equals(customerOrderSource) ;
    }

    @Override
    public LogisticsCreateOrderResDto createOrder(LogisticsCreateOrderDto o) {
        log.info("通过 拼多多 下单");
        return new LogisticsCreateOrderResDto("拼多多");
    }

    @Override
    public boolean cancelOrder(WaybillCancelDto cancelDto) {
        return false;
    }
}
