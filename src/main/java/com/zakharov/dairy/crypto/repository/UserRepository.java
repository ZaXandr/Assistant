package com.zakharov.dairy.crypto.repository;

import com.zakharov.dairy.crypto.entity.Deal;
import com.zakharov.dairy.crypto.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}
