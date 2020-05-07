package edu.etsu.csci3610.sp2020final.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class Review {
    private Integer id;
    private Account account;
    private Date creationDate;
    private Integer rating;
    private String content;
    private static final Logger logger = LoggerFactory.getLogger(Review.class);

    public Review(){

    }

    public Review (int id, Account account, String creationDate, int rating, String content) {
        this.id = id;
        this.account = new Account(account);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            this.creationDate = df.parse(creationDate);
        } catch (ParseException pe) {
            logger.debug("Account not parsing the damn date...");
            this.creationDate = new Date();
        }
        this.rating = rating;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
