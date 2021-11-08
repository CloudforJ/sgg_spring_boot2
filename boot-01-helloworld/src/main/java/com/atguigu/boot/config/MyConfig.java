package com.atguigu.boot.config;

import com.atguigu.boot.bean.Pet;
import com.atguigu.boot.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 告诉spring boot这是一个配置类

/**
 * 配置类使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 配置类本身也是组件
 * proxyBeanMethods: 代理bean的方法
 */
@Configuration(proxyBeanMethods = true)
public class MyConfig {

    // 给容器中添加组件，以方法名作为组件的id。返回类型就是组件的类型。返回的值就是组件在容器中的实例
    @Bean
    public User user01() {
        return new User("zhangsan", 18);
    }

    @Bean
    public Pet pet01() {
        return new Pet("tomcat");
    }
}
