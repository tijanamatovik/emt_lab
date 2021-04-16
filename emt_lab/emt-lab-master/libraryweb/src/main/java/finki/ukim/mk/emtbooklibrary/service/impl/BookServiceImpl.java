package finki.ukim.mk.emtbooklibrary.service.impl;

import finki.ukim.mk.emtbooklibrary.model.Author;
import finki.ukim.mk.emtbooklibrary.model.Book;
import finki.ukim.mk.emtbooklibrary.model.dto.BookDto;
import finki.ukim.mk.emtbooklibrary.model.enumeration.Category;
import finki.ukim.mk.emtbooklibrary.model.exception.AuthorNotFoundException;
import finki.ukim.mk.emtbooklibrary.model.exception.BookNotFoundException;
import finki.ukim.mk.emtbooklibrary.repository.AuthorRepository;
import finki.ukim.mk.emtbooklibrary.repository.BookRepository;
import finki.ukim.mk.emtbooklibrary.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Author author=authorRepository.findById(bookDto.getAuthor()).orElseThrow(()->new AuthorNotFoundException(bookDto.getAuthor()));
        this.bookRepository.deleteByName(bookDto.getName());
        Book book=new Book(bookDto.getName(), bookDto.getCategory(),author,bookDto.getAvailablecopies());
        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public void deleteById(Long id) {
           this.bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book oldBook=this.findById(id).orElseThrow(()->new BookNotFoundException(id));
        Author author=authorRepository.findById(bookDto.getAuthor()).orElseThrow(()->new AuthorNotFoundException(bookDto.getAuthor()));
        oldBook.setAuthor(author);
        oldBook.setCategory(bookDto.getCategory());
        oldBook.setName(bookDto.getName());
        oldBook.setAvailablecopies(bookDto.getAvailablecopies());
        return Optional.of(this.bookRepository.save(oldBook));

    }

    @Override
    public Optional<Book> changeAvailableCopies(Long bookId) {
        Book oldBook=this.findById(bookId).orElseThrow(()->new BookNotFoundException(bookId));
        oldBook.setAvailablecopies(oldBook.getAvailablecopies()-1);
        return Optional.of(this.bookRepository.save(oldBook));
    }
    @GetMapping("/categories")
    public List<String> findAllCategories()
    {
        List<String> categories=new ArrayList<>();
        for(Category c: Category.values())
        {
            categories.add(String.valueOf(c));
        }
        return categories;
    }
}
