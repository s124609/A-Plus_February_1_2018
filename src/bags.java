import java.io.File;
import java.io.IOException;
import java.util.*;
import static java.lang.System.*;

public class bags {
    private static int length;
    private static int goal;
    private static int[] array;

    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("bags.dat"));
        int size = file.nextInt();

        do {
            length = file.nextInt();
            array = new int[length];

            for (int i = length-1; i >= 0; i--)
                array[i] = file.nextInt();

            goal = file.nextInt();

            permu(0, 0, 0);

            size--;
        }while(size > 0);
    }

    private static void permu(int pos, int current, int num) {
        if((pos < length) && current != goal) {
            if (current + array[pos] <= goal) {
                current += array[pos];
                permu(pos+1, current, num+1);
            }
            else
                permu(pos+1, current, num);
        }
        else if (current == goal)
            out.println(num);
        else
            out.println("Not possible");
    }

}
