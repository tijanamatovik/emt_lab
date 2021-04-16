package finki.ukim.mk.emtbooklibrary.web.controller;

import finki.ukim.mk.emtbooklibrary.model.Book;
import finki.ukim.mk.emtbooklibrary.model.dto.BookDto;
import finki.ukim.mk.emtbooklibrary.model.enumeration.Category;
import finki.ukim.mk.emtbooklibrary.service.BookService;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> findAll()
    {
        return bookService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id)
    {
        return this.bookService.findById(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(()->ResponseEntity.notFound().build());
    }

   @PostMapping("/add")
    public ResponseEntity<Book> save(@RequestBody BookDto bookDto)
   {
       return this.bookService.save(bookDto)
               .map(book -> ResponseEntity.ok().body(book))
               .orElseGet(()->ResponseEntity.badRequest().build());
   }
    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> edit(@PathVariable Long id,@RequestBody BookDto bookDto)
    {
        return this.bookService.edit(id,bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }
   @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id)
   {
       this.bookService.deleteById(id);
       if(!bookService.findById(id).isEmpty())
       {
           return ResponseEntity.badRequest().build();
       }
       return ResponseEntity.ok().build();

   }
   @PostMapping("/available-copies/{id}")
    public ResponseEntity<Book> changeAvailableCopie(@PathVariable Long id)
   {
       return this.bookService.changeAvailableCopies(id)
               .map(book -> ResponseEntity.ok().body(book))
               .orElseGet(()->ResponseEntity.badRequest().build());
   }
   @GetMapping("/categories")
    public Category[] findAllCategories()
   {
       return Category.values();
   }
}
