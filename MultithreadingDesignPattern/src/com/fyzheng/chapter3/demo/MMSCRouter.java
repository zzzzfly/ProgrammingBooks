package com.fyzheng.chapter3.demo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fyzheng
 * @create 2021-08-21 22:26
 * @Description:
 * 彩信中心路由规则管理器
 * 模式角色：ImmutableObject.ImmutableObject
 */
public final class MMSCRouter {
    //用volatile修饰，保证多线程环境下该变量的可见性
    private static volatile MMSCRouter instance = new MMSCRouter();
    //维护手机号码前缀到彩信中心之间的映射关系
    private final Map<String, MMSCInfo> routeMap;

    public MMSCRouter() {
        //将数据库表中的数据加载到内存中，存为Map
        this.routeMap = MMSCRouter.retrieveRouterMapFromDB();
    }

    private static Map<String, MMSCInfo> retrieveRouterMapFromDB() {
        Map<String, MMSCInfo> map = new HashMap<String, MMSCInfo>();
        //省略代码
        return map;
    }

    public static MMSCRouter getInstance() {
        return instance;
    }

    /**
     * 根据手机号码前缀获取对应的彩信中心信息
     *
     * @param msisdnPrefix 手机号码前缀
     * @return 彩信中心信息
     */
    public MMSCInfo getMMSC(String msisdnPrefix) {
        return routeMap.get(msisdnPrefix);
    }

    /**
     * 将当前MMSCRouter 的实例信息更新为制定的新实例
     *
     * @param newInstance 新的MMSCRouter实例
     */
    public static void setInstance(MMSCRouter newInstance) {
        instance = newInstance;
    }

    private static Map<String, MMSCInfo> deepCopy(Map<String, MMSCInfo> m) {
        Map<String, MMSCInfo> result = new HashMap<String, MMSCInfo>();
        for (String key: m.keySet()) {
            result.put(key, new MMSCInfo(m.get(key)));
        }
        return result;
    }

    public Map<String, MMSCInfo> getRouteMap() {
        //做防御性复制
        return Collections.unmodifiableMap(deepCopy(routeMap));
    }
}
