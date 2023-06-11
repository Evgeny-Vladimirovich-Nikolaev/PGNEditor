package model;

import lombok.Data;

import java.util.Date;

@Data
public class Game {

    private String author;
    private String task;
    private String result;
    private byte whiteNumber;
    private byte blackNumber;
    private byte totalNumber;
    private String material;
    byte materialIndex;
    private String ideas;
    private String fen;
    private String body;
    private String date;
    private String event;
    private String annotator;
    private String remark;
    private String source;

}
