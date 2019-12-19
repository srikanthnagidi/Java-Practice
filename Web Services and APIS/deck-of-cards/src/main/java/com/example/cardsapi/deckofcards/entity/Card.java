package com.example.cardsapi.deckofcards.entity;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    private String image;
    private String value;
    private String suit;
    private String code;
}
