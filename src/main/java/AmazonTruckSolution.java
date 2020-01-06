
import java.util.List;


/**
 * Created by Ruobin Wang on 2020-01-04.
 */
public class AmazonTruckSolution
{

    final static int TRAVERSED = 99;
    static int count = 0;
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    int numberAmazonTreasureTrucks(int rows, int column,
                                   List<List<Integer> > grid)
    {

        traverseNode(0, 0, rows, column, grid);

        return count;
    }

    void traverseNode(int x, int y, int row, int column, List<List<Integer> > grid) {
        if ( x >= row || y >= column) return;
        if (grid.get(x).get(y)==1) {
            if (shouldBeCounted(x, y, grid)) count++;
            traverseNode(x, y+1, row, column, grid);
            traverseNode(x+1, y, row, column, grid);
            grid.get(x).set(y, TRAVERSED);
        } else if (grid.get(x).get(y)==0) {
            grid.get(x).set(y, TRAVERSED);
            traverseNode(x, y+1, row, column, grid);
            traverseNode(x+1, y, row, column, grid);
        } else {
            return;
        }
    }

    boolean shouldBeCounted(int row, int column, List<List<Integer> > grid) {
        if (column == 0 && grid.get(row).get(column) == 1 &&
                (row == 0 || grid.get(row-1).get(column) != 1))
            return true;
        if (row == 0 && grid.get(row).get(column) == 1 &&
                grid.get(row).get(column-1) != 1)
            return true;
        if (grid.get(row).get(column) == 1 && grid.get(row).get(column-1) != 1 &&
                grid.get(row-1).get(column) != 1) {
            return true;
        }
        return false;
    }
}