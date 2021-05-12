package com.revature.seunghoon_lee_p0.daos;

import com.revature.seunghoon_lee_p0.models.Account;
import com.revature.seunghoon_lee_p0.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO {

    public boolean insertAccount(int customerId)  {

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "insert into lee_bank.accounts (customer_id, balance) values(?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, customerId);
            pstmt.setDouble(2, 0.0);
            int rowsInserted = pstmt.executeUpdate();

            if(rowsInserted != 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    public Account getAccount(int customerId) {

        Account account = null;

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "select * from lee_bank.accounts where customer_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, customerId);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                account = new Account(
                        rs.getInt("account_id"),
                        rs.getInt("customer_id"),
                        rs.getDouble("balance")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return account;

    }

    public boolean insertTransaction(int accountId, int customerId, String type, double amount, double balance) {

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "insert into lee_bank.transactions " +
                         "(account_id, customer_id, type, amount, balance) " +
                         "values(?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, accountId);
            pstmt.setInt(2, customerId);
            pstmt.setString(3, type);
            pstmt.setDouble(4, amount);
            pstmt.setDouble(5, balance);
            int rowsInserted = pstmt.executeUpdate();

            if(rowsInserted != 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

}
