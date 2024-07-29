import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FoodMenu fm =new FoodMenu();
        System.out.println(fm);
        System.out.println(fm.getFood(3));
        System.out.println(fm.getLowestCostFood());
        Scanner input=new Scanner(System.in);
        String customerName=input.nextLine();

        int money=input.nextInt();
        Customer marek = new Customer(customerName,money);
        TakeOutSimulator takeOutSimulator =new TakeOutSimulator(marek,new FoodMenu(),input);
        takeOutSimulator.startTakeOutSimulator();
    }
}
