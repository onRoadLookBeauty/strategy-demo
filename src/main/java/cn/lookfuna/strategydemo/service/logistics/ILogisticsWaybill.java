package cn.lookfuna.strategydemo.service.logistics;

import cn.lookfuna.strategydemo.domain.dto.LogisticsCreateOrderDto;
import cn.lookfuna.strategydemo.domain.dto.LogisticsCreateOrderResDto;
import cn.lookfuna.strategydemo.domain.dto.WaybillCancelDto;


/**
 * @Title ILogisticsWaybill
 * @Description 电子面单相关对接的策略接口
 * @Version 1.0
 */
public interface ILogisticsWaybill {
    /**
     * 获取对应电子面单平台的名字
     * @return  例如: 抖音 快手
     */
    String getWaybillName();

    /**
     * 是否使用这个实现
     * @param customerOrderSource   客户订单来源
     * @return  是否
     */
    boolean useFlag(String customerOrderSource);

    /**
     * 一些公用的方法
     */
    void common();

    /**
     * 订单受理时根据订单信息 向平台下单创建电子面单
     * @param o 订单信息
     * @return  快递单信息
     */
    LogisticsCreateOrderResDto createOrder(LogisticsCreateOrderDto o);

    /**
     * 取消 快递单号
     * @param cancelDto 取消单号等信息
     * @return 成功与否
     */
    boolean cancelOrder(WaybillCancelDto cancelDto);

}
