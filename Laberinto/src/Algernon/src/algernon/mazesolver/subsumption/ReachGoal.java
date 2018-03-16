package algernon.mazesolver.subsumption;

import algernon.subsumption.Sensors;
import simbad.sim.RangeSensorBelt;
import algernon.subsumption.Velocities;

public class ReachGoal extends algernon.subsumption.Behavior {

   public ReachGoal(Sensors sensors) {
      super(sensors);
   }

   @Override
   public Velocities act() {
      System.out.println("Reached goal!!!");

      return new Velocities(0.0, 0.0);
   }

   @Override
   public boolean isActive() {
      RangeSensorBelt sonars = getSensors().getSonars();

      double clearDistance = 1.2;
      return sonars.getMeasurement(0) > clearDistance
            && sonars.getMeasurement(1) > clearDistance
            && sonars.getMeasurement(3) > clearDistance
            && sonars.getMeasurement(2) > clearDistance;
   }

   @Override
   public String toString() {
      return "[ReachGoal: " + super.toString() + "]";
   }
}
