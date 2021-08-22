package com.fyzheng.chapter3.demo1;

/**
 * @author fyzheng
 * @create 2021-08-21 22:26
 * @Description:
 *  与运维中心对接的类
 *  模式角色：ImmutableObject.Manipulator
 */
public class OMCAgent extends Thread{
    @Override
    public void run() {
        boolean isTableModificationMsg = false;
        String updateTableName = null;
        while (true) {
            //省略其他代码
            /**
             * 从与OMC链接的Socket中读取消息并进行解析
             * 解析到数据表更新消息后，重置MMSCRouter实例
             */
            if (isTableModificationMsg) {
                if ("MMSCInfo".equals(updateTableName)) {
                    MMSCRouter.setInstance(new MMSCRouter());
                }
            }
            //省略其他代码
        }
    }
}
