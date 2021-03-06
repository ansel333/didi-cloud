package org.ansel.didi.cloud.springjdbcdemo.service;

import lombok.extern.log4j.Log4j;
import org.ansel.didi.cloud.springjdbcdemo.config.DruidDbConfig;
import org.ansel.didi.cloud.springjdbcdemo.constants.BookSqlConstants;
import org.ansel.didi.cloud.springjdbcdemo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
@Log4j
public class BookServiceImpl implements BookService {

    private DataSource mysqlDataSource;

    @Autowired
    public BookServiceImpl(DruidDbConfig dbConfig) {
        this.mysqlDataSource = dbConfig.dataSource();
    }

    @Override
    public boolean addBook(Book book) {
        try {
            Connection connection = mysqlDataSource.getConnection();
            PreparedStatement preparedStatement;
            LocalDateTime currentTime = LocalDateTime.now();
            preparedStatement = connection.prepareStatement(BookSqlConstants.SQL_INSERT_BOOK);
            preparedStatement.setString(1, book.getBookName());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setString(3, book.getCreateBy());
            preparedStatement.setTimestamp(4, new Timestamp(currentTime.toInstant(ZoneOffset.UTC).toEpochMilli()));
            preparedStatement.setString(5, book.getModifyBy());
            preparedStatement.setTimestamp(6, new Timestamp(currentTime.toInstant(ZoneOffset.UTC).toEpochMilli()));

            return preparedStatement.execute();
        } catch (Throwable e) {
            // TODO: config log4j properly
            log.error("Error occurs: {0}", e);
            return false;
        }
    }
}
