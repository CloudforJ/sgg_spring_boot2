package com.atguigu.boot;

import ch.qos.logback.core.db.DBHelper;
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
//        Pet tom01 = run.getBean("pet01", Pet.class);
//        Pet tom02 = run.getBean("pet01", Pet.class);
//        System.out.println("组件： " + (tom01 == tom02));

        MyConfig bean = run.getBean(MyConfig.class);
        System.out.println(bean);

        /**
         * 如果@Configuration(proxyBeanMethods = true)代理对象调用方法
         * Spring Boot总会检查这个组件是否在容器中有，如果有，就不会新创
         * 保持组件单实例
         */
//        User user = bean.user01();
//        User user1 = bean.user01();
//        System.out.println(user == user1);
//
//
//
//        User user01 = run.getBean("user01", User.class);
//        Pet tom = run.getBean("tom", Pet.class);
//        System.out.println("用户的宠物：" + (user01.getPet() == tom));
//
//        String[] beanNamesForType = run.getBeanNamesForType(User.class);
//        for (String s : beanNamesForType) {
//            System.out.println(s);
//        }
//
//        DBHelper bean1 = run.getBean(DBHelper.class);
//        System.out.println(bean1);

        boolean hasTom = run.containsBean("tom");
        System.out.println("容器中包含tom组件：" + hasTom);

        boolean hasUser01 = run.containsBean("user01");
        System.out.println("容器中包含user01组件：" + hasUser01);

        boolean hasHaha = run.containsBean("haha");
        System.out.println("容器中包含haha组件：" + hasHaha);

        boolean hasHehe = run.containsBean("hehe");
        System.out.println("容器中包含hehe组件：" + hasHehe);
    }
}
