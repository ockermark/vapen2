package se.lexicon.vapen;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.vapen.entity.Manufacturer;
import se.lexicon.vapen.repository.ManufacturerRepository;

import java.util.Optional;

@DataJpaTest
public class ManufacturerRepositoryTest {

    @Autowired
    ManufacturerRepository testObject;
    Manufacturer createdManufacturer;

    @BeforeEach
    public void setUp() {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Glock");
        manufacturer.setContactInformation("glockinfo@info.de");
        createdManufacturer = testObject.save(manufacturer);
        Assertions.assertEquals("Glock", createdManufacturer.getName());
    }

    @Test
    public void test_findbyid_object() {
        Optional<Manufacturer> manufacturerOptional = testObject.findById(1);
        Assertions.assertNotNull(manufacturerOptional.get());
    }

    @Test
    public void test_delete_object() {

        testObject.delete(createdManufacturer);
        Optional<Manufacturer> manufacturerOptional = testObject.findById(1);
        Assertions.assertFalse(manufacturerOptional.isPresent());

    }

    //update f

}