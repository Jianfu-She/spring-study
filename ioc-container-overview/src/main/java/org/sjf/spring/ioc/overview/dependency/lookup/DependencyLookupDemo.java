package org.sjf.spring.ioc.overview.dependency.lookup;

import org.sjf.spring.ioc.overview.annotation.Super;
import org.sjf.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 依赖查找示例
 * 1. 根据名称来查找Bean （实时查找、间接查找）
 * 2. 根据类型来查找Bean （单个Bean对象、集合Bean对象）
 * 3. 根据名称+类型来查找Bean
 * 4. 根据注解查找Bean
 *
 * @author shejianfu
 * @date 2020/2/4
 */
@SuppressWarnings("all")
public class DependencyLookupDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context.xml");

        dependencyLookupInRealTime(beanFactory);
        dependencyLookupInLay(beanFactory);

        dependencyLookupByType(beanFactory);
        dependencyLookupCollectionByType(beanFactory);

        dependencyLookupByAnnotation(beanFactory);
    }

    private static void dependencyLookupInRealTime(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println("实时查找：" + user);
    }

    private static void dependencyLookupInLay(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("延迟查找：" + user);
    }

    private static void dependencyLookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("根据类型来查找单个Bean: " + user);
    }

    private static void dependencyLookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("根据类型来查找集合Bean: " + users);
        }
    }

    private static void dependencyLookupByAnnotation(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("根据注解来查找Bean: " + users);
        }
    }
}
