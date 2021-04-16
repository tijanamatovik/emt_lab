package finki.ukim.mk.emtbooklibrary.repository;

import finki.ukim.mk.emtbooklibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    void deleteByName(String name);
}
