package com.in28minutes.learn_spring_framework.simpleExamples.helloWorld;

public class Address {
    private String city;
    private String province;

    public Address(String city, String province) {
        this.city = city;
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", province='" + province + '\'' +
                '}';
    }
}
