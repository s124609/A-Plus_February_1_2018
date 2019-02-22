import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class checkpoint {
    private static String[][] checkpoint;
    private int[][] shadow;
    private static Scanner file;

    private checkpoint() {
        int times = file.nextInt();file.nextLine();
        for(int num = 1; num <= times; num++) {
            int r = file.nextInt();
            int c = file.nextInt();
            int total = 0;
            int numCheck = file.nextInt();

            String[][] maze = new String[r][c];
            shadow = new int[r][c];
            int[] locs = new int[4];
            file.nextLine();

            for(int i = 0; i < r; i++) {
                maze[i] = file.nextLine().split("");
            }

            for (int curCheck = 1; curCheck <= numCheck +1; curCheck++) {
                checkpoint = maze;
                for (int x = 0; x < r; x++)
                    Arrays.fill(shadow[x],1<<16);

                for(int g = 0; g < maze.length; g++){
                    for(int l = 0; l < maze[g].length; l++) {
                        if (curCheck == 1) {
                            if (checkpoint[g][l].equals("S")) {
                                locs[0] = g;
                                locs[1] = l;
                            }
                            else if (checkpoint[g][l].equals("" + curCheck)) {
                                locs[2] = g;
                                locs[3] = l;
                            }
                        }
                        else if (curCheck == numCheck +1) {
                            if (checkpoint[g][l].equals("" + (curCheck-1))) {
                                locs[0] = g;
                                locs[1] = l;
                            }
                            else if (checkpoint[g][l].equals("E")) {
                                locs[2] = g;
                                locs[3] = l;
                            }
                        }
                        else {
                            if (checkpoint[g][l].equals("" + (curCheck-1))) {
                                locs[0] = g;
                                locs[1] = l;
                            }
                            else if (checkpoint[g][l].equals("" + curCheck)) {
                                locs[2] = g;
                                locs[3] = l;
                            }
                        }
                    }
                }
                permu(locs[0], locs[1],0);

                total += shadow[locs[2]][locs[3]];
            }

            System.out.println(total);
        }
    }

    private void permu(int r, int c, int length) {
        if((r >= 0) && (c >= 0) && (r < checkpoint.length) && (c < checkpoint[r].length) && (!(checkpoint[r][c].equals("#")))
                && (length < shadow[r][c])) {
            shadow[r][c] = length;
            permu(r+1,c,length+1);
            permu(r-1,c,length+1);
            permu(r,c+1,length+1);
            permu(r,c-1,length+1);
        }
    }

    public static void main(String[] args) throws Exception {
        file  = new Scanner(new File(("checkpoint.dat")));
        new checkpoint();
    }
}