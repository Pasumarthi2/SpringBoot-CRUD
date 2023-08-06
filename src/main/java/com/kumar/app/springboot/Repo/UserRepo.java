package com.kumar.app.springboot.Repo;

import com.kumar.app.springboot.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

}
