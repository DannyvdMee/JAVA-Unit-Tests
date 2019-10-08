import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person implements Serializable {

    private String name;
    private LocalDate dateOfBirth;
    private List<String> children;

    public Person(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.children = new ArrayList<>();
    }

    public void addChild(String name){
        children.add(name);
    }

    public List<String> getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getAge(){
        return LocalDate.now().getYear() - dateOfBirth.getYear();
    }

    // Overrules the equals statement, if compared it proper checks if persons can be the same
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(dateOfBirth, person.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dateOfBirth);
    }


}
