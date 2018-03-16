package algernon.subsumption;

import javax.vecmath.Vector3d;

import simbad.sim.Agent;
import simbad.sim.CameraSensor;
import simbad.sim.LightSensor;
import simbad.sim.RangeSensorBelt;
import simbad.sim.RobotFactory;

public class BehaviorBasedAgent extends Agent {

   private Behavior[] behaviors;
   private boolean suppresses[][];
   private int currentBehaviorIndex;
   private Sensors sensors;

   public BehaviorBasedAgent(Vector3d position, String name, int sensorCount,
         boolean addLightSensors) {
      super(position, name);
      RangeSensorBelt bumpers = RobotFactory.addBumperBeltSensor(this,
            sensorCount);
      RangeSensorBelt sonars = RobotFactory.addSonarBeltSensor(this,
            sensorCount);
      if (addLightSensors) {
         LightSensor lightSensorLeft = RobotFactory.addLightSensorLeft(this);
         LightSensor lightSensorRight = RobotFactory.addLightSensorRight(this);
         sensors = new Sensors(sonars, bumpers, lightSensorLeft,
               lightSensorRight);
      } else {
         sensors = new Sensors(sonars, bumpers);
      }
      CameraSensor camera = RobotFactory.addCameraSensor(this);
      System.out.println("camera: " + camera);
   }

   public void initBehaviors(Behavior[] behaviors,
         boolean subsumptionRelationships[][]) {
      this.behaviors = behaviors;
      this.suppresses = subsumptionRelationships;
   }

   @Override
   protected void initBehavior() {
      currentBehaviorIndex = 0;
   }

   @Override
   protected void performBehavior() {
      boolean isActive[] = new boolean[behaviors.length];
      for (int i = 0; i < isActive.length; i++) {
         isActive[i] = behaviors[i].isActive();
      }
      boolean ranABehavior = false;
      while (!ranABehavior) {
         boolean runCurrentBehavior = isActive[currentBehaviorIndex];
         if (runCurrentBehavior) {
            for (int i = 0; i < suppresses.length; i++) {
               if (isActive[i] && suppresses[i][currentBehaviorIndex]) {
                  runCurrentBehavior = false;

                  break;
               }
            }
         }

         if (runCurrentBehavior) {
            if (currentBehaviorIndex < behaviors.length) {
               Velocities newVelocities = behaviors[currentBehaviorIndex].act();
               this.setTranslationalVelocity(newVelocities
                     .getTranslationalVelocity());
               this
                     .setRotationalVelocity(newVelocities
                           .getRotationalVelocity());
            }
            ranABehavior = true;
         }

         if (behaviors.length > 0) {
            currentBehaviorIndex = (currentBehaviorIndex + 1)
                  % behaviors.length;
         }
      }
   }

   public Sensors getSensors() {
      return sensors;
   }

   @Override
   public String toString() {
      return "[BehaviorBasedAgent: behaviors=" + behaviors + ", suppresses="
            + suppresses + ", currentBehaviorIndex=" + currentBehaviorIndex
            + ", sensors=" + sensors + ", " + super.toString() + "]";
   }
}
