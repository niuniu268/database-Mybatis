package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mapper.InformationMapper;
import org.example.pojo.Information;

import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);


        loop:
        while (true) {
            System.out.println("Which account do you want to use?");
            System.out.println("1. Search all");
            System.out.println("2. Search with Condition");
            System.out.println("3. Add");
            System.out.println("4. Delete");
            System.out.println("5. Quit");

            switch (sc.nextLine()) {
                case "1" -> {

                    Search.searchForAll();

                }
                case "2" -> {

                    Search.searchForCondition();


                }
                case "3" -> {

                    Search.add();
                }

                case "4" -> {

                }
                case "5" -> {
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

        public static void add() throws IOException {
            Scanner sc = new Scanner(System.in);
            Information ifo = new Information();
            System.out.println("please input what you want to input");

            System.out.println("first name");
            ifo.setFirstName(sc.nextLine());

            System.out.println("last name");
            ifo.setLastName(sc.nextLine());
            System.out.println("age");
            ifo.setAge(Integer.parseInt(sc.nextLine()));
            System.out.println("address");

            ifo.setAddress(sc.nextLine());

            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            InformationMapper mapper = sqlSession.getMapper(InformationMapper.class);

            mapper.addInformation(ifo);

        }

        public void delete() throws IOException {

            Scanner sc = new Scanner(System.in);

            Information ifo = new Information();

            System.out.println("please input what you want to search and delete");

            ifo.setAddress(sc.nextLine());
            ifo.setFirstName(sc.nextLine());
            ifo.setLastName(sc.nextLine());

            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            InformationMapper mapper = sqlSession.getMapper(InformationMapper.class);

            mapper.deleteInfo(ifo);



        }
    }
}