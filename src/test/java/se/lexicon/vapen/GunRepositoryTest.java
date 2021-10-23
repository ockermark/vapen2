package se.lexicon.vapen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.vapen.entity.Gun;
import se.lexicon.vapen.repository.GunRepository;

import java.util.Optional;

@DataJpaTest
public class GunRepositoryTest {



    @Autowired
    GunRepository testObject;
        Gun createdGun;

    @BeforeEach
    public void setup() {
        Gun gun = new Gun();
        gun.setName("Glock");
        gun.setModel("17");
        gun.setVersion("gen5");
        createdGun = testObject.save(gun);
        Assertions.assertEquals("Glock", createdGun.getName());
    }


    @Test
    public void test_findbyid_object() {
        Optional<Gun> weaponOptional = testObject.findById(1);
        Assertions.assertNotNull(weaponOptional.get());
    }

    @Test
    public void test_delete_Object() {

        testObject.delete(createdGun);
        Optional<Gun> weaponOptional = testObject.findById(1);
        Assertions.assertFalse(weaponOptional.isPresent());

    }



}
