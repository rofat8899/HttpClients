package com.rofat.HttpClients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class AmountToTextController {
    @Autowired
    private ATTService attService;

    @PostMapping("{amount}")
    public String amountToText(@PathVariable("amount") int amount){
        return attService.amountToText(amount);
    }

}
