package com.bohosi.yhf.dao.spring;

import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.Executor;

import javax.persistence.SharedCacheMode;
import javax.persistence.ValidationMode;
import javax.sql.DataSource;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.QueryLookupStrategy.Key;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableScheduling
//@ComponentScan(basePackages = "com.bohosi.yhf.dao")
@EnableAsync(mode = AdviceMode.PROXY, proxyTargetClass = false, order = Ordered.HIGHEST_PRECEDENCE)
@EnableTransactionManagement(mode = AdviceMode.PROXY, proxyTargetClass = false, order = Ordered.LOWEST_PRECEDENCE)
@EnableJpaRepositories(queryLookupStrategy = Key.CREATE_IF_NOT_FOUND, basePackages = "com.bohosi.yhf.dao.repositories", entityManagerFactoryRef = "entityManagerFactoryBean", transactionManagerRef = "jpaTransactionManager")
public class DaoContextConfiguration implements AsyncConfigurer, SchedulingConfigurer
{

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean()
	{
		Map<String, Object> properties = new Hashtable<String, Object>();
		properties.put("javax.persistence.schema-generation.database.action", "none");
		properties.put("hibernate.ejb.use_class_enhancer", "false");

		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		//adapter.setShowSql(true);
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(adapter);
		factory.setDataSource(this.customerSupportDataSource());
		factory.setPackagesToScan("com.bohosi.yhf.dao.entity");
		factory.setSharedCacheMode(SharedCacheMode.ENABLE_SELECTIVE);
		factory.setValidationMode(ValidationMode.NONE);
		//factory.setLoadTimeWeaver(this.loadTimeWeaver); // TODO: remove when SPR-10856 fixed
		factory.setJpaPropertyMap(properties);
		return factory;
	}

	@Bean
	public PlatformTransactionManager jpaTransactionManager()
	{
		return new JpaTransactionManager(this.entityManagerFactoryBean().getObject());
	}

	@Bean
	public DataSource customerSupportDataSource()
	{
		JndiDataSourceLookup lookup = new JndiDataSourceLookup();
		return lookup.getDataSource("jdbc/ddkfang");
	}

	public void configureTasks(ScheduledTaskRegistrar arg0)
	{
		// TODO Auto-generated method stub

	}

	public Executor getAsyncExecutor()
	{
		// TODO Auto-generated method stub
		return null;
	}

	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
