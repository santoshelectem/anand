/**
 * 
 */
package com.example.postgresdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.postgresdemo.model.Developer;

/**
 * @author Cybertech1
 *
 */
@Repository
public interface DeveloperRepository  extends JpaRepository<Developer, Integer> {
	
	@Query(value = "SELECT d.* from developer d INNER JOIN  task t on t.developer_id = d.developer_id INNER JOIN status s on s.status_id = d.status_id order by s.to_do_count desc limit 1", nativeQuery = true)
	Developer findDeveloperLesCount();

}
