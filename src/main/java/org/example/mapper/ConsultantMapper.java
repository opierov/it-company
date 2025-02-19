package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.models.Consultant;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ConsultantMapper {

    @Insert("INSERT INTO consultants (first_name, last_name, salary, industry, managers_id) " +
            "VALUES (#{firstName}, #{lastName}, #{salary}, #{industry}, #{managerId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Consultant consultant);

    @Select("SELECT * FROM consultants WHERE id = #{id}")
    Optional<Consultant> getById(Long id);

    @Select("SELECT * FROM consultants")
    List<Consultant> getAll();

    @Update("UPDATE consultants SET first_name = #{firstName}, last_name = #{lastName}, salary = #{salary}, " +
            "industry = #{industry}, managers_id = #{managerId} WHERE id = #{id}")
    void update(Consultant consultant);

    @Delete("DELETE FROM consultants WHERE id = #{id}")
    void delete(Long id);

    @Select("SELECT * FROM consultants WHERE industry = #{industry}")
    List<Consultant> getByIndustry(String industry);
}