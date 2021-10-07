package se.lexicon.vapen.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.vapen.entity.Weapon;

import javax.naming.Name;


public interface WeaponRepository {
}

public interface WeaponRepository extends CrudRepository<T, ID> {

}

public interface  WeaponRepository extends CrudRepository <Weapon,  Integer>{

}

