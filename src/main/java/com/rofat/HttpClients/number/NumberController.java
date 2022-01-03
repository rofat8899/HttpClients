package com.rofat.HttpClients.number;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/number")
public class NumberController {
    @Autowired
    private numberService numberService;

    @PostMapping("/to-words/{num}")
    public String numberToWords(@PathVariable("num") int num)
    {
        return numberService.Operation("NumberToWords",num);
    }
    @PostMapping("/to-dollars/{num}")
    public String numberToDollars(@PathVariable("num") int num)
    {
        return numberService.Operation("NumberToDollars",num);
    }
}
