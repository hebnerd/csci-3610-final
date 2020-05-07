package edu.etsu.csci3610.sp2020final.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

public class Greeting {

    @NotNull
    @PositiveOrZero
    private Integer id;

    @NotNull
    @Size (min=2, max=50)
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Greeting(ID: " + this.id + ", Content: " + this.content + ")";
    }
}
