package com.elasticsearch.elasticsearch.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "\"user\"")
public class User {

    @Id // JPA annotation
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;
    private String email;
    private String password;
    private String address;
    private Long age;
    private String phone;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Profile profile;

    @OneToMany(mappedBy = "admin",cascade = CascadeType.ALL)
    private List<Groups> groupsAdmin;

    @ManyToMany(mappedBy = "members")
    private List<Groups> groups;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Company> companiesAdmin;

    @ManyToMany(mappedBy = "followers")
//    @JoinTable(
//            name = "user_following_company",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "company_id")
//    )
    private List<Company> followingCompanies;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Institution> institutionAdmin;

    @ManyToMany(mappedBy = "followers")
    private List<Institution> followingInstitutions;
}
