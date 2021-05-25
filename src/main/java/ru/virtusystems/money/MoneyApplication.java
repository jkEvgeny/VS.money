package ru.virtusystems.money;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.virtusystems.money.service.PolicyholderService;

@SpringBootApplication
public class MoneyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MoneyApplication.class, args);
    }
}
