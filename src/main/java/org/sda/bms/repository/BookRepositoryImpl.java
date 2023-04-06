package org.sda.bms.repository;

import org.sda.bms.model.Book;

public class BookRepositoryImpl extends BaseRepositoryImpl<Book> implements BaseRepository<Book>{
    public BookRepositoryImpl() {
        super(Book.class);
    }
}
