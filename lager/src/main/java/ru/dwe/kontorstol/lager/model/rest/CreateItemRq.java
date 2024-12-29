package ru.dwe.kontorstol.lager.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateItemRq {

    @JsonProperty("type")
    private String type;

    @JsonProperty("amount")
    private int amount;
}