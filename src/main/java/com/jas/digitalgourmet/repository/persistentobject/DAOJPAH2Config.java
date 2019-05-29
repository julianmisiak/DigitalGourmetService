package com.jas.digitalgourmet.repository.persistentobject;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.jas.digitalgourmet.repository", 
  repositoryBaseClass = PersistentObjectImplRepository.class)
public class DAOJPAH2Config {

}
