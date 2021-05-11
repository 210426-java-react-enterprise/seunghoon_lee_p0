package com.revature.seunghoon_lee_p0.daos;

import com.revature.seunghoon_lee_p0.models.Account;
import com.revature.seunghoon_lee_p0.util.ConnectionFactory;

import java.io.StringBufferInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO {

    public void create(Account newAccount) {

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "Insert into lee_bank.accounts (user_id, date_open, balance) values(?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"account_id"});
            pstmt.setInt(1, newAccount.getCustomerId());
            pstmt.setDouble(2, newAccount.getBalance());
            int rowsInserted = pstmt.executeUpdate();

            if(rowsInserted != 0) {
                ResultSet rs = pstmt.getGeneratedKeys();
                while(rs.next()) {
                    newAccount.setAccountId(rs.getInt("account_id"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Account getAccount(int accountId) {

        Account account = null;

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "select balance from lee_bank.accounts where account_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, accountId);
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

    public void updateBalance(int accountId, double newBalance) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "update table lee_bank.accounts set balance = ? where account_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, newBalance);
            pstmt.setInt(2, accountId);
            pstmt.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
