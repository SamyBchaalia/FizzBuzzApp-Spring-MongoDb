package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("number")
public class Numbers {
    @Id
    private String id;
    @Field(name ="value")
    @Indexed(unique = true)
    private  int value;
    @Field(name ="result")
    private String result;
    public Numbers(int value, String result) {
        this.value = value;
        this.result = result;
    }


}
