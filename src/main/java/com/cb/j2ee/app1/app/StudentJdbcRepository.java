package com.cb.j2ee.app1.app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class StudentJdbcRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    static class StudentRowMapper implements RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student student = new Student();
            student.setId(rs.getLong("id"));
            student.setName(rs.getString("name"));
            student.setMyKAD(rs.getString("mykad"));
            return student;
        }
    }

    public List<Student> findAll() {
        return jdbcTemplate.query("select * from student", new StudentRowMapper());
    }

    public Student findById(long id) {
        return jdbcTemplate.queryForObject("select * from student where id=?",
                new BeanPropertyRowMapper<>(Student.class), id);
    }

    public void deleteById(long id) {
        jdbcTemplate.update("delete from student where id=?", id);
    }

    public int insert(Student student) {
        return jdbcTemplate.update("insert into student (id, name, mykad) " + "values(?,  ?, ?)",
                student.getId(), student.getName(), student.getMyKAD());
    }

    public int update(Student student) {
        return jdbcTemplate.update("update student " + " set name = ?, mykad = ? " + " where id = ?",
                student.getName(), student.getMyKAD(), student.getId());
    }

}
