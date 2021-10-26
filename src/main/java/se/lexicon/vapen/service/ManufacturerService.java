package se.lexicon.vapen.service;

import se.lexicon.vapen.dto.ManufacturerDto;
import se.lexicon.vapen.entity.Manufacturer;

import java.util.List;

public interface ManufacturerService {

    ManufacturerDto addManufacturer(ManufacturerDto dto);

    void addManufacturer(String name, String contactInformation);

    void deleteManufacturer(Integer id);

    List<Manufacturer> searchManufacturer(String name);


}
