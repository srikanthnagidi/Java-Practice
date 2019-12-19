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
public class Response {
    private boolean success;
    private String deck_id;
    private boolean shuffled;
    private Integer remaining;
    private Card[] cards;

    @Override
    public String toString(){
        return (new Gson().toJson(this));
    }
}
