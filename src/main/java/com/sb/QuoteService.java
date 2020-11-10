package com.sb;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class QuoteService {

    @Autowired
    ObjectMapper mapper = new ObjectMapper();


    public List<Quote> calculateQuote(CustomerRequest customerRequest) {

        //TODO read json
        Map<String, Map<String, String>> insurers = null;
        //Map<String, Map<String, String>> insurers = mapper.read()



        Map<String, Double> coverItemMap = customerRequest.getCover().get("covers");  //
        ArrayList<Double> coverItemList = new ArrayList<>(coverItemMap.values());
        Collections.sort(coverItemList);
        Collections.reverse(coverItemList);



        //TODO İmplement rest of logic
        Map<String, String> insurerMapEntry = insurers.get("insurer_rates");
        insurerMapEntry.entrySet().forEach(stringMapEntry -> calculateInsurerQuote(stringMapEntry.getKey(), stringMapEntry.getValue()));

        return null;



    }

    private void calculateInsurerQuote(String insurer, String InsurerValue) {

    }

}
