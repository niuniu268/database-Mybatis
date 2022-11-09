package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mapper.InformationMapper;
import org.example.pojo.Information;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);


        loop:
        while (true) {
            System.out.println("Which account do you want to use?");
            System.out.println("1. org.example.Main.Search all");
            System.out.println("2. org.example.Main.Search with Condition");
            System.out.println("3. Quit");
            switch (sc.nextLine()) {
                case "1" -> {

                    Search.searchForAll();

                }
                case "2" -> {

                    Search.searchForCondition();


                }
                case "3" -> {

                    break loop;
                }
            }


        }

    }

    public static class Search {
        public static void searchForAll () throws IOException {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            InformationMapper mapper = sqlSession.getMapper(InformationMapper.class);

            List<Information> information = mapper.searchAll();

            System.out.println(information);

        }

        public static void searchForCondition() throws IOException {
            Scanner sc = new Scanner(System.in);
            String search =sc.nextLine();

            System.out.println("please input what you want to search");

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
}