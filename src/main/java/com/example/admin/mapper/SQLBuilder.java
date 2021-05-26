package com.example.admin.mapper;

import org.apache.ibatis.jdbc.SQL;

public class SQLBuilder {

    private String sqlBuilderTest(){
     return new SQL(){{
         SELECT("*");
         FROM("TEST_TWOID_EVENT");
         WHERE();
         OR();
     }}.toString();
    }

}
