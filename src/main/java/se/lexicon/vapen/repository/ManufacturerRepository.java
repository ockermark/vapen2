package se.lexicon.vapen.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.vapen.entity.Manufacturer;

public interface ManufacturerRepository extends CrudRepository<Manufacturer, Integer> {
}
