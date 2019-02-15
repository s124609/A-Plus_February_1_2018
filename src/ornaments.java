import java.io.File;
import java.io.IOException;
import java.util.*;

import static java.lang.System.*;

public class ornaments {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("ornaments.dat"));
        file.nextInt();
        do {
            int layers = file.nextInt();
            int total = 0;

            for (int i = layers; i > 0; i--)
                total += (i * (i + 1)) / 2;

            out.println(total);
        }while(file.hasNextInt());

    }
}