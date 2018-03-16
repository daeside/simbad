package algernon.subsumption.demo;

import algernon.subsumption.Behavior;
import algernon.subsumption.Sensors;
import algernon.subsumption.Velocities;

public class StraightLine extends Behavior {

   public StraightLine(Sensors sensors) {
      super(sensors);
   }

   @Override
   public Velocities act() {
      return new Velocities(0.8, 0.0);
   }

   @Override
   public boolean isActive() {
      return true;
   }

   @Override
   public String toString() {
      return "[StraightLine: " + super.toString() + "]";
   }
}
