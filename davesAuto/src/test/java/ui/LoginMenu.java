package ui;

import daos.OrderHistoryDAO;
import daos.StoreLocDAO;
import daos.UserDAO;
import models.StoreLoc;
import models.User;
import services.OrderHistoryService;
import services.ShoppingCartService;
import services.StoreLocService;
import services.UserService;

import java.util.List;
import java.util.Scanner;

public class LoginMenu implements IMenu {
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final StoreLocService storeLocService;
    public final OrderHistoryService orderHistoryService;
    private final User user;
    public static boolean loggedIn;
    public static User currentUser;



    public LoginMenu(UserService userService, ShoppingCartService shoppingCartService, StoreLocService storeLocService, OrderHistoryService orderHistoryService, User user) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.storeLocService = storeLocService;
        this.orderHistoryService = orderHistoryService;
        this.user = user;
    }

    Scanner scan = new Scanner(System.in);

    @Override
    public void start() {
        char input = ' ';

        exit: {
            while (true) {
                System.out.println("\nWelcome to login menu");
                System.out.println("[1] log in");
                System.out.println("[2] Create new account");
                System.out.println("[3] Employee Log in");
                System.out.println("[x] Exit");

                input = scan.next().charAt(0);

                switch (input) {
                    case '1':
                        login();
                        break;
                    case '2':
                        createAccount();
                        break;
                    case '3':
                        new AdminMenu(userService, new OrderHistoryService(new OrderHistoryDAO()), shoppingCartService, storeLocService, user).start();
                        break;
                    case 'x':
                        break exit;
                    default:
                        System.out.println("\nInvalid input!");
                        break;
                }
            }
        }
    }

    private void createAccount() {
        String username = "";
        String password1 = "";
        String password2 = "";
        String firstName = "";
        String lastName = "";
        String email = "";

        System.out.println("\nCreating account...");
        System.out.println("\n\n\n");

        while (true) {
            while (true) {
                System.out.print("\nEnter in username: ");
                username = scan.next();

                if (!userService.isDupUsername(username)) {
                    if (userService.isValidUsername(username)) {
                        user.setUsername(username);
                        break;
                    } else {
                        System.out.println("\nInvalid username :(");
                    }

                } else {
                    System.out.println("\nDuplicate username :(");
                }
            }

            while (true) {
                System.out.print("\nEnter in password: ");
                password1 = scan.next();

                System.out.print("\nEnter in password again: ");
                password2 = scan.next();

                if (password1.equals(password2)) {
                    if (userService.isValidPassword(password1)) {
                        user.setPassword(password1);
                        break;
                    } else {
                        System.out.println("\nInvalid password!");
                    }
                } else {
                    System.out.println("Password does not match!");
                }
            }

            System.out.print("\nEnter in first name: ");
            firstName = scan.next();

            user.setFirstName(firstName);
//--------------------------------------------
            System.out.println("\nEnter in last name: ");
            lastName = scan.next();

            user.setLastName(lastName);
//----------------------------------------------

            System.out.println("\nEnter in email address");
            email = scan.next();

            user.setEmailAddress(email);

            System.out.println("|---------------------------------------------------|");
            System.out.println("|-Howdy! before continuing please select a location-|");
            System.out.println("|---------------------------------------------------|");
            viewAllLocations();
            System.out.println("\nPlease confirm credentials (y/n)");
            System.out.print("Username: " + username);
            System.out.print("\nPassword: " + password1);
            System.out.print("\nFirst Name: " + firstName);
            System.out.print("\nLast Name: " + lastName);
            System.out.print("\nEmail Address: " + email);

            System.out.print("\nEnter: ");

            if (scan.next().charAt(0) == 'y') {
                userService.getUserDAO().save(user);

                System.out.println("Account created succesfully!");
                break;
            }
        }
    }

    private void login() {
        while (true) {
            System.out.println("\n\n\n");

            System.out.print("\nUsername: ");
            user.setUsername(scan.next());

            System.out.print("\nPassword: ");
            user.setPassword((scan.next()));

            if (userService.isValidLogin(user)) {
                user.setId(userService.getUserDAO().getUserId(user.getUsername()));
                System.out.println("|---------------------------------------------------|");
                System.out.println("|-Howdy! before continuing please select a location-|");
                System.out.println("|---------------------------------------------------|");
                viewAllLocations();



                User currentUser = userService.getUserDAO().findById(user.getId());

                new MainMenu(currentUser, new StoreLoc(), new StoreLocService(new StoreLocDAO(), new UserDAO())).start();

                break;
            } else {
                System.out.println("\nInvalid login");
            }
        }
    }

    public void viewAllLocations()
    {
        int input = 0;
        Scanner scan = new Scanner(System.in);
        List<StoreLoc> locList = storeLocService.storeLocDAO().findAll();

        System.out.println("\nWelcome to Daves Autobody Supply");
        System.out.println("\nWhat location are we at today?");

        System.out.println();
        for (int i = 0; i < locList.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + locList.get(i).toString());

        }

        while (true) {
            System.out.println("\nSelect a location to enter:");

            input = scan.nextInt();

            if (input > locList.size()) {
                System.out.println("\nInvalid Input");
            } else {
                List<StoreLoc> newLocList = storeLocService.storeLocDAO().findByStoreLoc(locList.get(input).getLocId());
                System.out.println(locList.get(input));
                user.setStoreLocId(input);
                break;
            }

        }
    }

}