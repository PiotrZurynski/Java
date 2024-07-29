import java.util.HashMap;
import java.util.Map;

public class ShoppingBag <T extends PricedItem>{
    private Map<T,Integer> shoppingBag;

    public ShoppingBag() {
        shoppingBag=new HashMap<>();
    }
    public void addItem(T item){
        if(shoppingBag.get(item)==null){
            shoppingBag.put(item,1);
        }else{
            int current=shoppingBag.get(item);
            current++;
            shoppingBag.put(item,current);
        }
    }
    public int getTotalPrice(){
        int totalPrice = 0;
        for(T item: shoppingBag.keySet()){
            int price= (int) item.getPrice();
            int quantity=shoppingBag.get(item);
            totalPrice+=price*quantity;
        }
        return totalPrice;
    }
}
