package se.lexicon.vapen.service;

import se.lexicon.vapen.dto.ManufacturerDto;
import se.lexicon.vapen.entity.Manufacturer;

import java.util.List;

public interface ManufacturerService {

    ManufacturerDto addManufacturer(ManufacturerDto dto);

    // Manufacturer addManufacturer(String name, String contactInformation);
    void deleteManufacturer(Integer id);

    Manufacturer findByName(String name);
    Manufacturer findById (Integer id);

    List<Manufacturer> findAll();


}
