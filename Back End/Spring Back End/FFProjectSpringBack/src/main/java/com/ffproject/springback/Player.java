package com.ffproject.springback;

import java.util.HashMap;
import java.util.Map;

public class Player {
    String name = "";
    String position = "";
    Map<Integer, Map<String, Object>> passingStats = new HashMap<>(); // first key is the year, which gets you a map of stat name -> amount
    Map<Integer, Map<String, Object>> rushingStats = new HashMap<>();
    Map<Integer, Map<String, Object>> receivingStats = new HashMap<>();

    public Map<Integer, Map<String, Object>> getPassingStats() {
        return passingStats;
    }

    public void setPassingStats(Map<Integer, Map<String, Object>> passingStats) {
        this.passingStats = passingStats;
    }
    public void setPassingStat(Map<String, Object> stats, Integer year) {
        this.passingStats.put(year, stats);
    }

    public Map<Integer, Map<String, Object>> getRushingStats() {
        return rushingStats;
    }

    public void setRushingStats(Map<Integer, Map<String, Object>> rushingStats) {
        this.rushingStats = rushingStats;
    }
    public void setRushingStat(Map<String, Object> stats, Integer year) {
        this.rushingStats.put(year, stats);
    }

    public Map<Integer, Map<String, Object>> getReceivingStats() {
        return receivingStats;
    }

    public void setReceivingStats(Map<Integer, Map<String, Object>> rushingStats) {
        this.receivingStats = rushingStats;
    }
    public void setReceivingStat(Map<String, Object> stats, Integer year) {
        this.receivingStats.put(year, stats);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
