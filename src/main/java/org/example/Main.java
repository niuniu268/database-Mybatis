package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.example.mapper.InformationMapper;
import org.example.pojo.Information;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.lang.module.Configuration;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        InformationMapper mapper = sqlSession.getMapper(InformationMapper.class);

        List<Information> information = mapper.selectBlog();

        System.out.println(information);


    }
}