package com.fyzheng.chapter3.demo;

/**
 * @author fyzheng
 * @create 2021-08-21 22:26
 * @Description:
 *  彩信中心信息
 *  模式角色：ImmutableObject.ImmutableObject
 */
public final class MMSCInfo {
    /**
     * 设备编号
     */
    private final String deviceID;
    /**
     * 彩信中心URL
     */
    private final String url;
    /**
     * 彩信中心允许的最大附件大小
     */
    private final int maxAttrachmentSizeInBytes;

    public MMSCInfo(String deviceID, String url, int maxAttrachmentSizeInBytes) {
        this.deviceID = deviceID;
        this.url = url;
        this.maxAttrachmentSizeInBytes = maxAttrachmentSizeInBytes;
    }

    public MMSCInfo(MMSCInfo prototype) {
        this.deviceID = prototype.deviceID;
        this.url = prototype.url;
        this.maxAttrachmentSizeInBytes = prototype.maxAttrachmentSizeInBytes;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public String getUrl() {
        return url;
    }

    public int getMaxAttrachmentSizeInBytes() {
        return maxAttrachmentSizeInBytes;
    }
}
