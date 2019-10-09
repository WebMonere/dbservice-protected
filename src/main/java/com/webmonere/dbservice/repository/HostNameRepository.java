package com.webmonere.dbservice.repository;

import com.webmonere.dbservice.model.Hostname;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface HostNameRepository extends CrudRepository<Hostname,Long> {
}
