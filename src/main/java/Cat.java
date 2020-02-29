public final class Cat {

    private String name;
    String color;
    public int age;

    public Cat(String name, String color) {

        this.name = name;
        this.color = color;
    }

    public Cat() {

    }


    public void info () {
        System.out.println(name + " " + color + " " + age);
    }

    private void meow(){
        System.out.println(name + "meow");
    }

}
