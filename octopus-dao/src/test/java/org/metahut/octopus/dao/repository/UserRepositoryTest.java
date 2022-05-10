package org.metahut.octopus.dao.repository;

import org.metahut.octopus.dao.entity.User;
import org.metahut.octopus.dao.entity.User_;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class UserRepositoryTest  {

    @Resource
    private UserRepositoryExtension userRepositoryExtension;

    @BeforeEach
    @Transactional
    public void prepareData() {
        User user1 = new User();
        user1.setCode(1L);
        user1.setName("Mr.Wolf");
        userRepositoryExtension.save(user1);
        User user2 = new User();
        user2.setCode(2L);
        user2.setName("Mr.Tigger");
        userRepositoryExtension.save(user2);
        User user3 = new User();
        user3.setCode(3L);
        user3.setName("Miss.Lion");
        userRepositoryExtension.save(user3);
    }

    @AfterEach
    @Transactional
    public void deleteData() {
        userRepositoryExtension.deleteAll();
    }

    @Test
    public void testJpa() {
        User user = new User();
        user.setCode(1L);
        Optional<User> byId = userRepositoryExtension.findOne(Example.of(user));
        Assertions.assertTrue(byId.isPresent());
        User user1 = byId.get();
        Assertions.assertNotNull(user1);
    }

    @Test
    @Transactional
    @Rollback
    public void testDeleteByCode() {
        Long result = userRepositoryExtension.deleteByCode(1L);
        Assertions.assertTrue(result == 1L);
        int size = userRepositoryExtension.findAll().size();
        Assertions.assertTrue(size == 2);
    }

    @Test
    @Transactional
    @Rollback
    public void testDeleteById() {
        Assertions.assertThrowsExactly(EmptyResultDataAccessException.class,() -> {
            userRepositoryExtension.deleteById(-1);
        });
    }

    @Test
    @Transactional
    @Rollback
    public void testDeleteByCodeOrName() {
        Long result = userRepositoryExtension.deleteByCodeOrName(1L,"Miss.Lion");
        Assertions.assertTrue(result == 2);
        int size = userRepositoryExtension.findAll().size();
        Assertions.assertTrue(size == 1);
    }

    @Test
    @Transactional
    @Rollback
    public void testSqlDeleteByCodeOrName() {
        Integer result = userRepositoryExtension.sqlDeleteByCodeOrName(1L,"Miss.Lion");
        Assertions.assertTrue(result == 2);
        int size = userRepositoryExtension.findAll().size();
        Assertions.assertTrue(size == 1);
    }

    @Test
    @Transactional
    @Rollback
    public void testDeleteByCodeAndNameLike() {
        Integer result = userRepositoryExtension.deleteByCodeAndNameLike(2L,"%Mr%");
        Assertions.assertTrue(result == 1);
        int size = userRepositoryExtension.findAll().size();
        Assertions.assertTrue(size == 2);
    }

    @Test
    @Transactional
    @Rollback
    public void testDeleteByCodeAndNameContaining() {
        Integer result = userRepositoryExtension.deleteByCodeAndNameContaining(2L,"Mr");
        Assertions.assertTrue(result == 1);
        int size = userRepositoryExtension.findAll().size();
        Assertions.assertTrue(size == 2);
    }

    @Test
    @Transactional
    @Rollback
    public void testDeleteByCodeAndNameStartingWith() {
        Integer result = userRepositoryExtension.deleteByCodeAndNameStartingWith(2L,"Mr");
        Assertions.assertTrue(result == 1);
        int size = userRepositoryExtension.findAll().size();
        Assertions.assertTrue(size == 2);
    }

    @Test
    @Transactional
    @Rollback
    public void updateNameByCode() {
        User user = new User();
        user.setCode(2L);
        Optional<User> one = userRepositoryExtension.findOne(Example.of(user));
        Assertions.assertTrue(one.isPresent());
        one.get().setName("Miss.Cat");
        User save = userRepositoryExtension.save(one.get());
        Assertions.assertTrue("Miss.Cat".equals(save.getName()));
    }

    @Test
    public void queryByExample() {
        User user = new User();
        user.setName("Mr.Tigger");
        List<User> all = userRepositoryExtension.findAll(Example.of(user));
        Assertions.assertTrue(all.size() > 0);
    }

    @Test
    public void testPageAll() {
        Sort.TypedSort<User> typedSort = Sort.sort(User.class);
        Sort sort = typedSort.by(User::getUpdateTime).descending()
                .and(typedSort.by(User::getId)).ascending();
        PageRequest of = PageRequest.of(0, 2, sort);
        Page<User> all = userRepositoryExtension.findAll(of);
        Assertions.assertTrue(all.getTotalElements() == 3);
    }

    @Test
    public void testExamplePageAll() {
        User user = new User();
        user.setName("Mr.Tigger");
        Sort.TypedSort<User> typedSort = Sort.sort(User.class);
        Sort sort = typedSort.by(User::getUpdateTime).descending()
                .and(typedSort.by(User::getId)).ascending();
        PageRequest of = PageRequest.of(0, 2, sort);
        Page<User> all = userRepositoryExtension.findAll(Example.of(user),of);
        Assertions.assertTrue(all.getTotalElements() == 1);
    }

    @Test
    public void testQueryPage() {
        Sort.TypedSort<User> typedSort = Sort.sort(User.class);
        Sort sort = typedSort.by(User::getUpdateTime).descending()
                .and(typedSort.by(User::getId)).ascending();
        PageRequest of = PageRequest.of(1, 2, sort);
        Page<User> mr = userRepositoryExtension.findAll((Specification<User>) (root, query, builder) -> {
            return builder.like(root.get(User_.name), "%Mr.W%");
        }, of);
        Assertions.assertTrue(mr.getTotalElements() == 2);
    }

}
