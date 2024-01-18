package com.example.producer.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    String name;
    String model;
    String producer;
    Integer amount;
    Integer price;

    @Override
    public String toString(){
        return new StringBuilder()
                .append("[ name=")
                .append(name)
                .append(", model=")
                .append(model)
                .append(", producer=")
                .append(producer)
                .append(", amount=")
                .append(amount)
                .append("price=")
                .append(price)
                .append("]")
                .toString();
    }

}
