package org.sjf.spring.ioc.overview.repository;

import org.sjf.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import java.util.Collection;

/**
 * @author shejianfu
 * @date 2020/2/5
 */
public class UserRepository {

    /**
     * 自建Bean对象
     */
    private Collection<User> users;

    /**
     * 内建 非Bean 对象 （依赖）
     */
    private BeanFactory beanFactory;

    private ObjectFactory<ApplicationContext> userObjectFactory;

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public ObjectFactory<ApplicationContext> getUserObjectFactory() {
        return userObjectFactory;
    }

    public void setUserObjectFactory(ObjectFactory<ApplicationContext> userObjectFactory) {
        this.userObjectFactory = userObjectFactory;
    }
}
