import java.io.File;
import java.io.IOException;
import java.util.*;

import static java.lang.System.*;

public class reverse {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("reverse.dat"));
        int size = file.nextInt();

        do {
            String word = file.next();
            int index1 = file.nextInt();
            int index2 = file.nextInt();

            out.println(word.substring(0,index1) + word.substring(index2));

            size--;
        }while(size > 0);

    }
}