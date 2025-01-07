package com.jiuzhou.desgin.Enum;

/**
 * 大华接口链接枚举类
 * @author yushu
 * @email 921784721@qq.com
 * @date 2024/2/22 9:06
 */
public enum DhApiEnum {


    GET_SERIAL_NO("get_serial_no","/cgi-bin/magicBox.cgi?action=getSerialNo","GET","4.6.10 获取设备序列号");

    /**
     * 动作
     */
    private String action;

    /**
     * 方法路径
     */
    private String uri;

    /**
     * 请求方法
     */
    private String method;

    /**
     * 描述
     */
    private String desc;

    DhApiEnum(String action, String uri, String method, String desc) {
        this.action = action;
        this.uri = uri;
        this.method = method;
        this.desc = desc;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    public static DhApiEnum getEnumByAction(String action){
        for (DhApiEnum value : DhApiEnum.values()) {
            if(value.getAction().equalsIgnoreCase(action)){
                return value;
            }
        }
        return null;
    }
}
