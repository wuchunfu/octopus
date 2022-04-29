package org.metahut.octopus.dao.entity;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import java.util.Date;

/**
 *
 */
@StaticMetamodel(User.class)
public class User_ {
    public static volatile SingularAttribute<User, Integer> id;

    public static volatile SingularAttribute<User, Date> updateTime;

    public static volatile SingularAttribute<User, String> name;
}
