package org.metahut.octopus.dao.repository;

import org.metahut.octopus.dao.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
