package com.revature.autoparts.ui;

import com.revature.autoparts.models.Item;
import com.revature.autoparts.models.OrderHistory;
import com.revature.autoparts.models.StoreLoc;
import com.revature.autoparts.models.User;
import com.revature.autoparts.services.*;

import java.util.List;
import java.util.Scanner;

public class AdminMenu implements IMenu{
    private final UserService userService;
    private final OrderHistoryService orderHistoryService;
    private final ShoppingCartService shoppingCartService;
    private final StoreLocService storeLocService;
    private final ItemService itemService;
    private final User user;

    public AdminMenu(UserService userService, OrderHistoryService orderHistoryService, ShoppingCartService shoppingCartService, StoreLocService storeLocService, ItemService itemService, User user) {
        this.userService = userService;
        this.orderHistoryService = orderHistoryService;
        this.shoppingCartService = shoppingCartService;
        this.storeLocService = storeLocService;
        this.itemService = itemService;
        this.user = user;
    }

    @Override
    public void start() {
        char input = ' ';
        int secretCode = 0;
        boolean loop = false;
        Scanner scan = new Scanner(System.in);
        while (!loop) {
            System.out.println("Welcome to Admin Menu");
            System.out.println("please enter secret code...");

            secretCode = scan.nextInt();
            if (secretCode == 1234) {
                while(!loop) {
                    System.out.println("\nWelcome Boss Man what would you like to do?\n");
                    System.out.println("[1] Search customer by username.");
                    System.out.println("[2] Search customer by first and last name.");
                    System.out.println("[3] View order history of a customer.");
                    System.out.println("[4] View Order History of location");
                    System.out.println("[5] Refill Inventory");
                    System.out.println("[6] exit\n");

                    input = scan.next().charAt(0);

                    switch (input) {
                        case '1':
                            searchCustUser();
                            break;
                        case '2':
                            searchCustFNL();
                            break;
                        case '3':
                            viewOrdHistOfCust(); //View Order history of a customer.
                            break;
                        case '4':
                            orderHistoryLocation();
                            break;
                        case '5':
                            refillInventory();
                        case '6':
                            loop = true;
                            break;
                        default:
                            System.out.println("Invalid Input");
                            break;
                    }
                }
            } else {
                System.out.println("Sorry you are not an admin");
            }
        }
    }

    private void searchCustUser() {
        String name = "";
        char input = ' ';
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println(("\nSearch Customer by Username: "));
            name = scan.nextLine();

            List<User> users = userService.getUserDAO().findByName(name);

            if (users.isEmpty()) {
                System.out.println("\nInvalid Search!");
            } else {
                for (User us : users) {
                    System.out.println(us);
                    System.out.println("Would you like to search again?");
                    input = scan.next().charAt(0);
                    if (input == 'y') {
                        continue;
                    } else {
                        System.out.println("\nThanks for stopping by");
                        break;
                    }
                }
            }
        }
    }

    private void searchCustFNL() {
        char input = ' ';
        String firstName = "";
        String lastName = "";
        Scanner scan = new Scanner(System.in);

        while(true) {
            System.out.println(("\nSearch first name: "));
            firstName = scan.nextLine();
            System.out.println((("\nSearch last name:")));
            lastName = scan.nextLine();

            System.out.println("please wait searching for names...");

            List<User> firstUsers = userService.getUserDAO().findByFirst(firstName);
            List<User> lastUsers = userService.getUserDAO().findByLast(lastName);

            if (firstUsers.isEmpty() && lastUsers.isEmpty()) {
                System.out.println("\nInvalid Search!");
            } else {
                for (User us : firstUsers) {
                    for (User er : lastUsers) {
                        if (er == us) {
                            System.out.println(er);
                        } else {
                            continue;
                        }
                    }
                    System.out.println(us);
                }

            }
            System.out.println("Would you like to search again? [y] or [n]");
            input = scan.next().charAt(0);
            if(input == 'y') {
                continue;
            } else if (input == 'n') {
                break;
            } else {
                System.out.println("Please type either [y] or [n]");
            }
        }

    }

    private void viewOrdHistOfCust(){
        String name = "";
        char input = ' ';
        boolean loop = false;
        Scanner scan = new Scanner(System.in);

        while (!loop) {
            System.out.println("\nSearch customer by username");
            name = scan.nextLine();

            List<User> users = userService.getUserDAO().findByName(name);

            List<OrderHistory> currentOH = orderHistoryService.getOrderHistoryDAO().findByOHID(userService.getUserDAO().getUserId(name));
            for(OrderHistory o : currentOH) {
                System.out.println(o);
            }
            System.out.println("\nWill you continue searching? [y] or [n]");
            input = scan.next().charAt(0);

            if(input == 'y') {
                continue;
            } else {
                loop = true;
            }

        }
    }

    public void orderHistoryLocation() {
        String name = "";
        char response = ' ';
        int input = 0;
        Scanner scan = new Scanner(System.in);

        while(true) {
            List<StoreLoc> locList = storeLocService.storeLocDAO().findAll();
            for(int i = 0; i < locList.size(); i++) {
                System.out.println("[" + (i + 1) + "]" + " " + locList.get(i).toString());
            }
            System.out.println("Enter the Shop Location: ");
            input = scan.nextInt();

            List<OrderHistory> orderList = orderHistoryService.getOrderHistoryDAO().findByStoreLoc(input);

            for(OrderHistory o: orderList) {
                System.out.println(o);
            }
            System.out.println("Would you like to continue reading? [y] or [n]");
            response = scan.next().charAt(0);
            if(response == 'y') {
                continue;
            }
            else{
                break;
            }
        }
    }

    private void refillInventory() {
        boolean loop = false;
        char choice = ' ';
        char choice1 = ' ';
        String name = "";
        int refill = 0;
        int refill2 = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Howdy, trying to refill your inventory? (Sounding like a cowboy)");
        System.out.println("Take a look at your products inventory below...");


        while(!loop){
            List<Item> allItems = itemService.getItemDAO().findAll();
            for(Item i: allItems) {
                System.out.println(i);
            }
            System.out.println("\nPlease search for Item by name.");
            name = scan.nextLine();
            List<Item> items = itemService.getItemDAO().findByName(name);
            for(Item i: items) {
                System.out.println(i);
            }

            System.out.println("\nRefill by items by item ID.");
            System.out.println("\nWhat is the item you want refilled.");

            refill = scan.nextInt();

            System.out.println("\nGREAT! \nNow how much would you like to put back into this item?");

            refill2 = scan.nextInt();

            itemService.getItemDAO().updateStock(refill, refill2);

            System.out.println("\nDo you want to continue with updating stock?");
            choice = scan.next().charAt(0);

            if(choice == 'y') {
                continue;
            } else {
                loop = true;
            }
        }

    }
}
