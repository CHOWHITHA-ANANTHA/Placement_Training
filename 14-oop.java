
//Overriding in Java GFG
class Animal {
    void sound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal a = new Dog();
        a.sound();
    }
}
//Abstraction in Java GFG
abstract class Shape {
    abstract void draw();
}

class Circle extends Shape {
    void draw() {
        System.out.println("Drawing Circle");
    }
}

public class Main {
    public static void main(String[] args) {
        Shape s = new Circle();
        s.draw();
    }
}

//this keyowrd in Java Javatpoint
class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void display() {
        System.out.println(id + " " + name);
    }
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student(101, "Krishna");
        s.display();
    }
}

//Important keyowrds in Java inheritance - extends,implements,super,instanceof Tutorialspoint
interface Animal {
    void sound();
}

class LivingBeing {
    LivingBeing() {
        System.out.println("LivingBeing Constructor");
    }
}

class Dog extends LivingBeing implements Animal {

    Dog() {
        super();
    }

    public void sound() {
        System.out.println("Dog Barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();

        d.sound();

        System.out.println(d instanceof Dog);
        System.out.println(d instanceof LivingBeing);
    }
}
//Instance initializer block Javatpoint
class Demo {

    {
        System.out.println("Instance Initializer Block");
    }

    Demo() {
        System.out.println("Constructor");
    }
}

public class Main {
    public static void main(String[] args) {
        Demo d1 = new Demo();
        Demo d2 = new Demo();
    }
}
