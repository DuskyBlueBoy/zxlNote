package config;

import org.junit.Test;
import redis.RedisUtils;

import java.util.Enumeration;
import java.util.Properties;

import static org.junit.Assert.*;

public class ConfigUtilTest {

    @ConfigValue()
    private String test;

    @Test
    public void getConfigTest() throws Exception {

//        ConfigUtil configUtil = ConfigUtil.getUtil();
//
//        Properties properties = configUtil.initConfigUtil("");
//
//        for (Object key : properties.keySet()) {
//            properties.get(key);
//        }

        System.out.println(test);
    }
}