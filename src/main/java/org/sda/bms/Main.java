package org.sda.bms;

import org.sda.bms.controller.AuthorController;
import org.sda.bms.controller.UserOption;
import org.sda.bms.repository.AuthorRepository;
import org.sda.bms.repository.AuthorRepositoryImpl;
import org.sda.bms.service.AuthorServiceImpl;
import org.sda.bms.utils.SessionManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        startHibernate();


        // dependencies
        Scanner scanner = new Scanner(System.in);
        AuthorController authorController = new AuthorController(
                new AuthorServiceImpl(new AuthorRepositoryImpl()),scanner
        );

        UserOption userOption = UserOption.UNKNOWN;
        while (userOption != UserOption.EXIT) {
            UserOption.printAllOptions();
            System.out.println(" ");
            System.out.println("Please Select an Option: ");
            try {
                int selectedOption = Integer.parseInt(scanner.next().trim());
                userOption = UserOption.findUserOption(selectedOption).orElse(UserOption.UNKNOWN);
            } catch (NumberFormatException e) {
                userOption = UserOption.UNKNOWN;
            }

            switch (userOption) {
                case CREATE_AUTHOR:
                    authorController.create();
                    break;
                case UPDATE_AUTHOR:
                    System.out.println("Not Implemented");
                    break;
                case DELETE_AUTHOR:
                    System.out.println("Not Implemented");
                    break;
                case UNKNOWN:
                    System.out.println("Please insert a valid option!");
                    break;
                case EXIT:
                    stopHibernate();
                    System.out.println("Good bye!");
                    break;
                default:
                    System.out.println("Not implemented. Please contact your Administrator");
                    break;

            }
        }

        SessionManager.getSessionFactory();
        for (int i = 0; i <= 50; i++) {
            System.out.println(" ");
        }
    }

    private static void startHibernate() {
    }

    private static void stopHibernate() {
        SessionManager.shutDown();
        for (int i = 0; i <= 0; i++) ;
        System.out.println(" ");
    }
}