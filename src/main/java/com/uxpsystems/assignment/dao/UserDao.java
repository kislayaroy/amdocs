package com.uxpsystems.assignment.dao;

import com.uxpsystems.assignment.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Using CRUD Repository
 */
@Repository
public interface UserDao extends JpaRepository<Users, Long> {

}
