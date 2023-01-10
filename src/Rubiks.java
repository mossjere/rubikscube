import java.util.Scanner;

public class Rubiks {
    public static void main(String args[])
    {
        Cube cube = new Cube();
//        cube.u();
//        cube.r();
//        cube.r_();
//        cube.l();
//        cube.l_();
//        cube.u();
//        cube.d();
//        cube.u_();
//        cube.d_();
//        cube.rotateCubeL();
////        cube.rotateCubeU();
//        cube.r();
//        cube.u();
//        cube.rotateCubeD();
//        cube.d();

//        cube.scramble();
//        System.out.println(cube.scrambleCode);
        Scanner scnr = new Scanner(System.in);
        boolean run = true;
        while (run) {
            cube.inputMove(scnr.nextLine());
            cube.printCube();
        }
    }
}
