package org.ansel.didi.cloud.springjdbcdemo.constants;

public interface BookSqlConstants {
    String SQL_INSERT_BOOK =
            "INSERT INTO book(book_name, author, create_by, create_time, modify_by, modify_time) VALUES (?,?,?,?,?,?);";
    String SQL_UPDATE_BOOK =
            "UPDATE Book SET book_name = ?,author = ?,modify_by = ?,modify_time=? WHERE book_id = ?;";
}
