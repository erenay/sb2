package com.sb;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/transactions")
//@Import(TestApiService.class)
public class TestApiController {

    private final static Logger LOGGER = LoggerFactory.getLogger(TestApiController.class.getName());

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    QuoteService quoteService;

    /**
     * Get all transactions from the DB
     * @return list of transactions
     * @throws JsonProcessingException
     */
    @GetMapping(path = "/quote", produces = "application/json")
    public ResponseEntity<List<Quote>> getQuotesForCustomer(CustomerRequest customerRequest) throws JsonProcessingException {
        LOGGER.info("received request to calculate the quote");

        try {
            return new ResponseEntity<List<Quote>>(quoteService.calculateQuote(customerRequest), HttpStatus.OK);
        }
        catch (Exception e){
            System.out.println("Error");
            return null;
        }

    }

}
