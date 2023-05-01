import ecs100.UI;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    static ArrayList<object> objects = new ArrayList<object>();
    public static void main(String[] args) {
        UI.initialise();
        UI.setWindowSize(1300,900);
        object Obj1 = new object(70, 100);
        object Obj2 = new object(70, 100);
        objects.add(Obj1);
        objects.add(Obj2);
        Obj1.setIndex(objects.indexOf(Obj1));
        Obj2.setIndex(objects.indexOf(Obj2));

        final ScheduledExecutorService objExecutor = Executors.newSingleThreadScheduledExecutor();
        objExecutor.scheduleAtFixedRate(Obj1::runner, 0, 10, TimeUnit.MILLISECONDS);
        objExecutor.scheduleAtFixedRate(Obj2::runner, 0, 10, TimeUnit.MILLISECONDS);
    }
}