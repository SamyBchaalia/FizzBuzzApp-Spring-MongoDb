package com.example.demo.controller;

import com.example.demo.model.Numbers;
import com.example.demo.services.NumberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/number")
@RequiredArgsConstructor
public class NumberController {
   private  NumberService numberService;
    @Autowired
    public NumberController(NumberService numberService) {
        this.numberService = numberService;
    }

    @PostMapping
    public ResponseEntity<Numbers> getThisNumber(@RequestBody Numbers number)
    {
        if (number.getValue() < 1) {
            throw new ArithmeticException("Access denied - value must exists and must be at least 1");
        }
        else {
            Numbers n=numberService.getNumberByValue(number.getValue());
            if(n==null)
            {
                return ResponseEntity.ok(numberService.getFizzBuzz(number.getValue()));

            }
            else
                return ResponseEntity.ok(n);
        }




    }
   @GetMapping
    public ResponseEntity<List<Numbers>> getAllNumbers()
   {
       return ResponseEntity.ok(numberService.getAllNumbers());
   }

}
