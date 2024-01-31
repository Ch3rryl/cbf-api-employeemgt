package com.cbfacademy.apiassessment.core;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryA<T, ID extends Serializable> {

        // Optional<T> findById(ID id);

        // T save(T entity);  

        // void deleteById(ID id);  

}


    

