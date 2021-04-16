package finki.ukim.mk.emtbooklibrary.service.impl;

import finki.ukim.mk.emtbooklibrary.model.Author;
import finki.ukim.mk.emtbooklibrary.repository.AuthorRepository;
import finki.ukim.mk.emtbooklibrary.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }
}
