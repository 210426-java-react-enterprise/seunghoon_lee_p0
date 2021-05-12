package com.revature.seunghoon_lee_p0.daos;

import com.revature.seunghoon_lee_p0.models.Customer;
import com.revature.seunghoon_lee_p0.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {

    public Customer save(Customer newCustomer) {

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "Insert into lee_bank.customers (username, password, first_name, last_name, email) values(?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[] { "customer_id"});
            pstmt.setString(1, newCustomer.getUsername());
            pstmt.setString(2, newCustomer.getPassword());
            pstmt.setString(3, newCustomer.getFirstName());
            pstmt.setString(4, newCustomer.getLastName());
            pstmt.setString(5, newCustomer.getEmail());
            int rowsInserted = pstmt.executeUpdate();

            if(rowsInserted != 0) {
                ResultSet rs = pstmt.getGeneratedKeys();
                while(rs.next()) {
                    newCustomer.setCustomerId(rs.getInt("customer_id"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return newCustomer;
    }

    public boolean isUsernameAvailable(String username) {

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "select * from lee_bank.customers where username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            if(rs.next()) {
                return false;
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    public boolean isEmailAvailable(String email) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "select * from lee_bank.customers where email = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            if(rs.next()) {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;

    }

    public Customer findCustomerByUsernameAndPassword(String username, String password) {

        Customer customer = null;

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "select * from lee_bank.customers where username = ? and password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                customer = new Customer(
                        rs.getInt("customer_id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customer;
    }
}
