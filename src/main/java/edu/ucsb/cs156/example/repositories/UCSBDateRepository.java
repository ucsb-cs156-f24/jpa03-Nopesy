package edu.ucsb.cs156.example.repositories;

import edu.ucsb.cs156.example.entities.UCSBDate;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * The UCSBDateRepository is a repository for UCSBDate entities.
 */

@Repository
public interface UCSBDateRepository extends CrudRepository<UCSBDate, Long> {
  /**
   * This method returns all UCSBDate entities with a given quarterYYYYQ.
   * @param quarterYYYYQ
   * @return all UCSBDate entities with a given quarterYYYYQ
   */
  Iterable<UCSBDate> findAllByQuarterYYYYQ(String quarterYYYYQ);
}