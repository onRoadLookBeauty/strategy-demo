package cn.lookfuna.strategydemo.service.logistics;

import lombok.Getter;

/**
 * @Title WaybillNameEnum
 * @Description 电子面单平台枚举
 * @Version 1.0
 */
@Getter
public enum WaybillNameEnum {
    /**
     * 对接的电子面单平台
     */
    CAI_NIAO("cainiao","菜鸟"),
    DOU_YIN("douyin","抖音"),
    KUAI_SHOU("kuaishou","快手"),
    PDD("pdd","拼多多"),
    JIN_DONG("jingdong","京东"),
    SF("sf","顺丰"),
    ;

    private final String code;
    private final String name;

    WaybillNameEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

}
