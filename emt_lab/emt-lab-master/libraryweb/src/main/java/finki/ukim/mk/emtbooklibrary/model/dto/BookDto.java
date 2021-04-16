package finki.ukim.mk.emtbooklibrary.model.dto;

import finki.ukim.mk.emtbooklibrary.model.Author;
import finki.ukim.mk.emtbooklibrary.model.enumeration.Category;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Data
public class BookDto {
    private String name;
    private Category category;
    private Long author;
    private Integer availablecopies;

    public BookDto() {
    }

    public BookDto(String name, Category category, Long author, Integer availablecopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availablecopies = availablecopies;
    }
}
