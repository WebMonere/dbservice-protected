package com.webmonere.dbservice.repository;

import com.webmonere.dbservice.model.Hostmapping;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface HostNameMappingRepository extends CrudRepository<Hostmapping,Long> {
}
