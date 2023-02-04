package br.com.joaogosmani.javajobs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.joaogosmani.javajobs.models.Job;
import br.com.joaogosmani.javajobs.services.JobService;

@RestController
@RequestMapping("/api/v1/jobs")
public class JobController {
    
    @Autowired
    private JobService jobService;

    @GetMapping
    public List<Job> findAll() {
        return jobService.findAll();
    }

    @GetMapping("/{id}")
    public Job findById(@PathVariable Long id) {
        return jobService.findById(id);
    }

}
