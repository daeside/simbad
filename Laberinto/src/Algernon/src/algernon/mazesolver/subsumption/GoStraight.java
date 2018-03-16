package algernon.mazesolver.subsumption;

import algernon.subsumption.Sensors;
import algernon.subsumption.Velocities;

public abstract class GoStraight extends algernon.subsumption.Behavior {

   public GoStraight(Sensors sensors) {
      super(sensors);
   }

   @Override
   public Velocities act() {
      double rotationalVelocity = 0.0;

      return new Velocities(TRANSLATIONAL_VELOCITY, rotationalVelocity);
   }

   @Override
   abstract public boolean isActive();

   @Override
   public String toString() {
      return "[GoStraight: " + super.toString() + "]";
   }
}
