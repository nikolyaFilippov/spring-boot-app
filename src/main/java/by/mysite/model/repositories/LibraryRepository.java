package by.mysite.model.repositories;

import by.mysite.model.entities.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library, Integer> {

}
