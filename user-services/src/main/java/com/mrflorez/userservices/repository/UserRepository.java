package com.mrflorez.userservices.repository;

import com.mrflorez.userservices.model.UserSeg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserSeg, Long> {

    UserSeg findByUsername(String username);


}
