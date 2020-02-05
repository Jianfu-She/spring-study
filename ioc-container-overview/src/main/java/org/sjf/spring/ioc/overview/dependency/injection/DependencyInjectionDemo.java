package org.sjf.spring.ioc.overview.dependency.injection;

import org.sjf.spring.ioc.overview.annotation.Super;
import org.sjf.spring.ioc.overview.domain.User;
import org.sjf.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 依赖注入示例
 * 1. 根据名称来查找Bean （实时查找、间接查找）
 * 2. 根据类型来查找Bean （单个Bean对象、集合Bean对象）
 * 3. 根据名称+类型来查找Bean
 * 4. 根据注解查找Bean
 *
 * @author shejianfu
 * @date 2020/2/4
 */
@SuppressWarnings("all")
public class DependencyInjectionDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");
        UserRepository userRepository = beanFactory.getBean("userRepository", UserRepository.class);
        System.out.println(userRepository.getUsers());

        // 依赖注入，依赖注入与依赖查找不同源
        System.out.println(userRepository.getBeanFactory());
        System.out.println(userRepository.getBeanFactory() == beanFactory);

        // 依赖查找，（错误，找不到该bean）
        System.out.println(beanFactory.getBean(BeanFactory.class));

        System.out.println(userRepository.getUserObjectFactory().getObject());
        System.out.println(userRepository.getUserObjectFactory().getObject() == beanFactory);
    }


}
