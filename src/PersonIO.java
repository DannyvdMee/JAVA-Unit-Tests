import java.io.*;

public class PersonIO {


    public static void writePersonToObjectFile(String filename, Person person) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            objectOutputStream.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Person readFromObjectFile(String filename) {
        Person person = null;

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))) {
            person = (Person) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return person;
    }
}
