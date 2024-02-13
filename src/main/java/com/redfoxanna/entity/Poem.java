package com.redfoxanna.entity;

import java.sql.Timestamp;

public class Poem {
    private int poemId;
    private String title;
    private String author;
    private String content;
    private String poemImage; // TODO: How handle images?
    private int userId;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
