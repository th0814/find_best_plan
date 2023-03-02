package com.plan.web;

import com.plan.core.dto.Result;
import com.plan.core.service.FindBestPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@RestController
public class FindBestPlanController {

    @Autowired
    private FindBestPlanService service;

    @PostMapping("/find-best-plan")
    public ResponseEntity<Result> findBestPlan(@RequestParam("plans") MultipartFile plans, @RequestParam("requiredFeatures") String requiredFeatures) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(plans.getInputStream()));
            List<String> required = service.parseRequiredFeatures(requiredFeatures, ",");
            Result res = service.findBestPlan(service.readFile(reader), required);
            return ResponseEntity.ok(res);
        } catch (IOException exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
