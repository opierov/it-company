package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.models.Project;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ProjectMapper {

    @Insert("INSERT INTO projects (name, deadline, budget, technology) " +
            "VALUES (#{name}, #{deadline}, #{budget}, #{technology})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Project project);

    @Select("SELECT * FROM projects WHERE id = #{id}")
    Optional<Project> getById(Long id);

    @Select("SELECT * FROM projects")
    List<Project> getAll();

    @Update("UPDATE projects SET name = #{name}, deadline = #{deadline}, " +
            "budget = #{budget}, technology = #{technology} WHERE id = #{id}")
    void update(Project project);

    @Delete("DELETE FROM projects WHERE id = #{id}")
    void delete(Long id);

    @Select("SELECT * FROM projects WHERE technology = #{technology}")
    List<Project> getByTechnology(String technology);
}