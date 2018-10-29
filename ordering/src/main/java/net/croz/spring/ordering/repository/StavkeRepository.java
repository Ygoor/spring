package net.croz.spring.ordering.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.croz.spring.ordering.model.Stavke;

@Repository
public interface StavkeRepository extends JpaRepository<Stavke, Long> {
	
}
