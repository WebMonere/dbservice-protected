package com.webmonere.dbservice.repository;

import com.webmonere.dbservice.model.Hostmapping;
import com.webmonere.dbservice.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


import java.util.List;

@RepositoryRestResource
public interface HostNameMappingRepository extends CrudRepository<Hostmapping,Long> {

    List<Hostmapping>findByhostnameId(Long hostname_id);
    List<Hostmapping>findByUserId(Long user_id);


}
