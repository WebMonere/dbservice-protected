package com.webmonere.dbservice;

import com.webmonere.dbservice.model.Hostmapping;
import com.webmonere.dbservice.model.Hostname;
import com.webmonere.dbservice.model.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class RestRepoConfig extends RepositoryRestConfigurerAdapter {
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Hostname.class);
        config.exposeIdsFor(Hostmapping.class);
        config.exposeIdsFor(User.class);
    }
}
