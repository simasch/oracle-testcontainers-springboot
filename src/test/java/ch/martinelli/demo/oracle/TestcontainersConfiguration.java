package ch.martinelli.demo.oracle;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.DynamicPropertyRegistrar;
import org.testcontainers.oracle.OracleContainer;
import org.testcontainers.utility.DockerImageName;
import org.testcontainers.utility.MountableFile;

@TestConfiguration(proxyBeanMethods = false)
public class TestcontainersConfiguration {

	static final String DEMOOWNER = "demoowner";

	static final String DEMOUSER = "demouser";

	static final String PASSWORD = "password";

	static OracleContainer oracleContainer = new OracleContainer(
			DockerImageName.parse("gvenzl/oracle-free:23-slim-faststart"))
		.withCopyFileToContainer(MountableFile.forClasspathResource("init_users.sql"),
				"/container-entrypoint-initdb.d/init_users.sql")
		.withUsername(DEMOOWNER)
		.withPassword(PASSWORD);

	@Bean
	DynamicPropertyRegistrar registerDatabaseProperties() {
		oracleContainer.start();

		return registry -> {
			registry.add("spring.datasource.url", oracleContainer::getJdbcUrl);
			registry.add("spring.datasource.username", () -> DEMOUSER);
			registry.add("spring.datasource.password", () -> PASSWORD);
			registry.add("spring.flyway.user", () -> DEMOOWNER);
			registry.add("spring.flyway.password", () -> PASSWORD);
		};
	}

}
