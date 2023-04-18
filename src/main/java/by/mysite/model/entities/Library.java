package by.mysite.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "libraries")
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private int id;
    @NonNull
    private String name;
    @NonNull
    private String address;

    @OneToMany(mappedBy = "library", fetch = FetchType.EAGER)
    private List<Book> books;
}
