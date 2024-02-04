package com.sunflower.projectionsandagregations.entities;

public class StateGroup {

    private String city;
    private Double[] loc;
    private double pop;
    private int statePop;

    public StateGroup() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double[] getLoc() {
        return loc;
    }

    public void setLoc(Double[] loc) {
        this.loc = loc;
    }

    public double getPop() {
        return pop;
    }

    public void setPop(double pop) {
        this.pop = pop;
    }

    public int getStatePop() {
        return statePop;
    }

    public void setStatePop(int statePop) {
        this.statePop = statePop;
    }
}
