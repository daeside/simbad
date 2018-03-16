package algernon.subsumption.demo;

import algernon.subsumption.Behavior;
import algernon.subsumption.Sensors;
import algernon.subsumption.Velocities;
import simbad.sim.RangeSensorBelt;

public class Avoidance extends Behavior {

   public Avoidance(Sensors sensors) {
      super(sensors);
   }

   @Override
   public Velocities act() {
      double translationalVelocity = 0.8;
      double rotationalVelocity = 0;
      RangeSensorBelt sonars = getSensors().getSonars();
      double rotationalVelocityFactor = Math.PI / 32;
      if (getSensors().getBumpers().oneHasHit()) {
         translationalVelocity = -0.1;
         rotationalVelocity = Math.PI / 8
               - (rotationalVelocityFactor * Math.random());
      } else if (sonars.oneHasHit()) {

         double left = sonars.getFrontLeftQuadrantMeasurement();
         double right = sonars.getFrontRightQuadrantMeasurement();
         double front = sonars.getFrontQuadrantMeasurement();

         if ((front < 0.7) || (left < 0.7) || (right < 0.7)) {
            double maxRotationalVelocity = Math.PI / 4;
            if (left < right)
               rotationalVelocity = -maxRotationalVelocity
                     - (rotationalVelocityFactor * Math.random());
            else
               rotationalVelocity = maxRotationalVelocity
                     - (rotationalVelocityFactor * Math.random());
            translationalVelocity = 0;
         } else {
            rotationalVelocity = 0;
            translationalVelocity = 0.6;
         }
      }

      return new Velocities(translationalVelocity, rotationalVelocity);
   }

   @Override
   public boolean isActive() {
      return getSensors().getBumpers().oneHasHit()
            || getSensors().getSonars().oneHasHit();
   }

   @Override
   public String toString() {
      return "[Avoidance: " + super.toString() + "]";
   }
}
