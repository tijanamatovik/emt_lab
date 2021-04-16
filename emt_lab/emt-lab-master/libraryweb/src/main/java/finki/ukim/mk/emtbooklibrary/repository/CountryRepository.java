package finki.ukim.mk.emtbooklibrary.repository;

import finki.ukim.mk.emtbooklibrary.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
