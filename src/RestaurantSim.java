public class RestaurantSim {
    public static void main(String[] args) {
        // set up the robot with a number of tables to serve and a name
        Robot uwu = new Robot("uwu",3);

        // the robot takes the orders and hangs onto them in his "pocket" until instructed to drop
        // off the order at the kitchen.
        Order order1= new Order(0,"mac and cheese", 20);
        uwu.takeOrder(order1);
        uwu.takeOrder(new Order(1,"cheesecake", 30));
        uwu.takeOrder(new Order(2,"cheese quesadilla", 15));
        uwu.takeOrder(new Order(0,"lobster", 100));

        // robot drops the order off at the kitchen and removes the order from his "pocket."
        uwu.dropOffOrder();
        uwu.dropOffOrder();
        uwu.dropOffOrder();
        uwu.dropOffOrder();

        // next the robot picks the order up after it has been processed by the chef and puts it
        // on his "tray" to bring to the table. (orders 1-3)
        uwu.pickUpFood();
        uwu.pickUpFood();
        uwu.pickUpFood();

        // the robot delivers the food to the table and removes it from his "tray."
        // the robot also checks if it has more to do before delivering the tables their checks,
        // and sees there is still an order in the kitchen he hasn't picked up.
        uwu.deliverFood();
        uwu.deliverFood();
        uwu.deliverFood();

        // the robot picks up the last order and delivers it, and delivers the checks automatically
        //because it cleared all queues
        uwu.pickUpFood();
        uwu.deliverFood();

        // if the robot checks for more things to do while the queues are empty, nothing will happen
        // and all queues remain empty
        uwu.dropOffOrder();
        uwu.pickUpFood();
        uwu.deliverFood();

        // then the robot goes through one more cycle for a single table, and only brings that table its check
        // and ignores the tables that had no orders
        uwu.takeOrder(new Order(1,"cheesecake", 30));
        uwu.dropOffOrder();
        uwu.pickUpFood();
        uwu.deliverFood();
    }
}
