package com.papirnyk.java.labs.stream.api;

public class City {

    private String name;
    private String state;
    private long population;

    public City(String name, String state, long population) {
        this.name = name;
        this.state = state;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return String.format( "City: %s, population %d", name, population );
    }
}
