package se.lexicon.vapen.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.vapen.entity.Gun;

import java.util.List;

public interface GunRepository extends CrudRepository <Gun,  Integer>{

    List<Gun> findByName(String name);

    List<Gun> findByModel(String model);




    List<Gun> findGunbyVersion(String version);

    List<Gun> findByNameAndModel(String name, String model);

    Gun findGunByName(String name);

    Gun findGunByModel(String model);
}


