package se.lexicon.vapen.service;
import se.lexicon.vapen.dto.GunDto;
import se.lexicon.vapen.dto.ManufacturerDto;
import se.lexicon.vapen.entity.Gun;
import java.util.List;

public interface GunService {

    ManufacturerDto saveGun(GunDto dto);

    List<Gun> findAll();

    Gun findById(int id);

    Gun findByName(String name);

    Gun findByModel(String model);

    Gun findByNameAndVersion(String name, String version);

    List<Gun> advanceSearch(String name, String model, String version);


    void delete(int id);

    Gun saveGun(Gun gun);
}
