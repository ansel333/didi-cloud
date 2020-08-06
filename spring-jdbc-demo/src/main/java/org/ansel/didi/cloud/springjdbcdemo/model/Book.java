package org.ansel.didi.cloud.springjdbcdemo.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private Long bookId;

    private String bookName;

    private String author;

    private String createBy;

    private Date createTime;

    private String modifyBy;

    private Date modifyTime;

    public Book(String bookName, String author, String createBy) {
        this.bookName = bookName;
        this.author = author;
        this.createBy = createBy;
        this.createTime = new Date();
        this.modifyBy=createBy;
        this.modifyTime=new Date();
    }

    public Book(Long bookId, String bookName, String author, String modifyBy) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.modifyBy = modifyBy;
    }

}
