package cn.lookfuna.strategydemo.service.logistics;

import cn.lookfuna.strategydemo.domain.dto.LogisticsCreateOrderDto;
import cn.lookfuna.strategydemo.domain.dto.LogisticsCreateOrderResDto;
import cn.lookfuna.strategydemo.domain.dto.WaybillCancelDto;
import org.springframework.stereotype.Service;

/**
 * @Title LogisticWaybillExec
 * @Description 电子面单接口执行类
 * @Version 1.0
 */
@Service
public class LogisticWaybillExec {
    /**
     * 创建电子面单
     * @param customerOrderSource   客户订单来源
     * @param dto                   订单信息
     * @return                      电子面单信息
     */
    public LogisticsCreateOrderResDto createOrder(String customerOrderSource, LogisticsCreateOrderDto dto){
        BaseLogisticsWaybill impl = LogisticWaybillFactory.getImpl(customerOrderSource);
        LogisticsCreateOrderResDto order = impl.createOrder(dto);
        // 通用方法
        impl.common();
        return order;
    }



    /**
     * 取消电子面单
     * @param customerOrderSource   客户订单来源
     * @param cancelDto             取消的对象
     * @return                      取消成功与否
     */
    public boolean cancelOrder(String customerOrderSource,WaybillCancelDto cancelDto) {
        BaseLogisticsWaybill impl = LogisticWaybillFactory.getImpl(customerOrderSource);
        return impl.cancelOrder(cancelDto);
    }

}
