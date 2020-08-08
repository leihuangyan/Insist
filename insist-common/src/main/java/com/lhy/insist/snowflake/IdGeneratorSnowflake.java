package com.lhy.insist.snowflake;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

/**
 * @Author EiletXie
 * @Since 2020/3/18 21:18
 */
public class IdGeneratorSnowflake {
    private static  long workerId = 0;

    private static long datacenterId = 1;

    private static Snowflake snowflake = IdUtil.getSnowflake(workerId, datacenterId);


    public  static  synchronized long snowflakeId() {
        return snowflake.nextId();
    }

    public static synchronized long snowflakeId(long workerId, long datacenterId) {
        snowflake = IdUtil.getSnowflake(workerId, datacenterId);
        return snowflake.nextId();
    }
}
