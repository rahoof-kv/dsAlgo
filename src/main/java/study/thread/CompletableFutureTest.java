package study.thread;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest {

    public static void main(String[] args) {
        CompletableFutureTest test = new CompletableFutureTest();
        test.test();
    }

    private void test() {


        for (int i = 0; i < 100; i++) {

            CompletableFuture.supplyAsync(() -> getOrder())
                    .thenApply(order -> processOrder(order))
                    .thenAccept(order -> finishOrder(order));
            System.out.println(i);

        }

    }

    private Order getOrder(){
        Integer i = new Random().nextInt();
        System.out.println("getOrder " + i);
        return new Order(i);
    }

    private Order processOrder(Order order){
        System.out.println("processOrder "+ order.getId());
        return order;
    }

    private Order finishOrder(Order order){
        System.out.println("finishOrder "+ order.getId());
        return order;
    }

    class Order {
        Integer id ;

        public Order(Integer id) {
            this.id = id;
        }

        public Integer getId() {
            return id;
        }
    }
}


