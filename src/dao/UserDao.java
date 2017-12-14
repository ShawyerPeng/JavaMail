package dao;

import domain.User;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class UserDao {
    public void add(User user) {
       Connection conn = JdbcUtil.getInstance().getConnection();
        PreparedStatement ps=null;
        String sql = "insert into user values(default,?,?,1,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRandomcode());
            ps.setObject(4, user.getAddtime());
            ps.setString(5, user.getEmail());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.releaseResources(conn, ps, null);
        }
    }

    public void update(String name) {
        Connection conn = JdbcUtil.getInstance().getConnection();
        PreparedStatement ps = null;
        String sql = "update user set flag=0 where name=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.releaseResources(conn, ps, null);
        }
    }
    public void delete(String name) {
        Connection conn = JdbcUtil.getInstance().getConnection();
        PreparedStatement ps = null;
        String sql = "delete from user where name=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.releaseResources(conn, ps, null);
        }
    }

    public boolean login(String username, String password) {
        Connection conn = JdbcUtil.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql="select * from user where name=? and password=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2, password);
            rs = ps.executeQuery();

            if (rs.next()) {
                int flag=rs.getInt(4);
                if (flag == 0) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.releaseResources(conn, ps, rs);
        }
        return false;
    }

    public Date select(String name) {
        Connection conn = JdbcUtil.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql="select addtime from user where name=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            System.out.println("------------");
            while (rs.next()) {
                return rs.getDate(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.releaseResources(conn, ps, rs);
        }
        return null;
    }
}
