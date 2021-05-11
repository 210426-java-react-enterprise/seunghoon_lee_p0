package com.revature.seunghoon_lee_p0.daos;

import com.revature.seunghoon_lee_p0.models.Account;
import com.revature.seunghoon_lee_p0.models.Customer;
import com.revature.seunghoon_lee_p0.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO {

    private Customer currentCustomer;

    public AccountDAO(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
    }

    public boolean createAccount() {

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "insert into lee_bank.accounts (customer_id, balance) values(?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"account_id"});
            pstmt.setInt(1, currentCustomer.getCustomerId());
            pstmt.setDouble(2, 0.0);
            int rowsInserted = pstmt.executeUpdate();

            if(rowsInserted != 0) {
                return true;
            }

        } catch (SQLException e) {
            //e.printStackTrace();
        }
        return false;

    }

    public Account getAccount() {

        Account account = null;

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "select balance from lee_bank.accounts where customer_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, currentCustomer.getCustomerId());
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
