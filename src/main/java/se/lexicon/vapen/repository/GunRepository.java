package se.lexicon.vapen.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.vapen.dto.GunDto;
import se.lexicon.vapen.entity.Gun;

import java.util.List;

public interface GunRepository extends CrudRepository <Gun,  Integer>{

    List<GunDto> findByName(String name);

    List<GunDto> findByModel(String model);




    List<GunDto> findGunbyVersion(String version);

    List<GunDto> findByNameAndModel(String name, String model);

    GunDto findGunByName(String name);

    GunDto findGunByModel(String model);
}


