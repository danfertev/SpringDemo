package ru.anfdenis.spring.data.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.anfdenis.spring.data.model.Circle;

import javax.sql.DataSource;
import java.sql.*;

/**
 * Denis Anfertev
 * 26.12.12 20:56
 */
@Component
public class JdbcDaoImpl {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Circle getCircle(int id) {
        Connection conn = null;
        Circle circle = null;
        try {
            //Obtaining a connection to the db
            conn = this.dataSource.getConnection();
            //Preparing SQL query
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM circle WHERE id = ?");
            ps.setInt(1, id);
            //Executing the query
            circle = null;
            ResultSet rs = ps.executeQuery();
            //Obtaining values from the result set
            if (rs.next()) {
                circle = new Circle(id, rs.getString("name"));
            }
            //Closing resources
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
            }
        }
        return circle;
    }

    public int getCircleNumber() {
        String sql = "SELECT COUNT(*) FROM circle";
        return jdbcTemplate.queryForInt(sql);
    }
}
