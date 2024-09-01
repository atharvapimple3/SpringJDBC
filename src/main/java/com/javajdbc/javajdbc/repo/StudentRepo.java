package com.javajdbc.javajdbc.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.javajdbc.javajdbc.model.Student;

@Repository
public class StudentRepo {

    private JdbcTemplate jdbc;

    public JdbcTemplate getJDBC()
    {
        return jdbc;
    }

    @Autowired
    public void setJDBC(JdbcTemplate jdbc)
    {
        this.jdbc = jdbc;
    }

    public void save(Student s)
    {
        try{
            String query = "insert into Stud_info(id,name,marks) values(?, ?, ?)";
            int rows = jdbc.update(query,s.getRoll(), s.getName(),s.getMarks());

            System.out.println(rows + " rows affected");
        }
        catch(Exception e)
        {
            System.out.println("Error occured during executing SQL query" + e);
        }

    }
    public List <Student> findAll()
    {
        String query = "Select *  from Stud_info";
        RowMapper <Student> map = new RowMapper<Student>() {

            @Override
            public Student mapRow(ResultSet rs, int arg1) throws SQLException {
                
                Student st = new Student();
                st.setRoll(rs.getInt(1));
                st.setName(rs.getString(2));
                st.setMarks(rs.getInt(3));

                return st;
            }
            
        };


        return jdbc.query(query, map);

        // List <Student> students = new ArrayList<>();
        // return students;
    }
}
