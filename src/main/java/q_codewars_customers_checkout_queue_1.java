import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
// TODO: Read and apply https://www.baeldung.com/java-for-loop-parallel

/**
 * There is a queue for the self-checkout tills at the supermarket. Your task is write a function to calculate the total
 * time required for all the customers to check out!
 *
 * input
 * customers: an array of positive integers representing the queue. Each integer represents a customer, and its value is
 * the amount of time they require to check out.
 * n: a positive integer, the number of checkout tills.
 * output
 * The function should return an integer, the total time required.
 *
 * Important
 * Please look at the examples and clarifications below, to ensure you understand the task correctly :)
 *
 * Examples
 * queueTime([5,3,4], 1)
 * // should return 12
 * // because when there is 1 till, the total time is just the sum of the times
 *
 * queueTime([10,2,3,3], 2)
 * // should return 10
 * // because here n=2 and the 2nd, 3rd, and 4th people in the
 * // queue finish before the 1st person has finished.
 *
 * queueTime([2,3,10], 2)
 * // should return 12
 * Clarifications
 * There is only ONE queue serving many tills, and
 * The order of the queue NEVER changes, and
 * The front person in the queue (i.e. the first element in the array/list) proceeds to a till as soon as it becomes free.
 * N.B. You should assume that all the test input will be valid, as specified above.
 *
 * P.S. The situation in this kata can be likened to the more-computer-science-related idea of a thread pool, with
 * relation to running multiple processes at the same time: https://en.wikipedia.org/wiki/Thread_pool
 */
class Scratch {
    static final int MAX_WAIT_SECONDS = 10;

    public static void main(String[] args) {
        System.out.println(solveSuperMarketQueue(new int[] { 2, 2, 3, 3, 4, 4 }, 2)); // 9
        System.out.println(solveSuperMarketQueue(new int[] {}, 1)); // 0
        System.out.println(solveSuperMarketQueue(new int[] { 1, 2, 3, 4, 5 }, 1)); // 15
    }

    record Customer(int queueTime) implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(20 * queueTime); // 100 milliseconds units
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static int solveSuperMarketQueue(int[] customers, int n) {
        ThreadPoolExecutor taskExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(n);
        var then = System.currentTimeMillis();
        Arrays.stream(customers)
            .forEach(customerQueueTime ->
                taskExecutor.submit(new Customer(customerQueueTime))
            );
        taskExecutor.shutdown();
        try {
            taskExecutor.awaitTermination(MAX_WAIT_SECONDS, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        var now = System.currentTimeMillis();
        var timeTookUnits = (int)(now - then) / 20;
        return timeTookUnits;
    }
}