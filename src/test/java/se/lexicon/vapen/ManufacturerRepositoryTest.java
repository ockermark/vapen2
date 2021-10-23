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
    Manufacturer createdManufactorer;

    @BeforeEach
    public void setUp() {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Glock");
        manufacturer.setContactInformation("glockinfo@info.de");
        createdManufactorer = testObject.save(manufacturer);
        Assertions.assertEquals("Glock", createdManufactorer.getName());
    }

    @Test
    public void test_findbyid_object() {
        Optional<Manufacturer> manufacturerOptional = testObject.findById(1);
        Assertions.assertNotNull(manufacturerOptional.get());
    }

    @Test
    public void test_delete_object() {

        testObject.delete(createdManufactorer);
        Optional<Manufacturer> manufacturerOptional = testObject.findById(1);
        Assertions.assertFalse(manufacturerOptional.isPresent());

    }

    //update f

}