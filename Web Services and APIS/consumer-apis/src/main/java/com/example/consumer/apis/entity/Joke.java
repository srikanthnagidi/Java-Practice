package com.example.consumer.apis.entity;

import com.google.gson.Gson;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Data
public class Joke {
    private Long id;
    private String type;
    private String setup;
    private String punchline;

    public Joke(Long id, String type, String setup, String punchline) {
        this.id = id;
        this.type = type;
        this.setup = setup;
        this.punchline = punchline;
    }

    @Override
    public String toString(){
        return "Joke{" +
                "id=" + this +
                ", type='" + type + '\'' +
                ", setup='" + setup + '\'' +
                ", punchline='" + punchline + '\'' +
                '}';
    }

    public String toJson(){
        return (new Gson().toJson(this));
    }
}
