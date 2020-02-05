package org.sjf.spring.ioc.overview.domain;

import org.sjf.spring.ioc.overview.annotation.Super;

/**
 * @author shejianfu
 * @date 2020/2/5
 */
@Super
public class SuperUser extends User {

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
