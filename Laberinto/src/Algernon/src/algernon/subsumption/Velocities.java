package algernon.subsumption;

public class Velocities {

   private double translationalVelocity;
   private double rotationalVelocity;

   public Velocities(double translationalVelocity, double rotationalVelocity) {
      this.translationalVelocity = translationalVelocity;
      this.rotationalVelocity = rotationalVelocity;
   }

   double getTranslationalVelocity() {
      return translationalVelocity;
   }

   double getRotationalVelocity() {
      return rotationalVelocity;
   }

   @Override
   public String toString() {
      return "[Velocities: translationalVelocity=" + translationalVelocity
            + ", rotationalVelocity=" + rotationalVelocity + "]";
   }
}
