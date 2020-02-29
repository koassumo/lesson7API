import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;

public class TestStarter {


    public static void main(String[] args) {
        start(TestClass.class);
    }

    public static void start(Class c) {
        Method before = null;
        Method after = null;
        HashMap<Integer, LinkedList<Method>> tests = new HashMap<>();
        for (Method m : c.getMethods()) {
            if (m.getAnnotation(BeforeSuite.class) != null) {
                if (before != null) throw new RuntimeException("превышение количества методов");
                before = m;
            }
            if (m.getAnnotation(AfterSuite.class) != null) {
                if (after != null) throw new RuntimeException("превышение количества методов");
                before = m;
            }
            if (m.getAnnotation(Test.class) != null) {
                int p = m.getAnnotations(Test.class).priority();
                if (p < 0 || p > 10) throw new RuntimeException("Неверный приоритет");
                if (!tests.containsKey(p)) tests.put(p, new LinkedList<Method>());
                tests.get(p).add(m);
            }
        }
        try {
            if (before != null) before.invoke(null);
            for (Integer i : tests.keySet()) {
                for (Method m : tests.get(i)) {
                    m.invoke(null);
                }
            }
            if (after != null) after.invoke(null);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}


