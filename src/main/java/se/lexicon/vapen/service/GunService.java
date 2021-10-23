package se.lexicon.vapen.service;

import se.lexicon.vapen.dto.ManufacturerDto;
import se.lexicon.vapen.dto.GunDto;

public interface GunService {
    ManufacturerDto buildGun(GunDto dto);

    void addGun(String name,String model, String version);

    void  scrapGun(int id, String name, String model, String version);
//do i need to add ind id?


}
