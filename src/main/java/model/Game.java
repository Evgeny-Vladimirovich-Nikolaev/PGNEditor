package model;

import lombok.Data;

import java.util.Date;

@Data
public class Game {

    String author;
    String task;
    String result;
    byte whiteNumber;
    byte blackNumber;
    byte totalNumber;
    String material;
    byte materialIndex;
    String ideas;
    String fen;
    String body;
    String date;
    String event;
    String annotator;
    String remark;

}
