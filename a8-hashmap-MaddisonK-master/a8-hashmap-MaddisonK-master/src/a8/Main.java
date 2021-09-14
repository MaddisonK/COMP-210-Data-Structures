package a8;


import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,String> passwordManager = new PasswordManager<>();

//        passwordManager.put("carlie", "pass");
//        String get = passwordManager.remove("carlie");
//        System.out.println(get);
//        System.out.println(passwordManager.size());
//        passwordManager.display(42);
        boolean generate = false;
        while (true) {
            System.out.println("Enter Master Password");
            String password = scanner.nextLine();
            if (passwordManager.checkMasterPassword(password)) {
                while (true) {
                    String command = scanner.nextLine();
                    if (command.equals("New password")) {
                        String website_name = scanner.nextLine();
                        String password_value = scanner.nextLine();
                        passwordManager.put(website_name, password_value);
                        System.out.println("New password added");
                    } else if (command.equals("Get password")) {
                        String website_name = scanner.nextLine();
                        String password_value = passwordManager.get(website_name);
                        if (password_value == null) {
                            System.out.println("Password does not exist");
                        } else {
                            System.out.println(password_value);
                        }
                    } else if (command.equals("Delete account")) {
                        String website_name = scanner.nextLine();
                        String password_value = passwordManager.remove(website_name);
                        if (password_value == null) {
                            System.out.println("Account does not exist");
                        } else {
                            System.out.println("Account deleted");
                        }
                    } else if (command.equals("Check duplicate password")) {
                        String password_value = scanner.nextLine();
                        List<String> list = passwordManager.checkDuplicate(password_value);
                        if (list.isEmpty()) {
                            System.out.println("No account uses that password");
                        } else {
                            for (int i=0; i<list.size(); i++) {
                                System.out.println(list.get(i));
                            }
                        }
                    } else if (command.equals("Get accounts")) {
                       Set<String> keys = passwordManager.keySet();
                       System.out.println("Your accounts:");
                        for (String s: keys) {
                            System.out.println(s);
                        }
                    } else if (command.equals("Generate random password")) {
                        int length = scanner.nextInt();
                        generate = true;
                        System.out.println(passwordManager.generateRandomPassword(length));
                    } else if (command.equals("Exit")) {
                        break;
                    } else if (!generate) {
                        System.out.println("Command not found");
                    } else {
                        generate = false;
                    }
                }
            }
        }

    }
}
