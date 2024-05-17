package com.example.producer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    String id;
    String name;
    String model;
    String producer;
    Integer amount;
    Integer price;

    @Override
    public String toString(){
        return "[id = "+
                id+
                ", name=" +
                name +
                ", model=" +
                model +
                ", producer=" +
                producer +
                ", amount=" +
                amount +
                "price=" +
                price +
                "]";
    }

}
