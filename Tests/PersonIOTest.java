import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersonIOTest {

    @TempDir
    public File tempDirectory;

    @Test
    void writePersonToObjectFileTest() {
        File tempFile = new File(tempDirectory, "tempfile.obj");
        String tempFilePath = tempFile.getAbsolutePath();
        System.out.println(tempFilePath);
        Person personBefore = new Person("Maurice", LocalDate.of(1970, 7, 10));

        // ACT
        PersonIO.writePersonToObjectFile(tempFilePath, personBefore);
        Person personAfter = PersonIO.readFromObjectFile(tempFilePath);

        // ASSERT
        Assertions.assertEquals(personBefore, personAfter);
    }
}