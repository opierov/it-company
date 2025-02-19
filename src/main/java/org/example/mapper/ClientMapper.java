package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.models.Client;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ClientMapper {

    @Insert("INSERT INTO clients (name, contact_info) VALUES (#{name}, #{contactInfo})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Client client);

    @Select("SELECT * FROM clients WHERE id = #{id}")
    Optional<Client> getById(Long id);

    @Select("SELECT * FROM clients")
    List<Client> getAll();

    @Update("UPDATE clients SET name = #{name}, contact_info = #{contactInfo} WHERE id = #{id}")
    void update(Client client);

    @Delete("DELETE FROM clients WHERE id = #{id}")
    void delete(Long id);

    @Select("SELECT * FROM clients WHERE name = #{name}")
    List<Client> getByName(String name);
}