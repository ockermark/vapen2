package se.lexicon.vapen.service;

import se.lexicon.vapen.dto.ManufacturerDto;
import se.lexicon.vapen.dto.WeaponDto;

public interface VapenService {
    ManufacturerDto buildGun(WeaponDto dto);

    void addGun(String name,String model, String version);

    void  scrapGun(int id, String name, String model, String version);
//do i need to add ind id?


}
