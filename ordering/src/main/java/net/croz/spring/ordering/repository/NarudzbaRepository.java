package net.croz.spring.ordering.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.croz.spring.ordering.model.Narudzba;

@Repository
public interface NarudzbaRepository extends JpaRepository<Narudzba, Long> {
	
}
