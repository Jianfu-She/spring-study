package org.sjf.ioc.java.beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.util.stream.Stream;

/**
 * {@link java.beans.BeanInfo} 示例
 *
 * @author shejianfu
 * @date 2020/2/2
 */
public class BeanInfoDemo {

    public static void main(String[] args) throws IntrospectionException {

        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);

        Stream.of(beanInfo.getBeanDescriptor()).forEach(System.out::println);
        Stream.of(beanInfo.getPropertyDescriptors()).forEach(System.out::println);
    }
}
