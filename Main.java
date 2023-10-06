import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

// this was actually quite challenging, especially the logic about change.

public class Main {
    static int user_money = 705;
    boolean running = true;
    public static void main(String[] args) throws InterruptedException{
        Scanner keyboard = new Scanner(System.in);
        HashMap<String, Integer> items = new HashMap<String, Integer>();

        items.put("juice", 100);
        items.put("water", 45);
        items.put("soda", 50);
        items.put("chocolate bar", 75);

        // create array list with 4 values, 25, 10, 5, 1
        ArrayList<Integer> coins = new ArrayList<Integer>();
        coins.add(25);
        coins.add(10);
        coins.add(5);
        coins.add(1);

        ArrayList<String> coin_names = new ArrayList<String>();

        coin_names.add("Quarter");
        coin_names.add("Dime");
        coin_names.add("Nickel");
        coin_names.add("Penny");



        boolean running = true;

        while (running) {
            int wait_time = 1;

            System.out.println("\n" + //
                    "╔╗──╔╗──────╔╗────────────────╔╗\n" + //
                    "║╚╗╔╝║──────║║────────────────║║\n" + //
                    "╚╗║║╔╩═╦═╗╔═╝╠╦═╗╔══╗╔╗╔╦══╦══╣╚═╦╦═╗╔══╗\n" + //
                    "─║╚╝║║═╣╔╗╣╔╗╠╣╔╗╣╔╗║║╚╝║╔╗║╔═╣╔╗╠╣╔╗╣║═╣\n" + //
                    "─╚╗╔╣║═╣║║║╚╝║║║║║╚╝║║║║║╔╗║╚═╣║║║║║║║║═╣\n" + //
                    "──╚╝╚══╩╝╚╩══╩╩╝╚╩═╗║╚╩╩╩╝╚╩══╩╝╚╩╩╝╚╩══╝\n" + //
                    "─────────────────╔═╝║\n" + //
                    "─────────────────╚══╝\n");
            


            for (Entry<String, Integer> entry : items.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            System.out.println("\nEnter money or type 1 to quit\n");
            String str_user_input = keyboard.nextLine();
            try {
                int user_input = Integer.valueOf(str_user_input);
                if (user_input == 1) {
                    running = false;
                    wait_time = 0;
                } else if (user_money < 45) {
                    System.out.println("Not enough money in bank account.");
                    wait_time = 0;
                    running = false;
                } else if (user_input < 45) {
                    System.out.println("Not enough money in machine.");
                } else{
                    try {
                        System.out.println("Enter item you want");
                        String user_input_item = keyboard.nextLine();
                        if (items.get(user_input_item) > user_input) {
                            System.out.println("Not enough money in machine.");
                        } else {
                            user_money -= items.get(user_input_item);
                            int change = user_input - items.get(user_input_item);
                            for (int i = 0; i < coins.size(); i++) {
                                System.out.println(coin_names.get(i) + ": " + change / coins.get(i));
                                change = change % coins.get(i);
                    }
                    } 
                }
                    
                     catch(Exception e) {
                        System.out.println("Invalid input");
                    }
                }
 
                }
             catch(NumberFormatException e) {
                System.out.println("Invalid integer input");
            }
            TimeUnit.SECONDS.sleep(wait_time);

        } 
        keyboard.close();
    }
}