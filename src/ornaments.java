import java.io.File;
import java.io.IOException;
import java.util.*;

import static java.lang.System.*;

public class ornaments {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("ornaments.dat"));
        file.nextInt();
        do {
            long num = file.nextInt();
            long total;

            total = (num * (num + 1) * (num+2)) / 6;
            out.println(total);
        }while(file.hasNextInt());

    }
}