package com.hivetech.model;

public class Region {
    int regionID;
    String name;
    int continentID;

    public Region() {
    }

    public int getContinentID() {
        return continentID;
    }

    public void setContinentID(int continentID) {
        this.continentID = continentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRegionID() {
        return regionID;
    }

    public void setRegionID(int regionID) {
        this.regionID = regionID;
    }
}
