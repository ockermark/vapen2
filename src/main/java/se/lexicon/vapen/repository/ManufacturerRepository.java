package se.lexicon.vapen.repository;


import org.springframework.data.repository.CrudRepository;
import se.lexicon.vapen.entity.Manufacturer;

import java.util.List;

public interface ManufacturerRepository extends CrudRepository<Manufacturer, Integer> {

     static List<Manufacturer> findByName(String name);




}
