package com.example.newsfeedapplication;

import com.example.newsfeedapplication.commands.CommandRegistry;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class NewsfeedApplication implements CommandLineRunner {
    private Scanner scanner;

    private CommandRegistry commandRegistry;

    public NewsfeedApplication(CommandRegistry commandRegistry) {
        scanner=new Scanner(System.in);
        this.commandRegistry = commandRegistry;
    }
    @Override
    public void run(String... args) throws Exception {
     while (true){
         System.out.println("Give me input to help you");
         String input=scanner.nextLine();
         commandRegistry.execute(input);
     }
    }

    public static void main(String[] args) {
        SpringApplication.run(NewsfeedApplication.class, args);
    }


}
