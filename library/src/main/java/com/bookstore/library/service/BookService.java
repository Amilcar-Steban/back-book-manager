package com.bookstore.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.library.model.Book;
import com.bookstore.library.repository.BookRepository;

@Service
public class BookService {

    private final BookRepository bookRepository;

    // Inyección de dependencias mediante el constructor
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Método para obtener todos los libros
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Método para obtener un libro por su id
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
    }

    // Método para guardar un nuevo libro
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    // Método para actualizar un libro existente
    public Book updateBook(Long id, Book bookDetails) {
        Book book = getBookById(id); // Llamada a getBookById para validar que el libro existe
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setYearPublished(bookDetails.getYearPublished());
        book.setGenre(bookDetails.getGenre());
        book.setAvailable(bookDetails.getAvailable());
        return bookRepository.save(book);
    }

    // Método para eliminar un libro por ID
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    // Métodos personalizados para consultas específicas
    public List<Book> getBooksByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public List<Book> getBooksByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    public List<Book> getBooksByYearPublished(Integer yearPublished) {
        return bookRepository.findByYearPublished(yearPublished);
    }

    public List<Book> getBooksByGenre(String genre) {
        return bookRepository.findByGenre(genre);
    }

    public List<Book> getBooksByAvailability(Boolean available) {
        return bookRepository.findByAvailable(available);
    }

}
