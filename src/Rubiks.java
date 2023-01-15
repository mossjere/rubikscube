import java.util.Scanner;

public class Rubiks {
    public static void main(String args[])
    {
        Cube cube = new Cube();

        Scanner scnr = new Scanner(System.in);
        boolean run = true;
        cube.scramble();
//        System.out.println(cube.scrambleCode);
//        cube.printCube();
//        while (run) {
//            cube.inputMove(scnr.nextLine());
//            cube.printCube();
//            run = !cube.checkSolved();
//        }
        cube.printCube();
        cube.oldPachmann();
        System.out.println(cube.scrambleCode + "\n" + cube.solveCode);
    }
}
