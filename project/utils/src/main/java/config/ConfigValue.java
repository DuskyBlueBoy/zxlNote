package config;

import java.lang.annotation.*;

/**
 * 描述：获取配置文件的注解
 * 时间：2021年5月30日20:26:08
 * 作者：zxl
 */

// 标注作用类型
@Target({ElementType.FIELD})
// 标注生命周期为运行时
@Retention(RetentionPolicy.RUNTIME)
// 标注可以文档化
@Documented
// 标注可以继承
@Inherited
public @interface ConfigValue {

    String value() default "";

}
