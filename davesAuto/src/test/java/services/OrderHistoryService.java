package services;

import daos.OrderHistoryDAO;

public class OrderHistoryService {
    private final OrderHistoryDAO orderHistoryDAO;

    public OrderHistoryService(OrderHistoryDAO orderHistoryDAO) {
        this.orderHistoryDAO = orderHistoryDAO;
    }

    public OrderHistoryDAO getOrderHistoryDAO() {
        return orderHistoryDAO;
    }
}
