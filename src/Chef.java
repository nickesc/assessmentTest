import java.util.LinkedList;
import java.util.Queue;

public class Chef {
    private Queue<Order> orders = new LinkedList<>();
    public Chef(){
    }

    public Order recieveOrder(Order order){
        this.orders.offer(order);
        return(order);
    }

    public Order returnFood(){
        return(this.orders.poll());
    }

    public boolean isEmpty(){
        return this.orders.size() == 0;
    }
}
