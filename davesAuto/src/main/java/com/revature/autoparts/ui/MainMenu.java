package com.revature.autoparts.ui;

import com.revature.autoparts.daos.*;
import com.revature.autoparts.models.*;
import com.revature.autoparts.services.*;

import java.util.Scanner;

public class MainMenu implements IMenu{
    private final User user;
    private final StoreLoc storeLoc;
    private final StoreLocService storeLocService;


    public MainMenu(User user, StoreLoc storeLoc, StoreLocService storeLocService) {
        this.user = user;
        this.storeLoc = storeLoc;
        this.storeLocService = storeLocService;

    }

    @Override
    public void start() {
        char input = ' ';
        char input1 = ' ';
        int input2 = 0;
        boolean exit = false;
        Scanner scan = new Scanner(System.in);
        System.out.println("\n\n|-------------------------------|");
        System.out.println("|-Welcome to Dave's Auto Supply-|");
        System.out.println("|-------------------------------|\n");

        while (!exit) {

            System.out.println("[1] login/create account");
            System.out.println("[2] browse store");
            System.out.println("[3] exit");

            System.out.println("\nEnter: ");
            input = scan.next().charAt(0);

            switch(input) {
                case '1':
                    new LoginMenu(new UserService(new UserDAO()),new ShoppingCartService(new ShoppingCartDAO(), new ItemDAO()),new StoreLocService(new StoreLocDAO(), new UserDAO()),new OrderHistoryService(new OrderHistoryDAO()), user).start();
                    break;
                case '2':
                    new StoreMenu(new DeptService(new DeptDAO(), new ItemDAO()), new ItemService(new ItemDAO(), new DeptDAO()), new ShoppingCartService(new ShoppingCartDAO(), new ItemDAO()), new ShoppingCart(), new OrderHistory(), new OrderHistoryService(new OrderHistoryDAO()), user, new StoreLocService(new StoreLocDAO(), new UserDAO())).start();
                    break;
                case '3':
                    exit = true;
                    break;
                default:
                    System.out.println("\nInvalid Input!");
                    break;
            }
        }
    }



}
