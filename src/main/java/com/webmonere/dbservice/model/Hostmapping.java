package com.webmonere.dbservice.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "hostmapping")
public class Hostmapping {

    public Hostmapping() {
    }

    public Hostmapping(Long hostname_id, Long user_id) {
        this.hostnameId = hostname_id;
        this.userId = user_id;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(columnDefinition = "serial") // postgresql
    private Long id;
    @Column(nullable = false)
    private Long hostnameId;
    @Column(nullable = false)
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHostnameId() {
        return hostnameId;
    }

    public void setHostnameId(Long hostnameId) {
        this.hostnameId = hostnameId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
