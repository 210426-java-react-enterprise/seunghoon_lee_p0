package com.revature.seunghoon_lee_p0.daos;

import com.revature.seunghoon_lee_p0.models.Customer;
import com.revature.seunghoon_lee_p0.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class leeBankDAO {

    public Customer save(Customer newCustomer) {

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sqlInsertCustomer =
                "Insert into lee_bank.customers (username, password, first_name, last_name, email) values(?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sqlInsertCustomer, new String[] { "customer_id"});
            pstmt.setString(1, newCustomer.getUsername());
            pstmt.setString(2, newCustomer.getPassword());
            pstmt.setString(4, newCustomer.getFirstName());
            pstmt.setString(5, newCustomer.getLastName());
            pstmt.setString(3, newCustomer.getEmail());
            int rowsInserted = pstmt.executeUpdate();

            if(rowsInserted != 0) {
                ResultSet rs = pstmt.getGeneratedKeys();
                while(rs.next()) {
                    newCustomer.setId(rs.getInt("Customer_id"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return newCustomer;
    }
}
