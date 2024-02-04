package com.sunflower.projectionsandagregations.resources;

import com.sunflower.projectionsandagregations.entities.StatePopulation;
import com.sunflower.projectionsandagregations.services.StatePopulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(value = "/api/states")
public class StatePopulationResource {

    @Autowired
    private StatePopulationService statePopulationService;

    @GetMapping(value = "/group/populations", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<StatePopulation>> findAllStatesPopulationsThanTemMillion() {
        Set<StatePopulation> allStatesPopulationsThanTemMillion = statePopulationService.findAllStatesPopulationsThanTemMillion();
        return ResponseEntity.ok().body(allStatesPopulationsThanTemMillion);
    }

}
