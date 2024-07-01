package com.facimath.facimath.dto;

public class TestDto {
    private long id;
    private String text;

    public TestDto() {

    }

    public TestDto(long id, String text) {
        this.id = id;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
