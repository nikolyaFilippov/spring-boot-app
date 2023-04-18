package by.mysite.model.repositories;

import by.mysite.model.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BookRepository extends JpaRepository<Book, Integer> {

}
