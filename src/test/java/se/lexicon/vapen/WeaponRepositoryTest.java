package se.lexicon.vapen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.vapen.entity.Weapon;
import se.lexicon.vapen.repository.WeaponRepository;

import java.util.Optional;

@DataJpaTest
public class WeaponRepositoryTest {



    @Autowired
        WeaponRepository testObject;
        Weapon createdWeapon;

    @BeforeEach
    public void setup() {
        Weapon weapon = new Weapon();
        weapon.setName("Glock");
        weapon.setModel("17");
        weapon.setVersion("gen5");
        createdWeapon = testObject.save(weapon);
        Assertions.assertEquals("Glock", createdWeapon.getName());
    }


    @Test
    public void test_findbyid_object() {
        Optional<Weapon> weaponOptional = testObject.findById(1);
        Assertions.assertNotNull(weaponOptional.get());
    }

    @Test
    public void test_delete_Object() {

        testObject.delete(createdWeapon);
        Optional<Weapon> weaponOptional = testObject.findById(1);
        Assertions.assertFalse(weaponOptional.isPresent());

    }



}
