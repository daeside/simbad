/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author Administrador
 */



import simbad.gui.Simbad;
import simbad.sim.*;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;


/**
  Derivate your own code from this example.
 */


public class JavaApplication1 {

    /** Describe the robot */
    static public class Robot extends Agent {

        RangeSensorBelt sonars;
        CameraSensor camera;

        public Robot(Vector3d position, String name) {
            super(position, name);
            // Add camera
            camera = RobotFactory.addCameraSensor(this);
            // Add sonars
            sonars = RobotFactory.addSonarBeltSensor(this);
        }

        /** This method is called by the simulator engine on reset. */
        public void initBehavior() {
            // nothing particular in this case
        }

        /** This method is call cyclically (20 times per second)  by the simulator engine. */
        public void performBehavior() {

            // progress at 0.5 m/s
            setTranslationalVelocity(0.5);
            // frequently change orientation
            if ((getCounter() % 100) == 0)
                setRotationalVelocity(Math.PI / 2 * (0.5 - Math.random()));

            // print front sonar every 100 frames
            if (getCounter() % 100 == 0)
                System.out
                        .println("Sonar num 0  = " + sonars.getMeasurement(0));

        }
    }

    /** Describe the environement */
    static public class MyEnv extends EnvironmentDescription {
        public MyEnv() {
            light1IsOn = true;
            light2IsOn = false;
            // Muros principales
            Wall w1 = new Wall(new Vector3d(9, 0, 0), 18, 2, this);
            w1.rotate90(1);
            add(w1);
            Wall w2 = new Wall(new Vector3d(-9, 0, -2), 15, 2, this);
            w2.rotate90(1);
            add(w2);
            Wall w3 = new Wall(new Vector3d(0, 0, 9), 19, 2, this);
            add(w3);
            Wall w4 = new Wall(new Vector3d(-2, 0, -9), 15, 2, this);
            add(w4);
            // termina muros principales
            //Wall w5 = new Wall(new Vector3d(x, y, z), largo, alto, this);
            Wall w5 = new Wall(new Vector3d(-7, 0, 5), 4, 1, this);
            add(w5);
            Wall w6 = new Wall(new Vector3d(5, 0, 7), 4, 1, this);
            add(w6);
            w6.rotate90(1);
            Wall w7 = new Wall(new Vector3d(2, 0, 5), 6, 1, this);
            add(w7);
            Wall w8 = new Wall(new Vector3d(-6, 0, 2), 7, 1, this);
            add(w8);
            Wall w9 = new Wall(new Vector3d(6, 0, 2), 6, 1, this);//sassa
            add(w9);
            Wall w10 = new Wall(new Vector3d(3, 0, -1), 6, 1, this);
            add(w10);
            w10.rotate90(1);
            Wall w11 = new Wall(new Vector3d(2, 0, -1), 2, 1, this);
            add(w11);
            Wall w12 = new Wall(new Vector3d(-1, 0, -4), 8, 1, this);
            add(w12);
            Wall w13 = new Wall(new Vector3d(-5, 0, -3), 2, 1, this);
            add(w13);
            w13.rotate90(1);
            Wall w14 = new Wall(new Vector3d(5, 0, -6), 6, 1, this);
            add(w14);
            w14.rotate90(1);
            
            add(new Robot(new Vector3d(0, 0, 0), "robot 1"));

        }
    }

    public static void main(String[] args) {
        // request antialising
        System.setProperty("j3d.implicitAntialiasing", "true");
        // create Simbad instance with given environment
        Simbad frame = new Simbad(new MyEnv(), false);
    }

} 