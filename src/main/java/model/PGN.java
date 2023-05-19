package model;

import lombok.Data;

import java.util.Date;

@Data
public class PGN {

    String author;
    String task;
    String result;
    byte whiteNumber;
    byte blackNumber;
    byte totalNumber;
    String material;
    String ideas;
    String body;
    Date date;
    String event;
    String annotator;
    String remark;

}
