package com.revature.autoparts.services;

import com.revature.autoparts.daos.OrderHistoryDAO;
import com.revature.autoparts.daos.ShoppingCartDAO;

public class OrderHistoryService {
    private final OrderHistoryDAO orderHistoryDAO;

    public OrderHistoryService(OrderHistoryDAO orderHistoryDAO) {
        this.orderHistoryDAO = orderHistoryDAO;
    }

    public OrderHistoryDAO getOrderHistoryDAO() {
        return orderHistoryDAO;
    }
}
