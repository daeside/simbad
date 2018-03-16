package algernon.subsumption.demo;

import algernon.subsumption.Behavior;
import algernon.subsumption.Sensors;
import algernon.subsumption.Velocities;

public class LightSeeking extends Behavior {

   private static final double LUMINANCE_SEEKING_MIN = 0.1;

   public LightSeeking(Sensors sensors) {
      super(sensors);
   }

   @Override
   public Velocities act() {
      float llum = getSensors().getLightSensorLeft().getAverageLuminance();
      float rlum = getSensors().getLightSensorRight().getAverageLuminance();
      double translationalVelocity = 0.5 / (llum + rlum);
      double rotationalVelocity = (llum - rlum) * Math.PI / 4;

      return new Velocities(translationalVelocity, rotationalVelocity);
   }

   @Override
   public boolean isActive() {
      float llum = getSensors().getLightSensorLeft().getAverageLuminance();
      float rlum = getSensors().getLightSensorRight().getAverageLuminance();
      double luminance = (llum + rlum) / 2.0;

      return luminance > LUMINANCE_SEEKING_MIN;
   }

   @Override
   public String toString() {
      return "[LightSeeking: " + super.toString() + "]";
   }
}
