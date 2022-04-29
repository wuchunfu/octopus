package org.metahut.octopus.dao.repository;

import org.metahut.octopus.dao.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 *
 */
public interface UserRepositoryExtension extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {
    /**
     * delete by code
     * @param code
     */
    long deleteByCode(Long code);

    /**
     * delete by code or name
     * warn : it first query data's id,when try to delete huge data please use sql under
     * @param code
     * @param name
     * @return
     */
    long deleteByCodeOrName(Long code,String name);

    @Query("delete from User where code = ?1 or name =?2")
    @Modifying
    Integer sqlDeleteByCodeOrName(Long code,String name);

    int deleteByCodeAndNameLike(Long code,String name);

    int deleteByCodeAndNameContaining(Long code,String name);

    int deleteByCodeAndNameStartingWith(Long code,String name);

}
