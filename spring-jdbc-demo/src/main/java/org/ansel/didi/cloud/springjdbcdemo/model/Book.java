package org.ansel.didi.cloud.springjdbcdemo.model;

import java.util.Date;
import lombok.Data;

@Data
public class Book {

    private Long bookId;

    private String bookName;

    private String author;

    private String createBy;

    private Date createTime;

    private String modifyBy;

    private Date modifyTime;

}
