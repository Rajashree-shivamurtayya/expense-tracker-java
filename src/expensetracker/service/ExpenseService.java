package expensetracker.service;

import java.sql.*;
import java.time.LocalDate;

import expensetracker.util.DBConnection;

public class ExpenseService {

    public void addExpense(int userId, double amount, String category, String desc) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO expenses(user_id, amount, category, expense_date, description) VALUES(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setDouble(2, amount);
            ps.setString(3, category);
            ps.setDate(4, Date.valueOf(LocalDate.now()));
            ps.setString(5, desc);
            ps.executeUpdate();
            System.out.println("Expense added!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewExpenses(int userId) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM expenses WHERE user_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                    rs.getInt("expense_id") + " | " +
                    rs.getDouble("amount") + " | " +
                    rs.getString("category") + " | " +
                    rs.getDate("expense_date") + " | " +
                    rs.getString("description")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public double getMonthlyTotal(int userId) {
        double total = 0;
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT SUM(amount) FROM expenses WHERE user_id=? AND MONTH(expense_date)=MONTH(CURDATE())";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getDouble(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }
}
