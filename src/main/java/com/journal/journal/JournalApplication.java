package com.journal.journal;

import com.journal.journal.model.Account;
import com.journal.journal.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
@EnableAutoConfiguration
public class JournalApplication {

	private static final Logger log = LoggerFactory.getLogger(JournalApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JournalApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(AccountRepository repository) {
		return (args) -> {
			// populate with demo accounts
//			repository.save(new Account(null,"10001", "CASH A/C"));
//			repository.save(new Account(null,"20001", "PAYBILL A/C\n"));
//			repository.save(new Account(null,"1003", "Dollar"));
//			repository.save(new Account(null,"1004", "Salary"));
//			repository.save(new Account(null,"1005", "Internet Account"));

			// fetch all customers
			log.info("Accounts found with findAll():");
			log.info("-------------------------------");
			for (Account account : repository.findAll()) {
				log.info(account.toString());
			}
			log.info("");

			// fetch an individual account by "1002"
			Optional<Account> account = Optional.ofNullable(repository.findByAccountNo("1002"));
			log.info("Account found with findById(1002):");
			log.info("--------------------------------");
			log.info(account.toString());
			log.info("");

		};
	}

}
