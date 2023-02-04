package br.com.joaogosmani.javajobs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joaogosmani.javajobs.exceptions.JobNotFoundException;
import br.com.joaogosmani.javajobs.models.Job;
import br.com.joaogosmani.javajobs.repositories.JobRepository;

@Service
public class JobService {
    
    @Autowired
    private JobRepository jobRepository;

    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    public Job findById(Long id) {
        return jobRepository.findById(id)
            .orElseThrow(() -> new JobNotFoundException(id));
    }

}
