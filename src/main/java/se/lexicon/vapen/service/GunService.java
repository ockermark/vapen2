package se.lexicon.vapen.service;

import se.lexicon.vapen.dto.ManufacturerDto;
import se.lexicon.vapen.dto.GunDto;
import se.lexicon.vapen.entity.Gun;

import java.util.List;

public interface GunService {
    ManufacturerDto buildGun(GunDto dto);

    Gun create(Gun gun);

    List<Gun> advanceSearch(String name, String model, String version);


    void addGun(String name,String model, String version);

    void  scrapGun(int id, String name, String model, String version);
//do i need to add ind id?


}
