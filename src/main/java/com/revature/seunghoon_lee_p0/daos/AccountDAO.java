package com.revature.seunghoon_lee_p0.daos;

import com.revature.seunghoon_lee_p0.models.Account;
import com.revature.seunghoon_lee_p0.models.Transaction;
import com.revature.seunghoon_lee_p0.util.ConnectionFactory;
import com.revature.seunghoon_lee_p0.util.LinkedList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Data Access Object for account and transaction table in aws postgresql database
 */
public class AccountDAO {

    /**
     * Inserts account data int accounts table based on customer_id
     *
     * @param customerId
     * @return a boolean which tells if insertion succeeded or not
     */
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

    /**
     * Gets the Account from accounts table base on account_id
     *
     * @param accountId
     * @return Account
     */
    public Account getAccount(int accountId) {

        Account account = null;
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "select * from lee_bank.accounts where account_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, accountId);
            ResultSet rs = pstmt.executeQuery();

            if(rs.next()) {
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

    /**
     * gets the list of Accounts from accounts table based on customer_id
     *
     * @param customerId
     * @return LinkedList<Account>
     */
    public LinkedList<Account> getAccounts(int customerId) {

        LinkedList<Account> accounts = new LinkedList<>();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "select * from lee_bank.accounts where customer_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, customerId);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                Account a = new Account(
                        rs.getInt("account_id"),
                        rs.getInt("customer_id"),
                        rs.getDouble("balance")
                );
                accounts.add(a);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accounts;

    }

    /**
     * Updates balance in account table base on transaction
     *
     * @param accountId
     * @param balance
     * @return Boolean
     */
    public boolean updateAccountBalance(int accountId, double balance) {

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "update lee_bank.accounts set balance = ? where account_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, balance);
            pstmt.setInt(2, accountId);
            int rowsInserted = pstmt.executeUpdate();

            if(rowsInserted != 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    /**
     * Inserts transaction into transactions table based on customer input data
     *
     * @param accountId
     * @param customerId
     * @param type
     * @param amount
     * @param balance
     * @return Boolean which tells if insertion succeeded or not
     */
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

    /**
     * Gets transaction history from transaction table based on account_id
     *
     * @param account_id
     * @return LinkedList<Transaction>
     */
    public LinkedList<Transaction> getTransactions(int account_id) {

        LinkedList<Transaction> transactions = new LinkedList<>();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "select * from lee_bank.transactions where account_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, account_id);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                Transaction t = new Transaction(
                        rs.getInt("transaction_id"),
                        rs.getString("date"),
                        rs.getInt("account_id"),
                        rs.getInt("customer_id"),
                        rs.getString("type"),
                        rs.getDouble("amount"),
                        rs.getDouble("balance")
                );
                transactions.add(t);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return transactions;

    }

}
