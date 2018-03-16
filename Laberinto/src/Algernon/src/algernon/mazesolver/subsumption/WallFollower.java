package algernon.mazesolver.subsumption;

import simbad.gui.Simbad;
import algernon.mazesolver.Maze;
import algernon.mazesolver.MazeEnvironmentDescription;

public class WallFollower {

   public static void main(String[] args) {
      WallFollower wallFollower = new WallFollower();
      wallFollower.runMaze();
   }
   public void runMaze() {
      boolean mazeRows[][] = {
          { true, true, true, true, false },
          { true, false, false, true, true, true },
          { false, true, false, false, false },
          { true, true, false, true, false, true },
          { false, false, false, false, false },
          { true, true, true, false, true, true },
          { false, true, true, false, false },
          { true, false, false, true, true, true },
          { true, true, false, false, true },
          { false, false, false, true, false, true },
          { true, true, true, true, true }};
       
      MazeEnvironmentDescription mazeEnvironmentDescription = new MazeEnvironmentDescription(
            new Maze(mazeRows));
      algernon.subsumption.BehaviorBasedAgent wallFollowingAgent = new algernon.subsumption.BehaviorBasedAgent(
            mazeEnvironmentDescription.getStartPos(), "Wall Follower", 4, false);

      initBehaviorBasedAgent(wallFollowingAgent);

      mazeEnvironmentDescription.add(wallFollowingAgent);
      Simbad frame = new Simbad(mazeEnvironmentDescription, false);

      System.out.println("frame: " + frame);
   }

   private void initBehaviorBasedAgent(
         algernon.subsumption.BehaviorBasedAgent behaviorBasedAgent) {
      algernon.subsumption.Sensors sensors = behaviorBasedAgent.getSensors();
      algernon.subsumption.Behavior[] behaviors = { new ReachGoal(sensors),
            new TurnLeft(sensors), new TurnRight(sensors),
            new GoStraightAlways(sensors) };
      boolean subsumes[][] = { { false, true, true, true },
            { false, false, true, true }, { false, false, false, true },
            { false, false, false, false } };
      
     /*
      
      { { false, true, true, true },
            { false, false, true, true }, { false, false, false, true },
            { false, false, false, false } };

       */
     
      behaviorBasedAgent.initBehaviors(behaviors, subsumes);
   }

   @Override
   public String toString() {
      return "[WallFollower: " + super.toString() + "]";
   }
}
