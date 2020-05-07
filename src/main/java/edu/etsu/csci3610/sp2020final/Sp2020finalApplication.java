package edu.etsu.csci3610.sp2020final;

import edu.etsu.csci3610.sp2020final.configurations.DatabaseInterchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Sp2020finalApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(Sp2020finalApplication.class, args);
	}
}
