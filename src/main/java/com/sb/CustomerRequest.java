package com.sb;


import java.util.Map;

public class CustomerRequest {

    Map<String, Map<String, Double>> cover;

    public Map<String, Map<String, Double>> getCover() {
        return cover;
    }

    public void setCover(Map<String, Map<String, Double>> cover) {
        this.cover = cover;
    }
}