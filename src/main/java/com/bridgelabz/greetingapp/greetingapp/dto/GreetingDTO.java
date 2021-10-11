package com.bridgelabz.greetingapp.greetingapp.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data

/**
 * Layer that contains data from client
 * @author - Sakshi Shetty
 * @version - 0.0.1
 * @since - 10/10/2021
 */
public class GreetingDTO {
    private String message;
}
