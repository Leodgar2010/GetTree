import java.io.IOException;
import java.util.ArrayList;

public interface Output {

    void outputToFile(String filename, ArrayList n) throws IOException;
}
