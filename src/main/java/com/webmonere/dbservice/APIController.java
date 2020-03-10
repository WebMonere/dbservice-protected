package com.webmonere.dbservice;


import com.webmonere.dbservice.model.Hostmapping;
import com.webmonere.dbservice.model.Hostname;
import com.webmonere.dbservice.model.Message;
import com.webmonere.dbservice.model.User;
import com.webmonere.dbservice.repository.HostNameMappingRepository;
import com.webmonere.dbservice.repository.HostNameRepository;
import com.webmonere.dbservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class APIController {

    @Autowired
    HostNameMappingRepository hostNameMappingRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    HostNameRepository hostNameRepository;

    @GetMapping(value = "/uids/{hostnameid}")
    public ArrayList<String> getAllUserIds(@PathVariable String hostnameid) {

        List<Hostmapping> hostmappings;
        ArrayList<String> usids = new ArrayList<>();
        hostmappings = hostNameMappingRepository.findByhostnameId(Long.parseLong(hostnameid));
        for (Hostmapping hm : hostmappings) {
            usids.add(hm.getUserId().toString());
        }
        return usids;
    }

    @GetMapping(value = "/public/{hostnameid}")
    public List<Hostmapping> publicEndpoint(@PathVariable String hostnameid) {

        return hostNameMappingRepository.findByhostnameId(Long.parseLong(hostnameid));
    }

    @GetMapping(value = "/email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userRepository.findByEmail(email);
    }

    @GetMapping(value = "/hostnamesbyid/{userid}")
    public List<Hostname> getAllHostNamesId(@PathVariable Long userid) {
        ArrayList<Hostname> hostnames = new ArrayList<>();
        List<Hostmapping> hostmappings;
        hostmappings = hostNameMappingRepository.findByUserId(userid);
        for (Hostmapping hm : hostmappings) {

            Hostname hostname = hostNameRepository.findByHostnameId(hm.getHostnameId());
            hostnames.add(hostname);
        }


        return hostnames;

    }


    @GetMapping(value = "/private")
    public Message privateEndpoint() {
        return new Message("All good. You can see this because you are Authenticated.");
    }

    @GetMapping(value = "/private-scoped")
    public Message privateScopedEndpoint() {
        return new Message("All good. You can see this because you are Authenticated with a Token granted the 'read:messages' scope");
    }
}