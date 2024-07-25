package cn.lookfuna.strategydemo.service.logistics;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Title LogisticWaybillFactory
 * @Description 电子面单接口实现类工厂
 * @Version 1.0
 */
@Slf4j
@Component
public class LogisticWaybillFactory {

    /**
     * 保存 策略实现类 <接口名,具体策略实现类>
     */
    private final static Map<String, BaseLogisticsWaybill> STRATEGY_MAP = new ConcurrentHashMap<>(16);

    /**
     * 添加策略实例
     */
    public static void registerStrategy(String type, BaseLogisticsWaybill strategy) {
        STRATEGY_MAP.put(type, strategy);
    }

    /**
     * 获取策略实例
     * 根据实现类里的 useFlag 判断当前实现类是否使用  如果都不用 就用菜鸟的
     * @param customerOrderSource 客户订单来源   有时候即使是同一个平台 也会有多个不同的字符串
     * @return  实现类实例
     */
    public static BaseLogisticsWaybill getImpl(String customerOrderSource) {
        for (BaseLogisticsWaybill value : STRATEGY_MAP.values()) {
            if (value.useFlag(customerOrderSource)){
                return value;
            }
        }
        return STRATEGY_MAP.get(WaybillNameEnum.CAI_NIAO.getCode());
    }

    /**
     * 根据map的key来获取实现类   有的客户固定一个平台 用这个
     * @param mapKey    map的key
     * @return          实现类实例
     */
    public static BaseLogisticsWaybill getImplByKey(WaybillNameEnum mapKey) {
        return STRATEGY_MAP.get(mapKey.getCode());
    }

}
