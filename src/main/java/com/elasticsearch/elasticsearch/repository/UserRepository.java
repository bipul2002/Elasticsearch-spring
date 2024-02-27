package com.elasticsearch.elasticsearch.repository;


import com.elasticsearch.elasticsearch.entity.Groups;
import com.elasticsearch.elasticsearch.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    public  User findByEmail(String email);

    public List<User> findByGroups(Groups group);
}
