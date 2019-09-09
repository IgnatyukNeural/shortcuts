package com.ignatyuk.shortcuts.repositories;

import com.ignatyuk.shortcuts.models.Environment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnvironmentRepository extends CrudRepository<Environment, Integer> {

    @Override
    List<Environment> findAll();

}
