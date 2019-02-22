import java.io.File;
import java.io.IOException;
import java.util.*;

import static java.lang.System.*;

public class quadratics {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("quadratics.dat"));
        int size = file.nextInt();

        do {
            double a = file.nextDouble();
            double b = file.nextDouble();
            double c = file.nextDouble();

            double solutionP = ((-b + Math.sqrt(Math.pow(b,2) - 4*a*c))/(2*a));
            double solutionM = ((-b - Math.sqrt(Math.pow(b,2) - 4*a*c))/(2*a));

            out.printf("%.3f", solutionP);
            out.print(", ");
            out.printf("%.3f", solutionM);
            out.println();

            size--;
        }while(size > 0);
    }
}