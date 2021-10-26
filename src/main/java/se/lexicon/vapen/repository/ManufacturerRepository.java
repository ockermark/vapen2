package se.lexicon.vapen.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import se.lexicon.vapen.entity.Manufacturer;

import java.util.List;

public interface ManufacturerRepository extends CrudRepository<Manufacturer, Integer> {
      List<Manufacturer> findByName(String name);
}
