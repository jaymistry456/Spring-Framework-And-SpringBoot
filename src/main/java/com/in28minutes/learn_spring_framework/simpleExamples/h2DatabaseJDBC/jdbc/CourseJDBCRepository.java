package com.in28minutes.learn_spring_framework.simpleExamples.h2DatabaseJDBC.jdbc;

import com.in28minutes.learn_spring_framework.simpleExamples.h2DatabaseJDBC.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJDBCRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CourseJDBCRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static String INSERT_QUERY = "INSERT INTO Course(id, name, author) VALUES(?, ?, ?)";
    private static String DELETE_QUERY = "DELETE FROM Course WHERE id=?";
    private static String SELECT_QUERY = "SELECT * FROM Course WHERE id=?";

    public void insert(Course course) {
        jdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(long id) {
        jdbcTemplate.update(DELETE_QUERY, id);
    }

    public Course findById(long id) {
        return jdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
    }
}
