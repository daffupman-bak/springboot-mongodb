package io.daff.springboot_mongodb.po;

import lombok.Data;

/**
 * @author daffupman
 * @since 2020/3/10
 */
@Data
public class Student {

    private String id;
    private String content;
    private String name;
    private String userId;
    private Integer visits;
}
