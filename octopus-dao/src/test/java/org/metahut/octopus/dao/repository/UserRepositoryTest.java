package org.metahut.octopus.dao.repository;

import org.metahut.octopus.dao.entity.User;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() {
        User user = new User();
        user.setCode(1L);
        user.setName("test");
        User save = userRepository.save(user);
        Assertions.assertNotNull(save);
        Optional<User> byId = userRepository.findById(save.getId());
        Assertions.assertTrue(byId.isPresent());
        User user1 = byId.get();
        Assertions.assertNotNull(user1);
    }

}
