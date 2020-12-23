import java.io.*;

public class TransientKeyword {
    public static void main(String[] args) {
        Book narnia = new Book(1024, "Narnia", "unknow", 2);
        System.out.println("Before Serialization: " + narnia);

        try {
            FileOutputStream fos = new FileOutputStream("narnia.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(narnia);

            System.out.println("Book is successfully Serialized ");

            FileInputStream fis = new FileInputStream("narnia.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Book oldNarnia = (Book) ois.readObject();

            System.out.println("Book successfully created from Serialized data");
            System.out.println("Book after seriazliation : " + oldNarnia);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Book implements Serializable {
    private int ISBN;
    private String title;
    private String author;
    private transient int edition = 1; //transient variable not serialized
    // transient variables are not serialized and persisted and during deserialization, those values are initialized with there
    // default value which is zero in case of int variable. Since constructor also didn't run during de-serialization it won't get
    // the value provided during constructor.

    public Book(int ISBN, String title, String author, int edition) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.edition = edition;
    }

    @Override
    public String toString() {
        return "Book{" + "ISBN=" + ISBN + ", title=" + title + ", author=" + author + ", edition=" + edition + '}';
    }
}



