package com.atguigu.boot.config;

import ch.qos.logback.core.db.DBHelper;
import com.atguigu.boot.bean.Pet;
import com.atguigu.boot.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

// 告诉spring boot这是一个配置类

/**
 * 配置类使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 配置类本身也是组件
 * proxyBeanMethods: 代理bean的方法
 */
@Import({User.class, DBHelper.class})
@Configuration(proxyBeanMethods = true)
public class MyConfig {

    /**
     * 外部无论对配置类中的这个组件注册方法调用多少次获取的都是之前注册容器中的单实例对象
     * @return
     */
    // 给容器中添加组件，以方法名作为组件的id。返回类型就是组件的类型。返回的值就是组件在容器中的实例
    @Bean
    public User user01() {
        User user1 = new User("zhangsan", 18);
        // 当@Configuration(proxyBeanMethods = true)时，user组件需要依赖pet组件
        user1.setPet(pet01());
        return user1;
    }

    @Bean("tom")
    public Pet pet01() {
        return new Pet("tomcat");
    }
}
