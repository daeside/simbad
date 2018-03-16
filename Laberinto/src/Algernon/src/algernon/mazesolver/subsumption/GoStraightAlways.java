package algernon.mazesolver.subsumption;

import algernon.subsumption.Sensors;

public class GoStraightAlways extends GoStraight {

   public GoStraightAlways(Sensors sensors) {
      super(sensors);
   }

   @Override
   public boolean isActive() {
      return true;
   }

   @Override
   public String toString() {
      return "[GoStraightAlways: " + super.toString() + "]";
   }
}
