package com.example.demo.services;

import com.example.demo.model.Numbers;
import com.example.demo.repository.NumbersInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class NumberService {
    private   NumbersInterface numbersInterface;
    @Autowired
    public NumberService(NumbersInterface numbersInterface) {
        this.numbersInterface = numbersInterface;
    }
    public void addNumber(Numbers number)
    {
        numbersInterface.insert(number);
    }
    public List<Numbers> getAllNumbers()
    {
return numbersInterface.findAll();
    }
    public Numbers getFizzBuzz(int value)
    {
        String result="";
        for(int i=1;i<=value;i++)
        {
            if(i%3==0){
                if(i%5==0)
                {
                    result+="FizzBuzz";
                }
                else {
                    result+="Fizz";
                }
            }
            else if(i%5==0){
                result+="Buzz";
            }
            else{
                result=result + i ;
            }
        }
        Numbers N= new Numbers(value,result);
        numbersInterface.save(N);
        return N;
    }
    public Numbers getNumberByValue(int value)
    {
      Numbers n = numbersInterface.findByValue(value);
      if(n==null)
      {
          return null;
      }
      else
      {
          return n;
      }

    }
}
