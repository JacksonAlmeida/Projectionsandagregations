package com.sunflower.projectionsandagregations.entities;

import java.util.List;
import java.util.Objects;

public class StatePopulation {

    private String state;
    private List<StateGroup> stateGroup;

    public StatePopulation() {

    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<StateGroup> getStateGroup() {
        return stateGroup;
    }

    public void setStateGroup(List<StateGroup> stateGroup) {
        this.stateGroup = stateGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatePopulation that = (StatePopulation) o;
        return Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(state);
    }
}
