package ru.anfdenis.spring.data.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.anfdenis.spring.data.model.Circle;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

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

    public String getCircleName(int id) {
        String sql = "SELECT name FROM circle WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, String.class);
    }

    public Circle getCircleForId(int id) {
        String sql = "SELECT * FROM circle WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new CircleMapper());
    }

    public List<Circle> getAllCircles() {
        String sql = "SELECT * FROM circle";
        return jdbcTemplate.query(sql, new CircleMapper());
    }

    public void insertCircle(Circle circle) {
        String sql = "INSERT INTO circle (id, name) VALUES (?, ?)";
        jdbcTemplate.update(sql, new Object[] {circle.getId(), circle.getName()});
    }

    public void createTriangleTable() {
        String sql = "CREATE TABLE triangle (id INTEGER, name VARCHAR(50))";
        jdbcTemplate.execute(sql);
    }

    private static final class CircleMapper implements RowMapper<Circle> {
        @Override
        public Circle mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Circle(rs.getInt("id"), rs.getString("name"));
        }
    }
}
