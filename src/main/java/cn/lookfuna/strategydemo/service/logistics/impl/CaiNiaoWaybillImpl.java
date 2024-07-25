package cn.lookfuna.strategydemo.service.logistics.impl;

import cn.lookfuna.strategydemo.domain.dto.LogisticsCreateOrderDto;
import cn.lookfuna.strategydemo.domain.dto.LogisticsCreateOrderResDto;
import cn.lookfuna.strategydemo.domain.dto.WaybillCancelDto;
import cn.lookfuna.strategydemo.service.logistics.BaseLogisticsWaybill;
import cn.lookfuna.strategydemo.service.logistics.WaybillNameEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * @Title CaiNiaoWaybillImpl
 * @Description 菜鸟电子面单相关接口实现类
 * @Version 1.0
 */
@Slf4j
@Component
public class CaiNiaoWaybillImpl extends BaseLogisticsWaybill {


    @Override
    public String getWaybillName() {
        return WaybillNameEnum.CAI_NIAO.getCode();
    }

    /**
     * 直接返回false  不参与循环判断
     * @param customerOrderSource 客户订单来源
     * @return false
     */
    @Override
    public boolean useFlag(String customerOrderSource) {
        return false;
    }


    @Override
    public LogisticsCreateOrderResDto createOrder(LogisticsCreateOrderDto o) {
        log.info("通过 菜鸟 下单");
        return new LogisticsCreateOrderResDto("菜鸟");
    }

    /**
     * 菜鸟取消快递单号
     */
    @Override
    public boolean cancelOrder(WaybillCancelDto cancelDto) {
        return true;
    }


}
