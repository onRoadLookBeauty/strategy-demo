package cn.lookfuna.strategydemo.service.logistics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

/**
 * @Title BaseLogisticsWaybill
 * @Description 共用的算法逻辑抽象类
 * @Version 1.0
 */
public abstract class BaseLogisticsWaybill implements InitializingBean,ILogisticsWaybill{

    private Logger logger = LoggerFactory.getLogger(BaseLogisticsWaybill.class);

    @Override
    public void afterPropertiesSet() {
        logger.info("初始化" + this.getWaybillName() + "策略的实现类");
        LogisticWaybillFactory.registerStrategy(this.getWaybillName(),this);
    }

    @Override
    public void common() {
        // 公用方法 在不同策略执行完后 共同的操作  比如
        logger.info("记录日志");
        logger.info("推送通知");
    }
}
