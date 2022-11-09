package org.example.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.pojo.Information;

import java.util.List;

public interface InformationMapper {

    List<Information> selectBlog();
    List<Information> searchAll();

    List<Information> searchwithCondition(@Param("firstName") String firstName, @Param("lastName") String lastName);


}
