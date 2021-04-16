package finki.ukim.mk.emtbooklibrary.repository;

import finki.ukim.mk.emtbooklibrary.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
