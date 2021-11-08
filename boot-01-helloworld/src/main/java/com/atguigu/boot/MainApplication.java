package com.atguigu.boot;

import com.atguigu.boot.bean.Pet;
import com.atguigu.boot.bean.User;
import com.atguigu.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        //  返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        // 查看容器中的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        // 从容器中获取组件
        Pet tom01 = run.getBean("pet01", Pet.class);
        Pet tom02 = run.getBean("pet01", Pet.class);
        System.out.println("组件： " + (tom01 == tom02));

        MyConfig bean = run.getBean(MyConfig.class);
        System.out.println(bean);

        User user = bean.user01();
        User user1 = bean.user01();
        System.out.println(user == user1);
    }
}
