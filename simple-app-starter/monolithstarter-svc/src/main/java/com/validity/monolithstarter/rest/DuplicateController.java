package com.validity.monolithstarter.rest;

import com.validity.monolithstarter.service.DuplicateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping("/api")
public class DuplicateController {

    @Inject
    private DuplicateService duplicateService;

    @GetMapping("/duplicates")
    public String getDuplicates() {
        return duplicateService.getDuplicates();
    }
}
