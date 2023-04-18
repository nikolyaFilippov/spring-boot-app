package by.mysite.model.entities;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class BookInLibrary {
    private String title;
    private int pages;
    @NonNull
    private int library_id;
}
