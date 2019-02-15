import java.io.File;
import java.io.IOException;
import java.util.*;

import static java.lang.System.*;

public class mathematics {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("mathematics.dat"));
        file.nextInt();
        int total = 0;

        do {
            total += file.nextInt();
        }while (file.hasNextInt());

        out.println(total);
    }
}