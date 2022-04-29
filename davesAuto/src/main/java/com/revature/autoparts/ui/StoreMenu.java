package com.revature.autoparts.ui;

import com.revature.autoparts.daos.OrderHistoryDAO;
import com.revature.autoparts.daos.ShoppingCartDAO;
import com.revature.autoparts.models.*;
import com.revature.autoparts.services.*;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StoreMenu implements IMenu {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private final DeptService deptService;
    private final ItemService itemService;
    private final ShoppingCartService shoppingCartService;
    private final ShoppingCart shoppingCart;
    private final OrderHistory orderHistory;
    private final OrderHistoryService orderHistoryService;
    private final User user;
    private final StoreLocService storeLocService;




    Scanner scan = new Scanner(System.in);
    public StoreMenu(DeptService deptService, ItemService itemService, ShoppingCartService shoppingCartService, ShoppingCart shoppingCart, OrderHistory orderHistory, OrderHistoryService orderHistoryService, User user, StoreLocService storeLocService) {
        this.deptService = deptService;
        this.itemService = itemService;
        this.shoppingCartService = shoppingCartService;
        this.shoppingCart = shoppingCart;
        this.orderHistory = orderHistory;
        this.orderHistoryService = orderHistoryService;
        this.user = user;
        this.storeLocService = storeLocService;
    }

    //start program
    @Override
    public void start() {
        char input = ' ';
        boolean exit = false;
        Scanner scan = new Scanner(System.in);

        while(!exit) {

            System.out.println("\nWelcome to Store Menu, feel free to browse our goods...");
            System.out.println("---------------------------------------------------------\n");
            System.out.println("[1] View all products");
            System.out.println("[2] Search for a product");
            System.out.println("[3] Open departments");
            System.out.println("[4] View Cart");
            System.out.println("[5] My Order History");
            System.out.println("[6] Exit");

            System.out.println("\nEnter: ");
            input = scan.next().charAt(0);

            switch (input) {
                case '1':
                    viewAllProducts();
                    break;
                case '2':
                    searchProduct();
                    break;
                case '3':
                    viewByDept();
                    break;
                case '4':
                    viewCart();
                    break;
                case '5':
                    myOrderHistory();
                    break;
                case '6':
                    exit = true;
                    break;
                default:
                    System.out.println("\nInvalid Input!");
                    break;

            }
        }
    }

    //View all product in one list
    private void viewAllProducts() {
        int input = 0;
        boolean shopping = false;
        Scanner scan = new Scanner(System.in);
        char choice = ' ';
        List<Item> itemList = itemService.getItemDAO().findAll();

        System.out.println();
        while(!shopping) {
            for(int i = 0; i < itemList.size(); i++) {
                System.out.println("[" + (i + 1) + "] " + itemList.get(i).getItemName());
            }
            System.out.println("\nDid you see anything you'd like to buy?");
            System.out.println("\n[y] | [n]");
            choice = scan.next().charAt(0);
            if(choice == 'y') {
                addToCart2();

            } else {
                System.out.println("Thanks for shopping");
                shopping = true;
            }

        }
    }

    //View only search products
    private void searchProduct() {

        String name = "";
        Scanner scan = new Scanner(System.in);

        while(true) {
            System.out.println("\nSearch Item Name");
            name = scan.nextLine().toLowerCase();
            List<Item> items = itemService.getItemDAO().findByName(name);
            if(items.isEmpty()) {
                System.out.println("\nInvalid Search");
            } else {
                for (Item it: items) {
                    System.out.println(it);
                }
                System.out.println("Would you like to purchase anything? [y] or [n]");
                if(scan.next().charAt(0) == 'y'){
                    addToCart2();
                }
                break;
            }
        }
    }

    //view by department
    private void viewByDept(){
        int deptId = 0;
        char input = ' ';
        boolean cont = false;
        Scanner scan = new Scanner(System.in);

        while(true) {
            System.out.println("\nSearch by Department ID\n[1] Paints\n[2] Nuts & Bolts\n[3] Fasteners\n[4] 3M Products");
            deptId = scan.nextInt();
            List<Item> items = itemService.getItemDAO().viewByDept(deptId);
            if(items.isEmpty()) {
                System.out.println("\nInvalid Search");
            } else {
                for (Item it : items) {
                    System.out.println(it);
                }
                    System.out.println("\nWould you like to purchase anything?\n[y] or [n]");
                    input = scan.next().charAt(0);

                while (true) {
                    switch (input) {
                        case 'y':
                            addToCart1();
                            System.out.println("Would you like to continue purchasing items? [y] or [n]");
                            input = scan.next().charAt(0);
                            if(input == 'y') {
                                cont = true;
                            } else if (input == 'n') {
                                cont = false;
                            }
                            break;
                        case 'n':
                            System.out.println("Thank you feel free to continue browsing...");
                            break;
                        default:
                            System.out.println("Invalid Input!");

                    }
                    if(cont == true) {
                        continue;
                    } else if (cont == false) {
                        break;
                    }
                }
                if(user.getUsername() == null){
                    break;
                }
            }
            if(cont == false){
                break;
            }
        }

    }

    private void addToCart1 () {
            int itemNum = 0;
            int input = 0;
            int deptNum = 0;
            List<Item> items = shoppingCartService.getItemDAO().findAll();
            System.out.println("Please repeat the departmentID");
            while (true) {
                System.out.println("\nSearch by Department ID\n[1] Paints\n[2] Nuts & Bolts\n[3] Fasteners\n[4] 3M Products");
                deptNum = scan.nextInt();
                List<Item> Browseditems = itemService.getItemDAO().viewByDept(deptNum);

                for (int i = 0; i < Browseditems.size(); i++) {
                    System.out.println("[" + (i + 1) + "] " + Browseditems.get(i).getItemName());
                }
                if (items.isEmpty()) {
                    System.out.println("\nInvalid Search");
                }
                System.out.println();

                while (true) {
                    System.out.println("Enter in item num");

                    itemNum = scan.nextInt() - 1;

                    if (itemNum < Browseditems.size()) {
                        shoppingCart.setItem_id(itemNum);
                        break;
                    }
                }
                break;

            }
            int quantInput = 0;
            System.out.println("how many would you like?");
            quantInput = scan.nextInt();
            shoppingCart.setQuantity(quantInput);
            shoppingCart.setCustomer_id(user.getId());


            System.out.println("would you like to confirm addition of item? [y] or [n]");
            if (scan.next().charAt(0) == 'y') {
                Date date = new Date();
                shoppingCartService.getShoppingCartDAO().save(shoppingCart);
            }

        }

    //add to cart for regular
    private void addToCart2 () {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        int input = 0;
        int deptNum = 0;

        List<Item> items = shoppingCartService.getItemDAO().findAll();


        while (true) {
            System.out.println();
            for (int i = 0; i < items.size(); i++) {
                System.out.println("[" + (i + 1) + "]" + items.get(i).getItemName());
            }
            if (items.isEmpty()) {
                System.out.println("\nInvalid Search");
            }
            System.out.println();

            while (true) {
                System.out.println("Enter in item number");
                System.out.println("--------------------\n");

                int itemNum = 0;
                itemNum = scan.nextInt() - 1;

                if (itemNum < items.size()) {
                    shoppingCart.setItem_id(itemNum);
                    break;
                }
            }
            break;
        }
        int quantInput = 0;
        System.out.println("How many would you like?");
        quantInput = scan.nextInt();
        shoppingCart.setQuantity(quantInput);
        shoppingCart.setCustomer_id(user.getId());


        System.out.println("Would you like to confirm addition of item? [y] or [n]");
        if (scan.next().charAt(0) == 'y') {
            shoppingCartService.getShoppingCartDAO().save(shoppingCart);
            System.out.println("saved...");
        }

    }

    //view personal order history
    private void viewCart() {
        char input = ' ';
        List<ShoppingCart> scList = shoppingCartService.getShoppingCartDAO().findByID(user.getId());
        for (ShoppingCart s : scList) {
            System.out.println(s);

        }
        System.out.println("do you want to checkout? [y] or [n]");

        if(scan.next().charAt(0) == 'y') {
            checkOut(scList);
        } else {
            System.out.println("Okay come back soon...");
        }

    }

    private void checkOut(List<ShoppingCart> shoppingCarts) {
        OrderHistory hist = new OrderHistory();
        Date date = new Date();
        for (ShoppingCart c: shoppingCarts) {
            hist.setId(c.getId());
            hist.setCustomer_id(c.getCustomer_id());
            hist.setItem_id(c.getItem_id());
            hist.setDate(formatter.format(date));
            hist.setShop_Loc(user.getStoreLocId());

            orderHistoryService.getOrderHistoryDAO().save(hist);
            itemService.getItemDAO().removeById(c.getItem_id(), c.getQuantity());
        }

        System.out.println("Thanks for shopping at Dave's auto supply");

        for (ShoppingCart c: shoppingCarts) {
            shoppingCartService.getShoppingCartDAO().removeById(c.getCustomer_id());
        }
    }

    private void myOrderHistory() {
        char newInput = ' ';
        Scanner scan = new Scanner(System.in);
        boolean exit = false;


        while (!exit) {
            System.out.println("Please select what you would prefer: ");
            System.out.println("[1] Default");
            System.out.println("[2] Order History in ascending order");
            System.out.println("[3] Order History in descending order");
            System.out.println("[4] EXIT");

            newInput = scan.next().charAt(0);

            switch (newInput) {
                case '1':
                    List<OrderHistory> historyList = orderHistoryService.getOrderHistoryDAO().findByOHID(user.getId());
                    if (historyList.isEmpty()) {
                        System.out.println("Invalid Search!");
                    } else {
                        for (OrderHistory it : historyList) {
                            System.out.println(it);
                        }
                    }
                    break;

                case '2':
                    List<OrderHistory> ascList = orderHistoryService.getOrderHistoryDAO().findByDateAsc(user.getId());

                    if (ascList.isEmpty()) {
                        System.out.println("Invalid Search!");
                    } else {
                        for (OrderHistory it : ascList) {
                            System.out.println(it);
                        }
                    }
                    break;

                case '3':
                    List<OrderHistory>  descList = orderHistoryService.getOrderHistoryDAO().findByDateDesc(user.getId());
                    if (descList.isEmpty()) {
                        System.out.println("Invalid Search!");
                    } else {
                        for (OrderHistory it : descList) {
                            System.out.println(it);
                        }
                    }
                    break;

                case '4':
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid Input!");
                    break;
            }

        }
    }

}