package com.webmonere.dbservice.repository;

import com.webmonere.dbservice.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends CrudRepository<User,Long> {
}
