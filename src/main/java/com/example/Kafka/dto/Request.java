package com.example.Kafka.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Request implements Serializable {
    @NotNull(message = "Message cant be null")
    @Size(min = 1,message = "Message cant be empty ")
    private String message;
}
