import java.util.List;

/**
 * Created by Ruobin Wang on 2020-01-05.
 */

//TODO incompleted
public class AmazonMininumHoursSolution {

    final static int TRAVERSED = 99;
    static int count = 0;

    int minimumHours(int rows, int columns, List<List<Integer>> grid)
    {
        return 0;
    }

    void traverseNode(int x, int y, int row, int column, List<List<Integer> > grid) {
        if ( x >= row || y >= column) return;
        if (grid.get(x).get(y)==1) {
            if (x-1>=0) {
                grid.get(x-1).set(y, 1);
            }
            if (x+1<row) {
                grid.get(x+1).set(y, 1);
            }
            if (y-1>=0) {
                grid.get(x).set(y-1, 1);
            }
            if (y+1<column) {
                grid.get(x).set(y+1, 1);
            }


            traverseNode(x, y+1, row, column, grid);
            traverseNode(x+1, y, row, column, grid);

        } else if (grid.get(x).get(y)==0) {
            grid.get(x).set(y, TRAVERSED);
            traverseNode(x, y+1, row, column, grid);
            traverseNode(x+1, y, row, column, grid);
        } else {
            return;
        }
    }


}
