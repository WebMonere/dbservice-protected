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
        this.hostname_id = hostname_id;
        this.user_id = user_id;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(columnDefinition = "serial") // postgresql
    private Long id;
    @Column(nullable = false)
    private Long hostname_id;
    @Column(nullable = false)
    private Long user_id;
}
