// Gillenwater and Harrison, ZLC: A Zero-Liability Company

package edu.etsu.csci3610.sp2020final.models;

import lombok.Builder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Account {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Date creationDate;
    private String password;
    private String role;

    private static final Logger logger = LoggerFactory.getLogger(Account.class);

    public Account() { }

    public Account(int id,
                   String firstName,
                   String lastName,
                   String email,
                   String creationDate,
                   String password,
                   String role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            this.creationDate = df.parse(creationDate);
        } catch (ParseException pe) {
            logger.debug("Account not parsing the damn date...");
            this.creationDate = new Date();
        }
        this.password = password;
        this.role = role;
    }

    public Account(Account a) {
        this.id = a.id;
        this.firstName = a.firstName;
        this.lastName = a.lastName;
        this.email = a.email;
        this.creationDate = a.creationDate;
        this.password = a.password;
        this.role = a.role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = Date.from(Instant.parse(creationDate));
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", creationDate=" + creationDate +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
