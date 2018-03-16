package algernon.mazesolver.subsumption;

import simbad.sim.RangeSensorBelt;
import algernon.subsumption.Velocities;

public class TurnRight extends algernon.subsumption.Behavior {

   private int backingUpCount = 0;
   private int turningRightCount = 0;

   public TurnRight(algernon.subsumption.Sensors sensors) {
      super(sensors);
   }

   @Override
   public Velocities act() {
      if (backingUpCount > 0) {
         backingUpCount--;

         return new Velocities(-TRANSLATIONAL_VELOCITY, 0.0);
      } else {
         turningRightCount--;

         return new Velocities(0.0, -Math.PI / 2);
      }
   }
   
   @Override
   public boolean isActive() {
      if (turningRightCount > 0) {
         return true;
      }

      RangeSensorBelt bumpers = getSensors().getBumpers();
      if (bumpers.hasHit(0)) {
         backingUpCount = 10;
         turningRightCount = getRotationCount();

         return true;
      } else {
         return false;
      }
   }

   @Override
   public String toString() {
      return "[TurnRight: backingUpCount=" + backingUpCount
            + ", turningRightCount=" + turningRightCount + ", "
            + super.toString() + "]";
   }
}
