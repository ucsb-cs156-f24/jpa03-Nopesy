package edu.ucsb.cs156.example.repositories;

import edu.ucsb.cs156.example.entities.Todo;
import edu.ucsb.cs156.example.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/**
 * The TodoRepository is a repository for Todo entities.
 */

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
  /** 
   * This method returns a Todo entity with a given id and user.
   * @param id id of the todo
   * @param user user of the todo
   * @return Optional of Todo (empty if not found)
   */
  Optional<Todo> findByIdAndUser(long id, User user);
  /**
   * This method returns all Todo entities with a given user_id.
   * @param user_id id of the user
   * @return all Todo entities with a given user_id
   */
  Iterable<Todo> findAllByUserId(Long user_id);
}
