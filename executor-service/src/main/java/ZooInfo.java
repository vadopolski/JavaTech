import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ZooInfo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            System.out.println("Begin");
            service.execute(() -> System.out.println("Starting inventory"));
            service.execute(() -> {
                for (int i = 0; i < 20; i++)
                    System.out.println("String number: " + i);
            });
            service.execute(() -> System.out.println("Finishing inventory"));
            Future<?> future = service.submit(() -> System.out.println("Hello Zoo"));

            System.out.println("End");
            System.out.println("Future isCancelled is " + future.isCancelled());
            System.out.println("Future cancel is " + future.cancel(true));
            System.out.println("Future isCancelled is " + future.isCancelled());
            System.out.println("Future get is " + future.get());

            Thread.sleep(5000);
            System.out.println("Future isDone is " + future.isDone());

        }
        finally {if (service != null) service.shutdown();}
             {
        }
    }
}
