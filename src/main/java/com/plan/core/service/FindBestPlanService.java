package com.plan.core.service;

import com.plan.core.dto.Plan;
import com.plan.core.dto.Result;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class FindBestPlanService {

    public List<String> parseRequiredFeatures(String requirement, String separator) {
        return new ArrayList<>(Arrays.asList(requirement.split(separator)));
    }

    public List<Plan> readFile(BufferedReader reader) {
        List<Plan> plans = new ArrayList<>();
        reader.lines().forEach(line -> {
            String[] inputs = line.split(",", 3);
            plans.add(new Plan(inputs[0], Integer.parseInt(inputs[1]), inputs[2], ","));
        });
        plans.sort(Comparator.comparing(Plan::getPrice));
        return plans;
    }

    public Result findBestPlan(List<Plan> plans, List<String> required) {
        int total = 0;
        List<String> planNames = new ArrayList<>();

        for (Plan plan : plans) {
            boolean hasRequired = required.removeAll(plan.getFeatures());
            if (hasRequired) {
                planNames.add(plan.getName());
                total = total + plan.getPrice();
            }

            if (required.isEmpty()) {
                break;
            }
        }

        if (!required.isEmpty()) {
            System.out.println("Plans did not provide required services");
            return new Result(0);
        }

        return new Result(total, planNames);
    }
}