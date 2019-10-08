import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Person test = new Person("Danny" , LocalDate.of(1991, 10, 9));
        test.addChild("Eva");
        PersonIO.writePersonToObjectFile("Person.obj", test);

        Person afterRead = PersonIO.readFromObjectFile("Person.obj");
        System.out.println(afterRead.getName() + " " + afterRead.getDateOfBirth());
    }
}
