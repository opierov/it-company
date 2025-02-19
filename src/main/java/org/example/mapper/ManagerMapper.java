package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.models.Manager;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ManagerMapper {

    @Insert("INSERT INTO managers (name, id, salary, industry) " +
            "VALUES (#{name}, #{id}, #{salary}, #{industry})")
    void insert(Manager manager);

    @Select("SELECT * FROM managers WHERE id = #{id}")
    Optional<Manager> getById(Long id);

    @Select("SELECT * FROM managers")
    List<Manager> getAll();

    @Update("UPDATE managers SET name = #{name}, salary = #{salary}, industry = #{industry} WHERE id = #{id}")
    void update(Manager manager);

    @Delete("DELETE FROM managers WHERE id = #{id}")
    void delete(Long id);

    @Select("SELECT * FROM managers WHERE industry = #{industry}")
    List<Manager> getByIndustry(String industry);
}
