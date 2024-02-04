package com.sunflower.projectionsandagregations.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunflower.projectionsandagregations.entities.StateGroup;
import com.sunflower.projectionsandagregations.entities.StatePopulation;
import com.sunflower.projectionsandagregations.entities.StatePopulationGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StatePopulationService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Set<StatePopulation> findAllStatesPopulationsThanTemMillion() {

        Set<StatePopulation> statePopulations = new HashSet<>();
        List<StateGroup> stateGroups = new ArrayList<>();

        GroupOperation groupByStateAndSumPop = new GroupOperation(Fields.fields("state", "city"))
                .sum("pop").as("statePop");
        MatchOperation filterStates = new MatchOperation(new Criteria("statePop").gte(0));
        SortOperation sortByPopDesc = new SortOperation(Sort.by(Sort.Direction.ASC, "city"));
        Aggregation aggregation = Aggregation.newAggregation(groupByStateAndSumPop, filterStates, sortByPopDesc);

        List<StatePopulationGroup> statePopulationGroups = mongoTemplate.aggregate(aggregation, "statePopulation",
                        StatePopulationGroup.class).getMappedResults();

        ObjectMapper mapper = new ObjectMapper();

        statePopulationGroups.forEach(statePopulationGroup -> {
            try {
                JsonNode jsonNode = mapper.readTree(statePopulationGroup.getId());
                System.out.println(jsonNode.toString());
                StatePopulation statePopulation = new StatePopulation();
                StateGroup stateGroup = new StateGroup();
                statePopulation.setState(jsonNode.get("state").asText());
                stateGroup.setCity(jsonNode.get("city").asText());
                stateGroup.setStatePop(statePopulationGroup.getStatePop());
                stateGroups.add(stateGroup);
                statePopulation.setStateGroup(stateGroups);
                statePopulations.add(statePopulation);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e.getMessage());
            }
        });

        return statePopulations;

    }

}
