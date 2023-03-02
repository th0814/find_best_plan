package com.plan;

import com.plan.core.dto.Result;
import com.plan.core.service.FindBestPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

@SpringBootApplication
public class FindBestPlanApplication implements CommandLineRunner {

	@Autowired
	private FindBestPlanService service;

	public static void main(String[] args) {
		System.out.println("------------Start find best plan application------------");
		if (args.length > 0) {
			int exitCode = SpringApplication.exit(SpringApplication.run(FindBestPlanApplication.class, args));
			System.out.println("Find best plan application has exited with exit code: " + exitCode);
		} else {
			SpringApplication.run(FindBestPlanApplication.class, args);
		}
	}

	@Override
	public void run(String... args) throws Exception {
		if (args.length > 0) {
			List<String> requiredFeatures = service.parseRequiredFeatures(args[1], ",");
			Result res = service.findBestPlan(service.readFile(new BufferedReader(new FileReader(args[0]))), requiredFeatures);
			System.out.println("Minimum price found");
			System.out.println(res.toString());
		}
	}
}
