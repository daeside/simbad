package algernon.mazesolver;

import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;

import simbad.sim.Box;
import simbad.sim.EnvironmentDescription;

public class MazeEnvironmentDescription extends EnvironmentDescription {
   private static final double SCALE_FACTOR = 1.5;

   public MazeEnvironmentDescription(Maze maze) {
      Vector3f vertical = new Vector3f(0.25f, 0.5f,
            (float) (SCALE_FACTOR * 1.0f));
      Vector3f horizontal = new Vector3f((float) (SCALE_FACTOR * 1.0f), 0.5f,
            0.25f);
      boolean rows[][] = maze.getRows();
      double trans = SCALE_FACTOR * (-rows[0].length / 2.0);
      double xTrans = trans;
      double zTrans = trans;
      for (int i = 0; i < rows.length; i++) {
         int row = i / 2;
         if (i % 2 == 0) {
            for (int j = 0; j < rows[i].length; j++) {
               if (rows[i][j]) {
                  Vector3d wallLoc = new Vector3d(SCALE_FACTOR * row + xTrans,
                        0.0, -SCALE_FACTOR * (-(0.5 + j)) + zTrans);
                  add(new Box(wallLoc, vertical, this));
               }
            }
         } else {
            for (int j = 0; j < rows[i].length; j++) {
               if (rows[i][j]) {
                  Vector3d wallLoc = new Vector3d(SCALE_FACTOR * (0.5 + row)
                        + xTrans, 0.0, -SCALE_FACTOR * (-j) + zTrans);
                  add(new Box(wallLoc, horizontal, this));
               }
            }
         }
      }
   }

   public Vector3d getStartPos() {
     return new Vector3d(-SCALE_FACTOR * 2.5, 0, 3);
   }
   @Override
   public String toString() {
      return "[MazeEnvironmentDescription: " + super.toString() + "]";
   }
}
