package com.webmonere.dbservice.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "customer")
public class User {

    public User() {
    }

    public User(String name, String email, String mobile_number) {
        this.name = name;
        this.email = email;
        this.mobile_number = mobile_number;
    }


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(columnDefinition = "serial") // postgresql
    private Long user_id;
    private String name;
    @Column(unique = true)
    private String email;
    @Column(unique = true, length = 15)
    private String mobile_number;

}
