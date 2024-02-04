package com.sunflower.projectionsandagregations.repositoy;

import com.sunflower.projectionsandagregations.entities.StatePopulation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StatePoulationRepository extends MongoRepository<StatePopulation, String> {
}
