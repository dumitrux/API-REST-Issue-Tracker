package com.example.issuetrackerrest.repository;

import com.example.issuetrackerrest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional
    User findByUsername(String username);

    @Transactional
    User findByApikey(String apikey);


}
