package se.lexicon.vapen.service;

import se.lexicon.vapen.dto.ManufacturerDto;
import se.lexicon.vapen.entity.Manufacturer;

import java.util.List;

public interface ManufacturerService {

    ManufacturerDto addManufacturer (ManufacturerDto dto);

    Manufacturer saveManufacturer (Manufacturer manufacturer);

    void deleteManufacturer (Integer id);

    Manufacturer findByName (String name);
    Manufacturer findById (Integer id);
    ManufacturerDto findByIdNew (Integer id);

    List<Manufacturer> findAll();


}
