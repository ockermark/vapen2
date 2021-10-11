package se.lexicon.vapen.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.vapen.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
