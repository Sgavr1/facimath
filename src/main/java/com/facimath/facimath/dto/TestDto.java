package com.facimath.facimath.dto;

public class TestDto {
    private long id;
    private String text;
    private boolean status;

    public TestDto() {

    }

    public TestDto(long id, String text, boolean status) {
        this.id = id;
        this.text = text;
        this.status = status;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
