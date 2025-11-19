package com.ahmed.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ahmed.model.Order;

@Repository
public class OrderRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // INSERT
    public void save(Order o) {
        jdbcTemplate.update(
                "INSERT INTO ORDERS (ORDERID, NAME, PRICE, STATUS) VALUES (?, ?, ?, ?)",
                o.getOrderId(),
                o.getName(),
                o.getPrice(),
                o.getStatus()
        );
    }

    // UPDATE
    public void update(int orderId, String status) {
        jdbcTemplate.update(
                "UPDATE ORDERS SET STATUS = ? WHERE ORDERID = ?",
                status,
                orderId
        );
    }

    // DELETE
    public void delete(int orderId) {
        jdbcTemplate.update(
                "DELETE FROM ORDERS WHERE ORDERID = ?",
                orderId
        );
    }

    // FIND BY ID
    public void findById(int orderId) {
        Map<String, Object> map = jdbcTemplate.queryForMap(
                "SELECT ORDERID, NAME, PRICE, STATUS FROM ORDERS WHERE ORDERID = ?",
                orderId
        );

        map.forEach((k, v) -> System.out.println(k + " = " + v));
    }

    // FIND ALL
    public void findAll() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList(
                "SELECT ORDERID, NAME, PRICE, STATUS FROM ORDERS"
        );

        list.forEach(row -> {
            row.forEach((k, v) -> System.out.println(k + " = " + v));
            System.out.println("------------------------------------------------");
        });
    }
}
