package com.jas.digitalgourmet.dao.persistentobject;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.jas.digitalgourmet.dao", 
  repositoryBaseClass = PersistentObjectImplDAO.class)
public class DAOJPAH2Config {

}
