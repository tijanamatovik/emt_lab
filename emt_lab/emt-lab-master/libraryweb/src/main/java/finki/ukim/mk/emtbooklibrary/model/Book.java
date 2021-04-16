package finki.ukim.mk.emtbooklibrary.model;

import finki.ukim.mk.emtbooklibrary.model.enumeration.Category;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(value = EnumType.STRING)
    private Category category;
    @ManyToOne
    private Author author;
    private Integer availablecopies;

    public Book() {
    }

    public Book(Long id, String name, Category category, Author author, Integer availablecopies) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.author = author;
        this.availablecopies = availablecopies;
    }

    public Book(String name, Category category, Author author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availablecopies = availableCopies;
    }
}
