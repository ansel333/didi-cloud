package org.ansel.didi.cloud.springjdbcdemo.service;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.log4j.Log4j2;
import org.ansel.didi.cloud.springjdbcdemo.config.MySqlDataSource;
import org.ansel.didi.cloud.springjdbcdemo.constants.BookSqlConstants;
import org.ansel.didi.cloud.springjdbcdemo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
@Log4j2
public class BookServiceImpl implements BookService {

    private MySqlDataSource mysqlDataSource;

    @Autowired
    public BookServiceImpl(MySqlDataSource dataSource) {
        this.mysqlDataSource = dataSource;
    }

    @Override
    public boolean addBook(Book book) {
        DruidDataSource dataSource = mysqlDataSource.dataSource();

        try {
            Connection connection = dataSource.getConnection();
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
            log.error("Error occurs: {0}", e);
            return false;
        }
    }
}
