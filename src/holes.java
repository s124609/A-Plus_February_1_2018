import java.io.File;
import java.io.IOException;
import java.util.*;

import static java.lang.System.*;

public class holes {
    private static int sections, spaces, r, c;
    private static String[][] box;
    private static int[][] visited;

    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("holes.dat"));
        int size = file.nextInt();
        do {
            sections = 0; spaces = 0;
            r = file.nextInt(); c = file.nextInt();
            box = new String[r][c];
            visited = new int[r][c];
            file.nextLine();

            for (int i = 0; i < r; i++) {
                String[] line = file.nextLine().split("");
                box[i] = line;
            }

            traverse();

            out.println(sections + " sections, " + spaces + " spaces");

            size--;
        }while(size > 0);

    }

    private static void traverse()
    {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (box[i][j].equals(".")) {
                    spaces++;
                    visited[i][j] = 1;
                    if (!(box[i + 1][j].equals(".") || box[i - 1][j].equals(".")
                            || box[i][j + 1].equals(".") || box[i][j - 1].equals(".")))
                        sections++;
                    else if (visited[i + 1][j] == 0 && visited[i - 1][j] == 0
                            && visited[i][j + 1] == 0 && visited[i][j - 1] == 0)
                        sections++;
                }
            }
        }
    }
}