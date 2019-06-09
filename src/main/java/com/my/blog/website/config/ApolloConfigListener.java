package com.my.blog.website.config;

import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApolloConfigListener implements ApplicationContextAware {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApolloConfigListener.class);
    @Autowired
    private ApplicationContext applicationContext = null;
    @Autowired
    private RefreshScope refreshScope = null;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
    @ApolloConfigChangeListener
    public void onChange(ConfigChangeEvent changeEvent) {

        this.refreshProperties(changeEvent);
    }
    public void refreshProperties(ConfigChangeEvent changeEvent) {
        this.applicationContext.publishEvent(new EnvironmentChangeEvent(changeEvent.changedKeys()));
        this.refreshScope.refreshAll();
    }
}
