package com.plan.core.dto;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private int totalCost;
    private List<String> plans;

    public Result(int totalCost) {
        this.plans = new ArrayList<>();
    }

    public Result(int totalCost, List<String> plans) {
        this.totalCost = totalCost;
        this.plans = plans;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public List<String> getPlans() {
        return plans;
    }

    public void setPlans(List<String> plans) {
        this.plans = plans;
    }

    @Override
    public String toString() {
        return String.join(",", String.valueOf(this.totalCost), String.join(",", this.plans));
    }
}