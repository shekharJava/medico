package com.oderzy._config_;

/**
@Configuration
@EnableJpaRepositories(basePackages = { "com.oderzy.stores_offers", "com.oderzy.customer.repositery",
		"com.oderzy.service.general.repositery", "com.oderzy.whatsapp", "com.oderzy.staff.repositery",
		"com.oderzy.doctor", "com.oderzy.pharma" }, entityManagerFactoryRef = "mysqlEntitymangerFactory")
		
		*/
public class MySqlDataSourceConfig {

	/**
@Bean(name = "mysqlDataSource")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource.mysql")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = "mysqlEntitymangerFactory")
	public LocalContainerEntityManagerFactoryBean mysqlEntitymangerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("mysqlDataSource") DataSource dataSource, JpaProperties jpaProperties,
			HibernateProperties hibernateProperties) {

		Map<String, Object> properties = hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(),
				new HibernateSettings());

		return builder.dataSource(dataSource)
				.packages("com.oderzy.customer.model", "com.oderzy.stores_offers", "com.oderzy.service.general.model",
						"com.oderzy.whatsapp", "com.oderzy.staff.model", "com.oderzy.doctor", "com.oderzy.pharma",
						"com.oderzy.whatsapp")
				.persistenceUnit("mysql").properties(properties).build();

	}
	
	*/
}
