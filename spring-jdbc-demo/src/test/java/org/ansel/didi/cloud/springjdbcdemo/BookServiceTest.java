package org.ansel.didi.cloud.springjdbcdemo;

import org.ansel.didi.cloud.springjdbcdemo.model.Book;
import org.ansel.didi.cloud.springjdbcdemo.service.BookServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookServiceTest {
    @Autowired
    private BookServiceImpl bookRepository;

    @Test
    public void testAddBook() {
        Book book = new Book("Spring实战（第4版）", "Craig Walls", "申城异乡人");

        bookRepository.addBook(book);

        book = new Book("Java EE开发的颠覆者：Spring Boot实战", "汪云飞", "申城异乡人");

        bookRepository.addBook(book);

        book = new Book("RabbitMQ实战指南", "朱忠华", "申城异乡人");

        bookRepository.addBook(book);
    }
}
