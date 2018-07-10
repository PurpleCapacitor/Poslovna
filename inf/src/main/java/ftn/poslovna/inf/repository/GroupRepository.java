package ftn.poslovna.inf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.poslovna.inf.domain.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

}
