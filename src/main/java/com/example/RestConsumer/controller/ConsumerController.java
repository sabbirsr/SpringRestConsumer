package com.example.RestConsumer.controller;

import com.example.RestConsumer.model.BillInformation;
import com.example.RestConsumer.model.StatusMessage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Controller
public class ConsumerController {

    public BillInformation readSingle(String billNumber) {
        BillInformation billInformation = null;
        try {
            URL url = new URL("http://localhost:8081/api/bill_Information/" + billNumber);

            ObjectMapper objectMapper = new ObjectMapper();

            billInformation = objectMapper.readValue(url, BillInformation.class);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return billInformation;

    }

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


        model.addAttribute("billInfo", readSingle(billNumber));

        return "single_bill_info";

    }

    @PostMapping("pay")
    private String billPay(Model model, @RequestParam String billNumber,
                           @RequestParam float paidAmount) {
        StatusMessage message = null;
        try {
            URL url = new URL("http://localhost:8081/api/bill_Information/" + billNumber + "/" + paidAmount);

            ObjectMapper objectMapper = new ObjectMapper();

            message = objectMapper.readValue(url, StatusMessage.class);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("billInfo", "Success");
        return "payment_status";
    }

    @PostMapping("unpaidList")
    private String unpaidList(Model model,@RequestParam String customerNumber){
        List<BillInformation> billInformationList = null;
        try {
            URL url = new URL("http://localhost:8081/api/bill_Informations/" + customerNumber);

            ObjectMapper objectMapper = new ObjectMapper();

            billInformationList = objectMapper.readValue(url, new TypeReference<List<BillInformation>>() {});
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("billInfo", billInformationList);

        return "unpaid_list";
    }

    @GetMapping("/one")
    @ResponseBody
    public BillInformation one(String id){
        return readSingle(id);
    }
}
