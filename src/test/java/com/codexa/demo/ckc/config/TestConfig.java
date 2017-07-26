package com.codexa.demo.ckc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

/**
 * Created by peter on 26.7.2017.
 */
@Configuration
@EnableCassandraRepositories(basePackages = "com.codexa.demo.ckc.tocassandra")
public class TestConfig extends AbstractCassandraConfiguration {

    @Override
    public String getKeyspaceName() {
        return "sensor_data_test_3";
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.RECREATE_DROP_UNUSED;
    }

    @Bean
    public CassandraOperations cassandraOperations() throws Exception {
        return new CassandraTemplate(session().getObject());
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[]{"com.codexa.demo.ckc.tocassandra"};
    }
}