package com.itheima.domain;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import javax.sql.DataSource;

@Configuration
public class TransactionConfig {

    @Bean("myDataSource")
    public DataSource myDataSource() {
        // 在此配置自定义的数据源
        DataSourceProperties dataSourceProperties = new DataSourceProperties();
        dataSourceProperties.setUrl("jdbc:mysql://localhost:3306/mydatabase");
        dataSourceProperties.setUsername("root");
        dataSourceProperties.setPassword("123456");
        // 其他数据源配置信息...

        return DataSourceBuilder.create()
            .driverClassName(dataSourceProperties.getDriverClassName())
            .url(dataSourceProperties.getUrl())
            .username(dataSourceProperties.getUsername())
            .password(dataSourceProperties.getPassword())
            // 其他数据源配置信息...
            .build();
    }

    @Bean
    public PlatformTransactionManager myTransactionManager(@Qualifier("myDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }


    @Bean("txAdvice")
    public TransactionInterceptor transactionInterceptor(
            @Qualifier("myTransactionManager") PlatformTransactionManager transactionManager) {
        final RuleBasedTransactionAttribute attribute1 = new RuleBasedTransactionAttribute();
        attribute1.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        attribute1.setIsolationLevel(TransactionDefinition.ISOLATION_DEFAULT);
        attribute1.setTimeout(TransactionDefinition.TIMEOUT_DEFAULT);
        attribute1.setReadOnly(false);

        final RuleBasedTransactionAttribute attribute2 = new RuleBasedTransactionAttribute();
        attribute2.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        attribute2.setIsolationLevel(TransactionDefinition.ISOLATION_DEFAULT);
        attribute2.setTimeout(TransactionDefinition.TIMEOUT_DEFAULT);
        attribute2.setReadOnly(true);

        final TransactionInterceptor transactionInterceptor = new TransactionInterceptor();
        transactionInterceptor.setTransactionManager(transactionManager);

        final NameMatchTransactionAttributeSource attributeSource = new NameMatchTransactionAttributeSource();
        attributeSource.addTransactionalMethod("save*", attribute1);
        attributeSource.addTransactionalMethod("query*", attribute2);

        transactionInterceptor.setTransactionAttributeSource(attributeSource);

        return transactionInterceptor;
    }
}
