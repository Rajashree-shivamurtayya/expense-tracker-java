package expensetracker.main;

import java.util.Scanner;

import expensetracker.service.BudgetService;
import expensetracker.service.ExpenseService;
import expensetracker.service.UserService;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UserService userService = new UserService();
        ExpenseService expenseService = new ExpenseService();
        BudgetService budgetService = new BudgetService();

        while (true) {
            System.out.println("\n===== EXPENSE TRACKER =====");
            System.out.println("1. Add User");
            System.out.println("2. View Users");
            System.out.println("3. Add Expense");
            System.out.println("4. View Expenses");
            System.out.println("5. Set Monthly Budget");
            System.out.println("6. Check Budget Status");
            System.out.println("7. Exit");
            System.out.print("Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    userService.addUser(sc.nextLine());
                    break;

                case 2:
                    userService.viewUsers();
                    break;

                case 3:
                    System.out.print("User ID: ");
                    int uid = sc.nextInt();
                    System.out.print("Amount: ");
                    double amt = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Category: ");
                    String cat = sc.nextLine();
                    System.out.print("Description: ");
                    String desc = sc.nextLine();
                    expenseService.addExpense(uid, amt, cat, desc);
                    break;

                case 4:
                    System.out.print("User ID: ");
                    expenseService.viewExpenses(sc.nextInt());
                    break;

                case 5:
                    System.out.print("User ID: ");
                    int buid = sc.nextInt();
                    System.out.print("Monthly Budget: ");
                    budgetService.setBudget(buid, sc.nextDouble());
                    break;

                case 6:
                    System.out.print("User ID: ");
                    int cid = sc.nextInt();
                    double total = expenseService.getMonthlyTotal(cid);
                    double budget = budgetService.getBudget(cid);
                    System.out.println("Spent: " + total);
                    System.out.println("Budget: " + budget);
                    if (total > budget) {
                        System.out.println("⚠ Budget exceeded!");
                    } else {
                        System.out.println("✅ Within budget");
                    }
                    break;

                case 7:
                    System.out.println("Thank you!");
                    System.exit(0);
            }
        }
    }
}
