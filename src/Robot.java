import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Robot {
    public String name;
    private Queue<Order> pocket = new LinkedList<>();
    private Queue<Order> tray = new LinkedList<>();
    private ArrayList<Integer> checks = new ArrayList<>();
    private Chef chef = new Chef();

    public Robot(String name, int tables){
        this.name=name;
        for(int i=0;i<tables;i++){
            this.checks.add(0);
        }
    }

    public void takeOrder(Order order){
        this.pocket.offer(order);
        this.checks.set(order.table, this.checks.get(order.table)+ order.price);
    }

    public void dropOffOrder(){
        this.chef.recieveOrder(this.pocket.poll());
    }


    public void pickUpFood(){
        this.tray.offer(this.chef.returnFood());
    }

    public void deliverFood(){
        Order food=this.tray.poll();
        if(food!=null) generateChecks();
    }

    private void generateChecks(){
        if (this.pocket.size()==0 && this.tray.size()==0 && this.chef.isEmpty()) {
            for (int i = 0; i < checks.size(); i++) {
                if(this.checks.get(i)!=0){
                System.out.println(this.name+" brought table #"+i+" it's check.\n   Total: $"+this.checks.get(i)+"\n");
                this.checks.set(i, 0);}
            }
        }
    }

}
