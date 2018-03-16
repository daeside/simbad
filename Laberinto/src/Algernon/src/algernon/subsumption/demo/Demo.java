/*package algernon.subsumption.demo;

import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;

import simbad.gui.Simbad;
import simbad.sim.Arch;
import simbad.sim.Box;
import simbad.sim.EnvironmentDescription;
import simbad.sim.Wall;
import algernon.subsumption.Behavior;
import algernon.subsumption.BehaviorBasedAgent;
import algernon.subsumption.Sensors;

public class Demo {

   public static void main(String[] args) {
      Demo demo = new Demo();
    //  demo.runDemo();
   }

   public void runDemo() {
      EnvironmentDescription environmentDescription = new MyEnv();

      BehaviorBasedAgent redAgent1 = new BehaviorBasedAgent(new Vector3d(4, 0,
            4), "Red Agent 1", 12, true);
      BehaviorBasedAgent redAgent2 = new BehaviorBasedAgent(new Vector3d(4, 0,
            -4), "Red Agent 2", 12, true);
      BehaviorBasedAgent blueAgent1 = new BehaviorBasedAgent(new Vector3d(-4,
            0, 4), "Blue Agent 1", 12, true);
      BehaviorBasedAgent blueAgent2 = new BehaviorBasedAgent(new Vector3d(-4,
            0, -4), "Blue Agent 2", 12, true);

      Color3f red = new Color3f(0.8f, 0, 0);
      redAgent1.setColor(red);
      redAgent2.setColor(red);
      Color3f blue = new Color3f(0, 0, 0.8f);
      blueAgent1.setColor(blue);
      blueAgent2.setColor(blue);

      initBehaviorBasedAgent(redAgent1);
      initBehaviorBasedAgent(redAgent2);
      initBehaviorBasedAgent(blueAgent1);
      initBehaviorBasedAgent(blueAgent2);

      environmentDescription.add(redAgent1);
      environmentDescription.add(redAgent2);
      environmentDescription.add(blueAgent1);
      environmentDescription.add(blueAgent2);

      Simbad frame = new Simbad(environmentDescription, false);
      System.out.println("frame: " + frame);
   }

   private void initBehaviorBasedAgent(BehaviorBasedAgent behaviorBasedAgent) {
      Sensors sensors = behaviorBasedAgent.getSensors();
      Behavior[] behaviors = { new Avoidance(sensors),
            new LightSeeking(sensors), new Wandering(sensors),
            new StraightLine(sensors), };
      boolean subsumes[][] = { { false, true, true, true },
            { false, false, true, true }, { false, false, false, true },
            { false, false, false, false } };
      behaviorBasedAgent.initBehaviors(behaviors, subsumes);
   }

   static public class MyEnv extends EnvironmentDescription {
      public MyEnv() {
         light1IsOn = true;
         light2IsOn = false;
         Wall w1 = new Wall(new Vector3d(9, 0, 0), 19, 1, this);
         w1.rotate90(1);
         add(w1);
         Wall w2 = new Wall(new Vector3d(-9, 0, 0), 19, 2, this);
         w2.rotate90(1);
         add(w2);
         Wall w3 = new Wall(new Vector3d(0, 0, 9), 19, 1, this);
         add(w3);
         Wall w4 = new Wall(new Vector3d(0, 0, -9), 19, 2, this);
         add(w4);

         Box b1 = new Box(new Vector3d(-3, 0, -3), new Vector3f(1, 1, 1), this);
         add(b1);
         add(new Arch(new Vector3d(3, 0, -3), this));

         light1SetPosition(6, .7f, 5);
         ambientLightColor = black;
         light1Color = white;
         light2Color = white;
         wallColor =black;
         archColor = green;
         boxColor = red;
         floorColor = white;
         backgroundColor = black;
      }
   }
}
*/