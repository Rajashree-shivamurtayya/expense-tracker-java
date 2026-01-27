package expensetracker.service;

import java.sql.*;

import expensetracker.util.DBConnection;

public class BudgetService {

    public void setBudget(int userId, double limit) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "REPLACE INTO budget(user_id, monthly_limit) VALUES(?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setDouble(2, limit);
            ps.executeUpdate();
            System.out.println("Budget set successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public double getBudget(int userId) {
        double budget = 0;
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT monthly_limit FROM budget WHERE user_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                budget = rs.getDouble(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return budget;
    }
}
