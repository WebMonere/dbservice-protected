package com.webmonere.dbservice.model;

import lombok.Data;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
@Data
@Table(name = "hostname")
public class Hostname {

    public Hostname() {
    }

    public Hostname(String hostname) {
        this.hostname = hostname;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(columnDefinition = "serial") // postgresql
    private Long  hostname_id;
    @Column(nullable = false)
    private String hostname;

}
