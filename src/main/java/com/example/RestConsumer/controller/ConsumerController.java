package com.example.RestConsumer.controller;

import com.example.RestConsumer.model.BillInformation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@Controller
public class ConsumerController {

    @GetMapping("/")
    public String index() {

        return "index";
    }

    @GetMapping("/home")
    public String home() {

        return "home";
    }

    @PostMapping("readOne")
    private String readOne(Model model, @RequestParam String billNumber) {
        BillInformation billInformation = null;
        try {
            URL url = new URL("http://localhost:8081/api/bill_Information/"+ billNumber);

            ObjectMapper objectMapper = new ObjectMapper();

            billInformation = objectMapper.readValue(url, BillInformation.class);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (billInformation == null){
            return "Not found any information please check your Bill number";
        }else {
            model.addAttribute("billInfo",billInformation);

            return "single_bill_info";
        }


    }


}
