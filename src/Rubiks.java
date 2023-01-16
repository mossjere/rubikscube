import java.util.Scanner;

public class Rubiks {
    public static void main(String args[])
    {
//        Cube cube = new Cube();

        Scanner scnr = new Scanner(System.in);
//        boolean run = true;
//        cube.scramble();


//        System.out.println(cube.scrambleCode);
//        cube.printCube();
//        while (run) {
//            cube.inputMove(scnr.nextLine());
//            cube.printCube();
//            run = !cube.checkSolved();
//        }
        Cube customeCube = new Cube(0);
        char faces[][] = new char[6][9];
        boolean confirmCube = false;
        while (!confirmCube)
        {
            System.out.println("To enter you cube enter the first letter of each color." +
                    "\nFor example if the row of the location asked for is white red blue enter: \"wrb\"");
            String top = "";
            System.out.println("Enter the back row(furthest from you) of the top face: ");
            top+=scnr.nextLine();
            System.out.println("Enter the middle row of the top face: ");
            top+=scnr.nextLine();
            System.out.println("Enter the front row (closest to you) of the top face: ");
            top+=scnr.nextLine();
            faces[5] = top.toUpperCase().toCharArray();

            String front = "";
            System.out.println("Enter the top row of the front face: ");
            front+=scnr.nextLine();
            System.out.println("Enter the middle row of the front face: ");
            front+=scnr.nextLine();
            System.out.println("Enter the bottom row of the front face: ");
            front+=scnr.nextLine();
            faces[0] = front.toUpperCase().toCharArray();

            String left = "";
            System.out.println("Enter the top row of the left face: ");
            left+=scnr.nextLine();
            System.out.println("Enter the middle row of the left face: ");
            left+=scnr.nextLine();
            System.out.println("Enter the bottom row of the left face: ");
            left+= scnr.nextLine();
            faces[3] = left.toUpperCase().toCharArray();

            String right = "";
            System.out.println("Enter the top row of the right face: ");
            right+=scnr.nextLine();
            System.out.println("Enter the middle row of the right face: ");
            right+=scnr.nextLine();
            System.out.println("Enter the bottom row of the right face: ");
            right+=scnr.nextLine();
            faces[1] = right.toUpperCase().toCharArray();

            String bottom = "";
            System.out.println("Enter the front row(closest to you) of the bottom face: ");
            bottom+=scnr.nextLine();
            System.out.println("Enter the middle row of the bottom face: ");
            bottom+=scnr.nextLine();
            System.out.println("Enter the back row(furthest from you) of the bottom face: ");
            bottom+=scnr.nextLine();
            faces[4] = bottom.toUpperCase().toCharArray();

            String back = "";
            System.out.println("Keeping the top facing up Enter the top row on the back of the cube: ");
            back+=scnr.nextLine();
            System.out.println("Enter the middle row on the back of the cube: ");
            back+=scnr.nextLine();
            System.out.println("Enter the bottom row on the back of the cube: ");
            back+=scnr.nextLine();
            faces[2] = back.toUpperCase().toCharArray();

            customeCube.createCube(faces);
            customeCube.printCube();
            System.out.println("Is this what your cube looks like(y/n): ");
            String answer = scnr.nextLine();
            if(answer.toUpperCase().equals("Y"))
            {
                confirmCube = true;
            }
        }
//        cube.printCube();
//        cube.oldPachmann();
//        System.out.println(cube.scrambleCode + "\n" + cube.solveCode);

        customeCube.oldPachmann();
        System.out.println("The solve code for the cube is: " + customeCube.solveCode);
    }
}
