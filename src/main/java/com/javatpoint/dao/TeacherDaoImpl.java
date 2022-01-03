package com.javatpoint.dao;

import com.javatpoint.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class TeacherDaoImpl implements TeacherDao{

    private JdbcTemplate template;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final String SQL_INSERT_TEACHER = "" +
            "INSERT INTO teachers(fio_teach, id_teach) VALUES (:fio_teach, :id_teach)";

    @Autowired
    public TeacherDaoImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public Optional<Teacher> find(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Teacher model) {
        Map<String, Object> params = new HashMap<>();
        params.put("fio_teach", model.getFio_teach());
        params.put("id_teach", model.getId_teach());
        namedParameterJdbcTemplate.update(SQL_INSERT_TEACHER, params);
    }

    @Override
    public void update(Teacher model) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Teacher> findAll() {
        return null;
    }
}
