package br.com.joaogosmani.javajobs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.joaogosmani.javajobs.models.Job;

public interface JobRepository extends JpaRepository<Job, Long> {
    
}
