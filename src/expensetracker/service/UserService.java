package expensetracker.service;

import java.sql.*;

import expensetracker.util.DBConnection;

public class UserService {

    public void addUser(String name) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO users(name) VALUES(?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.executeUpdate();
            System.out.println("User added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewUsers() {
        try (Connection con = DBConnection.getConnection()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                System.out.println(rs.getInt("user_id") + " - " + rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

