package com.sunflower.projectionsandagregations.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class StatePopulationGroup {

    @Id
    private String id;
    private int statePop;

    public StatePopulationGroup() {

    }

    public StatePopulationGroup(String id, int statePop) {
        this.id = id;
        this.statePop = statePop;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getStatePop() {
        return statePop;
    }

    public void setStatePop(int statePop) {
        this.statePop = statePop;
    }
}
