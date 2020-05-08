/*
 * ---------------------------------------------------------------------------
 * File name: GreetingController.java
 * Project name: sp2020final
 * ---------------------------------------------------------------------------
 * Creator's name and email: Jake Gillenwater, Gillenwaterj@etsu.edu
 * Course:  CSCI 3610
 * Creation Date: 4/18/2020
 * ---------------------------------------------------------------------------
 */

package edu.etsu.csci3610.sp2020final.configurations;

import edu.etsu.csci3610.sp2020final.models.Account;
import edu.etsu.csci3610.sp2020final.models.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class DatabaseInterchange {
    //Spring Boot will automagically wire this object using application.properties:
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final Logger logger = LoggerFactory.getLogger(DatabaseInterchange.class);

    public void CreateAccount(Account account){
        System.out.println("Account " + account.toString());
        System.out.println("DB connection " + jdbcTemplate.toString());
        jdbcTemplate.execute("INSERT INTO account(firstName, lastName, email, password) VALUES (" +
                                    "'" + account.getFirstName() + "', " +
                                    "'" + account.getLastName() + "', " +
                                    "'" + account.getEmail() + "', " +
                                    "'" + account.getPassword() + "')"
        );
    }

    public Account GetAccountById(int id){
        List<Account> accounts = jdbcTemplate.query("SELECT * FROM account WHERE id="+id,
                (resultSet, rowNum) -> new Account(resultSet.getInt("id"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("email"),
                        resultSet.getString("creationDate"),
                        resultSet.getString("password"),
                        resultSet.getString("role")));
        return accounts.get(0);
    }

    public Account GetAccountByLogin(String email, String password){
        try {
            String sql = "SELECT * FROM account WHERE email=? AND password=?";  // Replaced the parameters with ? for the prepared statement

            Account account = jdbcTemplate.query(sql,
                    preparedStatement -> {
                        preparedStatement.setString(1, email);      // Create prepared statement with email and password
                        preparedStatement.setString(2, password);   // The int indicates which question mark to replace the parameter with
                    },
                    resultSet -> {
                        resultSet.next();                           // Extract an account from DB selection result
                        return new Account(resultSet.getInt("id"),
                                resultSet.getString("firstName"),
                                resultSet.getString("lastName"),
                                resultSet.getString("email"),
                                resultSet.getString("creationDate"),
                                resultSet.getString("password"),
                                resultSet.getString("role"));
                    }
            );

            return account;
        }
        catch (Exception e) {   // On encountering a log in issue (mostly commonly a bad password), return no account
            return null;
        }
    }

    public void CreateReview(Review review) {
        System.out.println("Account " + review.toString());
        System.out.println("DB connection " + jdbcTemplate.toString());
        jdbcTemplate.execute("INSERT INTO review(accountId, rating, content) VALUES (" +
                "'" + review.getAccount().getId() + "', " +
                "'" + review.getRating() + "', " +
                "'" + review.getContent() + "')"
        );
    }

    public List<Review> GetReviewsByAccount(int account_id) {
        return jdbcTemplate.query("SELECT * FROM review " +
                        "INNER JOIN account ON review.accountId = account.id WHERE accountId=" +account_id,
                (resultSet, rowNum) -> new Review(resultSet.getInt("id"),
                        GetAccountById(account_id),
                        resultSet.getString("creationDate"),
                        resultSet.getInt("rating"),
                        resultSet.getString("content"))
        );
    }

    public List<Review> GetAllReviews() {
        return jdbcTemplate.query("SELECT * FROM review ",
                        (resultSet, rowNum) -> new Review(resultSet.getInt("id"),
                        GetAccountById(resultSet.getInt("accountId")),
                        resultSet.getString("creationDate"),
                        resultSet.getInt("rating"),
                        resultSet.getString("content"))
        );
    }

    public Account GetAccountByEmailStub(String Email){
        return new Account(1, "billy", "bob", "billyBob@gmail.com", java.time.LocalDate.now().toString(), "superPass", "ADMIN");
    }

}
