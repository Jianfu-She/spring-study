package org.sjf.ioc.java.beans;

/**
 * POJO
 * <p>
 * getter / setter
 * readable / writable
 *
 * @author shejianfu
 * @date 2020/2/2
 */
public class Person {

    private String name; // Property

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
