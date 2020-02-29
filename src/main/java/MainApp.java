import java.lang.reflect.Modifier;

public class MainApp {
    public static void main(String[] args) throws ClassNotFoundException {
        Cat cat = new Cat();

        Class c1 = Cat.class;
//        Class c2 = cat.getClass();    // варианты
//        Class c3 = Class.forName("Cat");

        System.out.println(int[].class.getName());
        System.out.println(int[][].class.getName());

        int mods = c1.getModifiers();
        System.out.println(mods);
        System.out.println(Modifier.isPublic(mods));
        System.out.println(Modifier.isStatic(mods));
        System.out.println(Modifier.isFinal(mods));
    }
}
