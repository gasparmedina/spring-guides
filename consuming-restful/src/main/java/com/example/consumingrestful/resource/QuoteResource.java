package com.example.consumingrestful.resource;

import com.example.consumingrestful.model.Quote;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuoteResource {

    private Quote value;
    private String type;


}
