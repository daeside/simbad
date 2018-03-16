package algernon.subsumption;

import simbad.sim.LightSensor;
import simbad.sim.RangeSensorBelt;

public class Sensors {

   private RangeSensorBelt sonars, bumpers;
   private LightSensor lightSensorLeft;
   private LightSensor lightSensorRight;

   public Sensors(RangeSensorBelt sonars, RangeSensorBelt bumpers,
         LightSensor lightSensorLeft, LightSensor rightSensorRight) {
      this(sonars, bumpers);
      this.lightSensorLeft = lightSensorLeft;
      this.lightSensorRight = rightSensorRight;
   }

   public Sensors(RangeSensorBelt sonars, RangeSensorBelt bumpers) {
      this.sonars = sonars;
      this.bumpers = bumpers;
   }

   public RangeSensorBelt getSonars() {
      return sonars;
   }

   public RangeSensorBelt getBumpers() {
      return bumpers;
   }

   public LightSensor getLightSensorLeft() {
      return lightSensorLeft;
   }

   public LightSensor getLightSensorRight() {
      return lightSensorRight;
   }

   @Override
   public String toString() {
      return "[Sensors: sonars=" + sonars + ", bumpers=" + bumpers
            + ", lightSensorLeft=" + lightSensorLeft + ", lightSensorRight="
            + lightSensorRight + "]";
   }
}
