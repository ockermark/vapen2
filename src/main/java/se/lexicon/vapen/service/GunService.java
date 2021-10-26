package se.lexicon.vapen.service;

import se.lexicon.vapen.dto.ManufacturerDto;
import se.lexicon.vapen.dto.GunDto;
import se.lexicon.vapen.entity.Gun;

import java.util.List;

public interface GunService {
    Gun create(Gun gun);




    List<Gun> advanceSearch(String name, String model, String version);


}
