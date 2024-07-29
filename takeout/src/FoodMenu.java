import java.util.ArrayList;
import java.util.List;

public class FoodMenu{
    private List<Food> menu=new ArrayList<>();
    public FoodMenu(){
        menu.add(new Food("porkchop","pig",3));
        menu.add(new Food("steak","cow",4));
        menu.add(new Food("chickenlegs","chicken",5));
    }

    @Override
    public String toString() {
        StringBuilder sb =new StringBuilder();
        for(int i=0;i<menu.size();i++){
            sb.append(i+1);
            sb.append(". ");
            sb.append(menu.get(i));
            sb.append("\n");
        }
        return sb.toString();
    }
    public Food getFood(int index){
        if(index>menu.size()){
            return null;
        }else{
            return menu.get(index-1);
        }
    }
    public Food getLowestCostFood(){
        Food lowestPrice=menu.get(0);
        for(Food food:menu){
            if(lowestPrice.getPrice()>food.getPrice()){
                lowestPrice=food;
            }
        }
        return lowestPrice;
    }
}
