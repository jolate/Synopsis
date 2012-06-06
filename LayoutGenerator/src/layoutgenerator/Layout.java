/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package layoutgenerator;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author jota
 */
public class Layout {

    public int size = 30;
    private int sparcity = 40;
    public boolean layout[][];
    public boolean isolated[][];

    public Layout() {
        Random randomGenerator = new Random(0);
        layout = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int sparse_factor = 0 + (int) (randomGenerator.nextDouble() * ((100 - 0) + 1));
                if (sparse_factor < sparcity) {
                    layout[i][j] = true;
                } else {
                    layout[i][j] = false;
                }
            }
        }
    }

    public void moveIsolatedSquares() {
        isolated = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(layout[i][j]==true){
                    isolated[i][j] = true;
                } else {
                    isolated[i][j] = false;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(isolated[i][j]==true){
                    
                }
            }
        }
    }

    public int searchNewLocation(int i, int j) {
        int up = 0;
        int row = i;
        int column = j;
        /*
         * see up
         */
        while (layout[row][column] != true) {
            up = up + 1;
            row = row - 1;
            if (row == -1) {
                up = 0;
                break;
            }
        }
        /*
         * see right
         */
        int right = 0;
        while (layout[row][column] != true) {
            right = right + 1;
            column = column + 1;
            if (column == size) {
                right = 0;
                break;
            }
        }
        /*
         * see down
         */
        int down = 0;
        while (layout[row][column] != true) {
            down = down + 1;
            row = row + 1;
            if (row == size) {
                down = 0;
                break;
            }
        }
        /*
         * see left
         */
        int left = 0;
        while (layout[row][column] != true) {
            left = left + 1;
            column = column - 1;
            if (column == -1) {
                left = 0;
                break;
            }
        }
        if (up == 0 && right == 0 && down == 0 && left == 0) {
            return -1;
        }
        if(up>=right && up>= down && up>=left){
            return 0;
        } else if(right>=up && right>=down && right>= left){
            return 1;
        } else if(down>=up && down>=right && down>=left){
            return 2;
        } else {
            return 3;
        }       
    }
}