package br.com.joaogosmani.javajobs.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joaogosmani.javajobs.dtos.JobDTO;
import br.com.joaogosmani.javajobs.exceptions.JobAlreadyExistsException;
import br.com.joaogosmani.javajobs.exceptions.JobNotFoundException;
import br.com.joaogosmani.javajobs.mappers.JobMapper;
import br.com.joaogosmani.javajobs.models.Job;
import br.com.joaogosmani.javajobs.repositories.JobRepository;

@Service
public class JobService {
    
    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private JobMapper jobMapper;

    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    public Job findById(Long id) {
        return jobRepository.findById(id)
            .orElseThrow(() -> new JobNotFoundException(id));
    }

    public Job create(JobDTO jobDTO) {
        var jobToCreate = jobMapper.toModel(jobDTO);
        jobToCreate.setCreatedAt(LocalDateTime.now());
        
        verifyIfExists(jobDTO.getTitle());

        return jobRepository.save(jobToCreate);
    }
    
    public Job update(JobDTO jobDTO, Long id) {
        var foundJob = findById(id);
        var jobToUpdate = jobMapper.toModel(jobDTO);

        if (!foundJob.getTitle().equals(jobDTO.getTitle())) {
            verifyIfExists(jobDTO.getTitle());
        }

        jobToUpdate.setId(id);
        jobToUpdate.setCreatedAt(foundJob.getCreatedAt());
        jobToUpdate.setModifiedAt(LocalDateTime.now());

        return jobRepository.save(jobToUpdate);
    }

    public void deleteById(Long id) {
        var jobToDelete = findById(id);

        jobRepository.delete(jobToDelete);
    }

    private void verifyIfExists(String title) {
        jobRepository.findByTitle(title)
            .ifPresent(job -> {throw new JobAlreadyExistsException(title);});
    }
    
}
