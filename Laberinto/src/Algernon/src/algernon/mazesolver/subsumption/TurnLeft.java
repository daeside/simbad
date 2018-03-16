package algernon.mazesolver.subsumption;

import simbad.sim.RangeSensorBelt;
import algernon.subsumption.Velocities;

public class TurnLeft extends algernon.subsumption.Behavior {

   private int preGoingForwardCount = 0;
   private int postGoingForwardCount = 0;
   private int turnLeftCount = 0;

   public TurnLeft(algernon.subsumption.Sensors sensors) {
      super(sensors);
   }

   @Override
   public Velocities act() {
      if (preGoingForwardCount > 0) {
         preGoingForwardCount--;

         return new Velocities(TRANSLATIONAL_VELOCITY, 0.0);
      } else if (turnLeftCount > 0) {
         turnLeftCount--;

         return new Velocities(0.0, Math.PI / 2);
      } else {
         postGoingForwardCount--;

         return new Velocities(TRANSLATIONAL_VELOCITY, 0.0);
      }
   }

   @Override
   public boolean isActive() {
      if (postGoingForwardCount > 0) {
         return true;
      }

      RangeSensorBelt sonars = getSensors().getSonars();
      if (sonars.getMeasurement(1) > 1.0) {
         preGoingForwardCount = 20;
         postGoingForwardCount = 40;
         turnLeftCount = getRotationCount();

         return true;
      } else {
         return false;
      }
   }

   @Override
   public String toString() {
      return "[TurnLeft: preGoingForwardCount=" + preGoingForwardCount
            + ", turnLeftCount=" + turnLeftCount + ", postGoingForwardCount="
            + postGoingForwardCount + ", " + super.toString() + "]";
   }
}