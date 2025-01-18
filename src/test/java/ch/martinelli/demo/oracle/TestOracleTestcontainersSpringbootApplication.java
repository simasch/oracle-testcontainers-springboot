package ch.martinelli.demo.oracle;

import org.springframework.boot.SpringApplication;

public class TestOracleTestcontainersSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.from(OracleTestcontainersSpringbootApplication::main)
			.with(TestcontainersConfiguration.class)
			.run(args);
	}

}
