package org.example.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mapper.InformationMapper;
import org.example.pojo.Information;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class SearchWithCondition {

    @Test
    public void search() throws IOException {

        Scanner sc = new Scanner(System.in);
        String search =sc.nextLine();

        String firstName = search;
        String lastName = search;

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        InformationMapper mapper = sqlSession.getMapper(InformationMapper.class);

        List<Information> information = mapper.searchwithCondition(firstName,lastName);

        System.out.println(information);





    }
}
