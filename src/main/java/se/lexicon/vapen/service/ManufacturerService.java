package se.lexicon.vapen.service;

import se.lexicon.vapen.dto.ManufacturerDto;
import se.lexicon.vapen.entity.Manufacturer;

import java.util.List;

public interface ManufacturerService {

    ManufacturerDto saveManufacturer (ManufacturerDto dto);
    void deleteManufacturer (Integer id);

    ManufacturerDto findByName (String name);
    ManufacturerDto findById (Integer id);

    List<ManufacturerDto> findAll();



    // old stuff below ***

    Manufacturer saveManufacturerx (Manufacturer manufacturer);
    void deleteManufacturerx (Integer id);

    Manufacturer findByNamex (String name);
    Manufacturer findByIdx (Integer id);

    List<Manufacturer> findAllx();


}
