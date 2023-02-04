package br.com.joaogosmani.javajobs.mappers;

import org.springframework.stereotype.Component;

import br.com.joaogosmani.javajobs.dtos.JobDTO;
import br.com.joaogosmani.javajobs.models.Job;

@Component
public class JobMapper {
    
    public Job toModel(JobDTO jobDTO) {
        var job = new Job();

        job.setTitle(jobDTO.getTitle());
        job.setDescription(jobDTO.getDescription());
        job.setCompany(jobDTO.getCompany());
        job.setEmail(jobDTO.getEmail());
        job.setStatus(jobDTO.getStatus());

        var techs = String.join(", ", jobDTO.getTechs());
        job.setTechs(techs);

        return job;
    }

}
