package algernon.subsumption.demo;

import java.util.Random;

import algernon.subsumption.Behavior;
import algernon.subsumption.Sensors;
import algernon.subsumption.Velocities;

public class Wandering extends Behavior {

   private static final double WANDERING_PROBABILITY = 0.01;
   private Random random;

   public Wandering(Sensors sensors) {
      super(sensors);

      random = new Random();
   }

   @Override
   public Velocities act() {
      return new Velocities(0.8, random.nextDouble() * 2 * Math.PI);
   }

   @Override
   public boolean isActive() {
      return random.nextDouble() < WANDERING_PROBABILITY;
   }

   @Override
   public String toString() {
      return "[Wandering: WANDERING_PROBABILITY=" + WANDERING_PROBABILITY
            + ", " + super.toString() + "]";
   }
}
