import java.sql.SQLOutput;
import java.util.Scanner;

public class TakeOutSimulator {
    private Customer customer;
    private FoodMenu menu;
    private Scanner input;

    public TakeOutSimulator(Customer customer, FoodMenu menu, Scanner input) {
        this.customer = customer;
        this.menu = menu;
        this.input = input;
    }
    private <T> T getOutputOnIntInput(String userInputPrompt,IntUserInputRetriever<T> intUserInputRetriever){

        while(true){
            System.out.println(userInputPrompt);
            if(input.hasNextInt()) {
                int userSelection = input.nextInt();
                try {
                    return intUserInputRetriever.produceOutputOnIntUserInput(userSelection);
                } catch (IllegalArgumentException e) {
                    System.out.println("not valid");

                }
            }else{
                System.out.println("put int type");
                input.next();

            }
        }
    }
    public boolean shouldSimulate(){
        String userPrompt="input 1 or 0";
        IntUserInputRetriever<Boolean>retriever=(selection -> {if(selection !=0 &&
        selection !=1){ throw new IllegalArgumentException("badly selected");
    }
    if(selection ==0){
        return false;
    }else{
        Food lowestCostFood=menu.getLowestCostFood();
        if(customer.getMoney()>=lowestCostFood.getPrice()){
            return true;
        }else{
            System.out.println("not enough money");
            return false;
        }
    }

});
        return false;
    }
    public Food getMenuSelection(){
        String userPrompt="choose something";
        System.out.println(menu);
        IntUserInputRetriever<Food> retriever = selection -> {

            Food selectedFood = menu.getFood(selection);
            if (selectedFood == null) {
                throw new IllegalArgumentException("Invalid selection. Please choose a valid menu item.");
            }
            return selectedFood;
        };
        return getOutputOnIntInput(userPrompt,retriever);

}
    public boolean isStillOrderingFood(){
        String userPrompt="please click 1 to continue shopping or 0 to checkout";
        IntUserInputRetriever<Boolean>retriever=(selection -> {if(selection !=1 &&
                selection !=0){ throw new IllegalArgumentException("badly selected");
        }
            if(selection ==0){
                return false;
            }else{
                return true;
            }

        });
        return getOutputOnIntInput(userPrompt,retriever);
    }
    public void checkoutCustomer(ShoppingBag<Food>shoppingBag){
        System.out.println("processing payment");
        System.out.println("your remaining money"+shoppingBag.getTotalPrice());
        System.out.println("Thank you and enjoy food");
        int newmoney= customer.getMoney();
        int temp=newmoney-shoppingBag.getTotalPrice();
        customer.setMoney(temp);
        System.out.println("Your money after shopping: "+temp);
    }
    public void takeOutPrompt(){
        ShoppingBag<Food>shoppingBag=new ShoppingBag<>();
        int customerMoneyLeft=customer.getMoney();
        while(true){
            System.out.println(customerMoneyLeft);
            Food selectedFood = getMenuSelection();
            if(customerMoneyLeft>=selectedFood.getPrice()){
                customer.setMoney(customerMoneyLeft-selectedFood.getPrice());
                shoppingBag.addItem(selectedFood);
            }else{
                System.out.println("not enough money");
            }
            if(!isStillOrderingFood()){
                break;
            }

        }
        checkoutCustomer(shoppingBag);
    }
    public void startTakeOutSimulator(){
        while(true){
            System.out.println("Hello, welcome to my restaurant!");
            System.out.println("Welcome "+customer.getName());
            shouldSimulate();
                System.out.println("sorry");

                takeOutPrompt();


        }

    }

}