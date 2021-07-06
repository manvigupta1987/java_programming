import java.io.*;

public class SerializationDeserialization {
    public static void printdata(Demo object1)
    {

        System.out.println("name = " + object1.name);
        System.out.println("age = " + object1.age);
        System.out.println("a = " + object1.a);
        System.out.println("b = " + object1.b);
    }

    public static void main(String[] args) {
        Demo demo = new Demo("ab", 20, 2, 1000);
        String fileName = "output.txt";

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(demo);

            outputStream.close();
            fileOutputStream.close();

            System.out.println("Object has been serialized\n"
                    + "Data before Deserialization.");
            printdata(demo);

            // value of static variable changed
            demo.b = 2000;
        } catch (IOException e) {
            e.printStackTrace();
        }

        demo = null;

        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            demo = (Demo) objectInputStream.readObject();

            fileInputStream.close();
            objectInputStream.close();

            System.out.println("Object has been deserialized\n"
                    + "Data after Deserialization.");
            printdata(demo);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

class Demo implements Serializable {
    private static final long serialversionUID = 129348938L;
    transient int a;
    static int b;
    String name;
    int age;

    public Demo(String name, int age, int a, int b)
    {
        System.out.println("constructor called");
        this.name = name;
        this.age = age;
        this.a = a;
        this.b = b;
    }


}
