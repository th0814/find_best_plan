package com.plan.core.dto;

import java.util.Arrays;
import java.util.List;

public class Plan {
    private String name;
    private int price;
    private List<String> features;

    public Plan(String name, int price, String servicesStr, String serviceSeparator) {
        this.name = name;
        this.price = price;
        this.features = Arrays.asList(servicesStr.split(serviceSeparator));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<String> getFeatures() {return features;}

    public void setFeatures(List<String> features) {this.features = features;}
}
