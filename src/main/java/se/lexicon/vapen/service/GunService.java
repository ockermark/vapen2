package se.lexicon.vapen.service;
import se.lexicon.vapen.dto.GunDto;
import se.lexicon.vapen.entity.Gun;
import java.util.List;

public interface GunService {

    GunDto saveGun(GunDto dto);

    List<GunDto> findAll();

    GunDto findById(int id);

    GunDto findByName(String name);

    Gun findByModel(String model);

    GunDto findByNameAndVersion(String name, String version);

    List<GunDto> advanceSearch(String name, String model, String version);


    void delete(int id);


}
