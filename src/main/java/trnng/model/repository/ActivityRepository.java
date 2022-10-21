package trnng.model.repository;

import org.springframework.stereotype.Repository;
import trnng.model.entities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer> {
}
