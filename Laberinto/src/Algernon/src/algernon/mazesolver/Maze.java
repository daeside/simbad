package algernon.mazesolver;

public class Maze {

   private boolean[][] rows;

   public Maze(boolean[][] rows) {
      this.rows = rows;
   }

   public boolean[][] getRows() {
      return rows;
   }

   @Override
   public String toString() {
      return "[Maze: " + rows + "]";
   }
}
