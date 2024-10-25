package com.bookstore.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.bookstore.library.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitle(@Param("title") String title);
    List<Book> findByAuthor(@Param("author") String author);
    List<Book> findByYearPublished(@Param("yearPublished") Integer yearPublished);
    List<Book> findByGenre(@Param("genre") String genre);
    List<Book> findByAvailable(@Param("available") Boolean available);

}