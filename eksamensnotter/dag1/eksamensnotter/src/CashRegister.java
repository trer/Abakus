import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CashRegister {

    private HashMap<String, Integer> food;
    private HashMap<String, Integer> adjectives;

    public CashRegister() {
        this.food = new HashMap<>();
        this.adjectives = new HashMap<>();
    }

    public void setPriceOfAdjective(String adjective, int price) {
        adjectives.put(adjective.toLowerCase(), price);
    }

    public void setPriceOfDish(String dish, int price) {
        food.put(dish.toLowerCase(), price);
    }

    public double getPriceOfOrder(String order) {
        if (order.matches("")) {
            return 0;
        }
        int adj_count = 0;
        int dish_count = 0;
        String[] words = order.split(" ");
        int price = 0;
        for (String word : words) {
            word = word.toLowerCase();
            if (this.food.containsKey(word)) {
                price += this.food.get(word);
                dish_count ++;
            } else if (this.adjectives.containsKey(word)) {
                price += this.adjectives.get(word);
                adj_count ++;
            } else {
                price += 10;
            }
        }
        if (dish_count > adj_count) {
            price += 25;
        }
        System.out.println(price);
        return price;
    }

    public static void main(String[] args) {
        CashRegister cs = new CashRegister();
        cs.getPriceOfOrder("");
        cs.getPriceOfOrder("small soup");
        cs.getPriceOfOrder("Large swizz salad with fried fish and peanuts");
        cs.setPriceOfAdjective("salad", 35);
        cs.setPriceOfDish("large", 40);
        cs.getPriceOfOrder("Large swizz salad with fried fish and peanuts");
        cs.setPriceOfAdjective("cheap", 0);
        cs.getPriceOfOrder("Large swizz salad with cheap fried fish and peanuts");
        CashRegister cr = new CashRegister();
        cr.setPriceOfDish("Salad", 35);
        cr.getPriceOfOrder("Large swizz salad with cheap fried fish and peanuts");
    }
}

