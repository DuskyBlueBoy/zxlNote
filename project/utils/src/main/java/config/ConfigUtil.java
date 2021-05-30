package config;

import java.io.IOException;
import java.io.InputStream;
import java.text.Annotation;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 描述：获取配置文件的config
 * 时间：2021年5月30日19:17:28
 * 作者：zxl
 */

public class ConfigUtil {

    // 初始化
    private static ConfigUtil configUtil = new ConfigUtil();

    private Map<Object, Object> propertiesMap = new HashMap<>();

    private String[] defaultFileNames = {
            "application.properties",
            "application.yml"
    };

    // 私有
    private ConfigUtil(){}

    // 获取工具类对象
    public static ConfigUtil getUtil(){
        return configUtil;
    }

    /**
     * 获取配置
     */
    public Properties initConfigUtil() throws Exception{
        return this.initConfigUtil("");
    }

    /**
     * 获取配置
     *
     * @param fileName 配置文件名称
     */
    public Properties initConfigUtil(String fileName) throws Exception{
        // 检测是否有默认的application.
        InputStream inputStream = null;
        String mapKey = null;
        if (fileName == null || "".equals(fileName)){
            // 读取默认配置信息
            for (String defaultFileName : defaultFileNames) {
                inputStream = this.getClass().getClassLoader().getResourceAsStream(defaultFileName);
                if (inputStream != null){
                    // 如果找到了流数据，就在这里获取对应流
                    mapKey = defaultFileName;
                    break;
                }
            }
        }
        else {
            // 读取传参所在配置信息
            inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
            mapKey = fileName;
        }

        // 拿到数据，组成键值对
        Properties p = new Properties();
        try {
            p.load(inputStream);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        // 存储对应的配置
        propertiesMap.put(mapKey, p);
//        System.out.println("ip:"+p.getProperty("ip")+",port:"+p.getProperty("port"));
        return p;
    }

    /**
     * 获取配置
     *
     * @param fileName 配置文件名称
     */
    public Properties getProperties(String fileName) throws Exception{
        // 检查是否存在给配置，存在就获取
        if (propertiesMap.keySet().contains(fileName)){
            return (Properties)propertiesMap.get(fileName);
        }
        else {
            throw new Exception("未找到该路径下的配置信息！");
        }
    }

    /**
     * 解析注解信息获取数据
     */
    public Properties initInterface() throws Exception{
        Class clazz = ConfigValue.class;
        Annotation a = new Annotation(new Object());
    }
}
