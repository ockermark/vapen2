package se.lexicon.vapen;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.vapen.entity.User;
import se.lexicon.vapen.repository.UserRepository;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.Optional;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    UserRepository testObject;

    User createdUser;


    @BeforeEach
    public void setup() {
        User user = new User();
        user.setName("Oskar");
        user.setType("web");
        createdUser = testObject.save(user);
        Assertions.assertEquals("Oskar", createdUser.getName());
    }

    @Test
    public void test_delete_object() {
        testObject.delete(createdUser);
        Optional<User> userOptional =testObject.findById(1);
        Assertions.assertFalse(userOptional.isPresent());


    }



}
