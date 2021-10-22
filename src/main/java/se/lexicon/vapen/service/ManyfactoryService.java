package se.lexicon.vapen.service;

import se.lexicon.vapen.dto.ManufacturerDto;

public interface ManyfactoryService {
    ManufacturerDto createGun(ManufacturerDto dto);

    void manufact(String name, String contactInformation);

    void scrap(String name, String contactInformation);




    // define all methods
}
