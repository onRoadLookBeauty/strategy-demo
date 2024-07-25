package cn.lookfuna.strategydemo.service.logistics.impl;

import cn.lookfuna.strategydemo.domain.dto.LogisticsCreateOrderDto;
import cn.lookfuna.strategydemo.domain.dto.LogisticsCreateOrderResDto;
import cn.lookfuna.strategydemo.domain.dto.WaybillCancelDto;
import cn.lookfuna.strategydemo.service.logistics.BaseLogisticsWaybill;
import cn.lookfuna.strategydemo.service.logistics.WaybillNameEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Title KuaiShouUtils
 * @Description 快手电子面单相关工具
 * @Version 1.0
 */
@Slf4j
@Component
public class KuaiShouWaybillImpl extends BaseLogisticsWaybill {

    @Override
    public String getWaybillName() {
        return WaybillNameEnum.KUAI_SHOU.getCode();
    }

    /**
     * 快手的暂时不用
     * @param customerOrderSource   客户订单来源
     */
    @Override
    public boolean useFlag(String customerOrderSource) {
        return "KSXD".equals(customerOrderSource) || "KS".equals(customerOrderSource);
    }

    @Override
    public LogisticsCreateOrderResDto createOrder(LogisticsCreateOrderDto o) {
        log.info("通过 快手 下单");
        return new LogisticsCreateOrderResDto("快手");
    }

    @Override
    public boolean cancelOrder(WaybillCancelDto cancelDto) {
        return false;
    }
}
