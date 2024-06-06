package com.oderzy._config_;

/**

@Configuration
@EnableJpaRepositories(basePackages = {
		"com.oderzy._data_.repositery", }, entityManagerFactoryRef = "postgresEntitymangerFactory")
		*/
public class MyPosgresDataSourceConfig {

	/**
	@Bean(name = "postgreDataSource")
	
	@ConfigurationProperties(prefix = "spring.datasource.postgres")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "postgresEntitymangerFactory")
	
	public LocalContainerEntityManagerFactoryBean postgresEntitymangerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("postgreDataSource") DataSource dataSource, JpaProperties jpaProperties,
			HibernateProperties hibernateProperties) {

		Map<String, Object> properties = hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(),
				new HibernateSettings());

		return builder.dataSource(dataSource).packages("com.oderzy._data_.model").persistenceUnit("postgres")
				.properties(properties).build();

	}
	*/
}
