import java.util.Arrays;
import java.util.Random;

public class Cube {
    private enum color{
        green, red, blue, orange, yellow, white;
    }

    public String scrambleCode = "";

    Cube()
    {
        createCube();
    }

    //  5
    //3 0 1 2
    //  4
    //
    //  W
    //O G R B
    //  Y
    //
    /*
                876
                543
                210

                012
                345
                678

           012  012  012  012
           345  345  345  345
           678  678  345  345

                012
                345
                678
     */

    private color[][] cubeFaces = new color[6][9];
    private void createCube()
    {
        for(int i = 0; i < cubeFaces.length; i++)
        {
            Arrays.fill(cubeFaces[i], color.values()[i]);
        }
    }

    public void r()
    {
        color[] temp = new color[2];
        for(int i = 2; i < 9; i+=3) {
            temp[0] = cubeFaces[0][i];
            temp[1] = cubeFaces[5][i];
            cubeFaces[5][i] = temp[0];
            temp[0] = cubeFaces[2][((((i-2)/3)*-1)+2)*3];
            cubeFaces[2][((((i-2)/3)*-1)+2)*3] = temp[1];
            temp[1] = cubeFaces[4][i];
            cubeFaces[4][i] = temp[0];
            cubeFaces[0][i] = temp[1];
        }
        rotatingFaceClockWise(1);
    }

    public void l()
    {
        color[] temp = new color[2];
        for(int i = 0; i < 9; i+=3)
        {
            temp[0] = cubeFaces[0][i];
            temp[1] = cubeFaces[4][i];
            cubeFaces[4][i] = temp[0];
            temp[0] = cubeFaces[2][((((i/3)-2)/-1)*3)+2];
            cubeFaces[2][((((i/3)-2)/-1)*3)+2] = temp[1];
            temp[1] = cubeFaces[5][i];
            cubeFaces[5][i] = temp[0];
            cubeFaces[0][i] = temp[1];
        }
        rotatingFaceClockWise(3);
    }

    public void u()
    {
        color[] temp = new color[2];
        for(int i = 0; i < 3; i++) {
            temp[0] = cubeFaces[0][i];
            temp[1] = cubeFaces[3][i];
            cubeFaces[3][i] = temp[0];
            temp[0] = cubeFaces[2][i];
            cubeFaces[2][i] = temp[1];
            temp[1] = cubeFaces[1][i];
            cubeFaces[1][i] = temp[0];
            cubeFaces[0][i] = temp[1];
        }
        rotatingFaceClockWise(5);
    }

    public void d()
    {
        color[] temp = new color[2];
        for(int i = 6; i < 9; i++) {
            temp[0] = cubeFaces[0][i];
            temp[1] = cubeFaces[1][i];
            cubeFaces[1][i] = temp[0];
            temp[0] = cubeFaces[2][i];
            cubeFaces[2][i] = temp[1];
            temp[1] = cubeFaces[3][i];
            cubeFaces[3][i] = temp[0];
            cubeFaces[0][i] = temp[1];
        }
        rotatingFaceClockWise(4);
    }

    public void r_()
    {
        color[] temp = new color[2];
        for(int i = 2; i < 9; i+=3) {
            temp[0] = cubeFaces[0][i];
            temp[1] = cubeFaces[4][i];
            cubeFaces[4][i] = temp[0];
            temp[0] = cubeFaces[2][((((i-2)/3)*-1)+2)*3];
            cubeFaces[2][((((i-2)/3)*-1)+2)*3] = temp[1];
            temp[1] = cubeFaces[5][i];
            cubeFaces[5][i] = temp[0];
            cubeFaces[0][i] = temp[1];
        }
        rotatingFaceCounterClockWise(1);
    }

    public void l_()
    {
        color[] temp = new color[2];
        for(int i = 0; i < 9; i+=3) {
            temp[0] = cubeFaces[0][i];
            temp[1] = cubeFaces[5][i];
            cubeFaces[5][i] = temp[0];
            temp[0] = cubeFaces[2][((((i/3)-2)/-1)*3)+2];
            cubeFaces[2][((((i/3)-2)/-1)*3)+2] = temp[1];
            temp[1] = cubeFaces[4][i];
            cubeFaces[4][i] = temp[0];
            cubeFaces[0][i] = temp[1];
        }
        rotatingFaceCounterClockWise(3);
    }

    public void u_()
    {
        color[] temp = new color[2];
        for(int i = 0; i < 3; i++) {
            temp[0] = cubeFaces[0][i];
            temp[1] = cubeFaces[1][i];
            cubeFaces[1][i] = temp[0];
            temp[0] = cubeFaces[2][i];
            cubeFaces[2][i] = temp[1];
            temp[1] = cubeFaces[3][i];
            cubeFaces[3][i] = temp[0];
            cubeFaces[0][i] = temp[1];
        }
        rotatingFaceCounterClockWise(5);
    }

    public void d_()
    {
        color[] temp = new color[2];
        for(int i = 6; i < 9; i++) {
            temp[0] = cubeFaces[0][i];
            temp[1] = cubeFaces[3][i];
            cubeFaces[3][i] = temp[0];
            temp[0] = cubeFaces[2][i];
            cubeFaces[2][i] = temp[1];
            temp[1] = cubeFaces[1][i];
            cubeFaces[1][i] = temp[0];
            cubeFaces[0][i] = temp[1];
        }
        rotatingFaceCounterClockWise(4);
    }

    public void f()
    {
        rotateCubeR();
        l();
        rotateCubeL();
    }

    public void f_()
    {
        rotateCubeR();
        l_();
        rotateCubeL();
    }

    public void b()
    {
        rotateCubeR();
        r();
        rotateCubeL();
    }

    public void b_()
    {
        rotateCubeR();
        r_();
        rotateCubeL();
    }

    public void m()
    {
        r();
        l_();
        rotateCubeU();
    }

    public void m_()
    {
        r_();
        l();
        rotateCubeD();
    }

    public void e()
    {
        u();
        d_();
        rotateCubeL();
    }

    public void e_()
    {
        u_();
        d();
        rotateCubeR();
    }

    public void s()
    {
        rotateCubeR();
        m();
        rotateCubeL();
    }

    public void s_()
    {
        rotateCubeR();
        m_();
        rotateCubeL();
    }

    public void z()
    {
        rotateCubeR();
        rotateCubeU();
        rotateCubeL();
    }

    public void z_()
    {
        rotateCubeL();
        rotateCubeU();
        rotateCubeR();
    }

    public void uw()
    {
        d();
        rotateCubeR();
    }

    public void uw_()
    {
        d_();
        rotateCubeL();
    }

    public void dw()
    {
        u();
        rotateCubeL();
    }

    public void dw_()
    {
        u_();
        rotateCubeR();
    }

    public void rw()
    {
        l();
        rotateCubeD();
    }

    public void rw_()
    {
        l_();
        rotateCubeU();
    }

    public void lw()
    {
        r();
        rotateCubeU();
    }

    public void lw_()
    {
        r_();
        rotateCubeD();
    }

    public void fw()
    {
        b();
        z();
    }

    public void fw_()
    {
        b_();
        z_();
    }

    public void bw()
    {
        f();
        z_();
    }

    public void bw_()
    {
        f_();
        z();
    }

    public void tPerm()
    {
        r();
        u();
        r_();
        u_();
        r_();
        f();
        r();
        r();
        u_();
        r_();
        u_();
        r();
        u();
        r_();
        f_();
    }

    public void yPerm()
    {
        r();
        u_();
        r_();
        u_();
        r();
        u();
        r_();
        f_();
        r();
        u();
        r_();
        u_();
        r_();
        f();
        r();
    }

    public void rAlg()
    {
        r();
        u();
        r_();
        u_();
    }

    public void lAlg()
    {
        l_();
        u_();
        l();
        u();
    }

    public void inverseRAlg()
    {
        u();
        r();
        u_();
        r_();
    }

    public void inverseLAlg()
    {
        u_();
        l_();
        u();
        l();
    }

    private void rotatingFaceClockWise(int f)
    {
        /*
            012
            345
            678
                630
                741
                852
        */
        color[] tempFace = new color[9];
        for (int i = 0; i < 9; i++) {
            tempFace[i] = cubeFaces[f][i];
        }
        cubeFaces[f][0] = tempFace[6];
        cubeFaces[f][1] = tempFace[3];
        cubeFaces[f][2] = tempFace[0];
        cubeFaces[f][3] = tempFace[7];
        cubeFaces[f][5] = tempFace[1];
        cubeFaces[f][6] = tempFace[8];
        cubeFaces[f][7] = tempFace[5];
        cubeFaces[f][8] = tempFace[2];
    }

    private void rotatingFaceCounterClockWise(int f)
    {
              /*
        012
        345
        678
            258
            147
            036
         */
        color[] tempFace = new color[9];
        for (int i = 0; i < 9; i++) {
            tempFace[i] = cubeFaces[f][i];
        }
        cubeFaces[f][0] = tempFace[2];
        cubeFaces[f][1] = tempFace[5];
        cubeFaces[f][2] = tempFace[8];
        cubeFaces[f][3] = tempFace[1];
        cubeFaces[f][5] = tempFace[7];
        cubeFaces[f][6] = tempFace[0];
        cubeFaces[f][7] = tempFace[3];
        cubeFaces[f][8] = tempFace[6];
    }

    public void rotateCubeR()
    {
        color[][] tempFace = new color[2][9];
        for (int i = 0; i < 9; i++) {
            tempFace[0][i] = cubeFaces[0][i];
        }
        for (int i = 0; i < 9; i++) {
            tempFace[1][i] = cubeFaces[3][i];
            cubeFaces[3][i] = tempFace[0][i];
        }
        for (int i = 0; i < 9; i++) {
            tempFace[0][i] = cubeFaces[2][i];
            cubeFaces[2][i] = tempFace[1][i];
        }
        for (int i = 0; i < 9; i++) {
            tempFace[1][i] = cubeFaces[1][i];
            cubeFaces[1][i] = tempFace[0][i];
            cubeFaces[0][i] = tempFace[1][i];
        }
        rotatingFaceClockWise(5);
        rotatingFaceCounterClockWise(4);


    }

    public void rotateCubeL()
    {
        color[][] tempFace = new color[2][9];
        for (int i = 0; i < 9; i++) {
            tempFace[0][i] = cubeFaces[0][i];
        }
        for (int i = 0; i < 9; i++) {
            tempFace[1][i] = cubeFaces[1][i];
            cubeFaces[1][i] = tempFace[0][i];
        }
        for (int i = 0; i < 9; i++) {
            tempFace[0][i] = cubeFaces[2][i];
            cubeFaces[2][i] = tempFace[1][i];
        }
        for (int i = 0; i < 9; i++) {
            tempFace[1][i] = cubeFaces[3][i];
            cubeFaces[3][i] = tempFace[0][i];
            cubeFaces[0][i] = tempFace[1][i];
        }
        rotatingFaceClockWise(4);

        rotatingFaceCounterClockWise(5);

    }

    public void rotateCubeU()
    {
        color[][] tempFace = new color[2][9];
        for (int i = 0; i < 9; i++) {
            tempFace[0][i] = cubeFaces[0][i];
        }
        for (int i = 0; i < 9; i++) {
            tempFace[1][i] = cubeFaces[4][i];
            cubeFaces[4][i] = tempFace[0][i];
        }
        for (int i = 0; i < 9; i++) {
            tempFace[0][i] = cubeFaces[2][(i-8)*-1];
            cubeFaces[2][(i-8)*-1] = tempFace[1][i];
        }
        for (int i = 0; i < 9; i++) {
            tempFace[1][i] = cubeFaces[5][i];
            cubeFaces[5][i] = tempFace[0][i];
            cubeFaces[0][i] = tempFace[1][i];
        }
        rotatingFaceClockWise(3);
        rotatingFaceCounterClockWise(1);
    }

    public void rotateCubeD()
    {
        color[][] tempFace = new color[2][9];
        for (int i = 0; i < 9; i++) {
            tempFace[0][i] = cubeFaces[0][i];
        }
        for (int i = 0; i < 9; i++) {
            tempFace[1][i] = cubeFaces[5][i];
            cubeFaces[5][i] = tempFace[0][i];
        }
        for (int i = 0; i < 9; i++) {
            tempFace[0][i] = cubeFaces[2][8 - i];
            cubeFaces[2][8 - i] = tempFace[1][i];
        }
        for (int i = 0; i < 9; i++) {
            tempFace[1][i] = cubeFaces[4][i];
            cubeFaces[4][i] = tempFace[0][i];
            cubeFaces[0][i] = tempFace[1][i];
        }
        rotatingFaceClockWise(1);
        rotatingFaceCounterClockWise(3);
    }

    public void scramble()
    {
        Random rand = new Random();
        int iterations = rand.nextInt(8,20);
        for(int i = 0; i < iterations; i++)
        {
            //r,l,r_,l_,u,u_,d,d_,f,f_,b,b_,rotateR,rotateL,rotateU,rotateD
            int operation = rand.nextInt(16);
            switch (operation)
            {
                case 0:
                    r();
                    scrambleCode+="R";
                    break;
                case 1:
                    l();
                    scrambleCode+="L";
                    break;
                case 2:
                    r_();
                    scrambleCode+="R'";
                    break;
                case 3:
                    l_();
                    scrambleCode+="L'";
                    break;
                case 4:
                    u();
                    scrambleCode+="U";
                    break;
                case 5:
                    u_();
                    scrambleCode+="U'";
                    break;
                case 6:
                    d();
                    scrambleCode+="D";
                    break;
                case 7:
                    d_();
                    scrambleCode+="D'";
                    break;
                case 8:
                    f();
                    scrambleCode+="F";
                    break;
                case 9:
                    f_();
                    scrambleCode+="F'";
                    break;
                case 10:
                    b();
                    scrambleCode+="B";
                    break;
                case 11:
                    b_();
                    scrambleCode+="B'";
                    break;
                case 12:
                    rotateCubeR();
                    scrambleCode+="Y";
                    break;
                case 13:
                    rotateCubeL();
                    scrambleCode+="Y'";
                    break;
                case 14:
                    rotateCubeU();
                    scrambleCode+="X'";
                    break;
                case 15:
                    rotateCubeD();
                    scrambleCode+="X";
                    break;
            }
        }
    }

    public void inputMove(String move)
    {
        String[] moves = move.split(" ");
        for(int i = 0; i < moves.length; i++)
        {
            switch (moves[i].toUpperCase())
            {
                case "R":
                    r();
                    break;
                case "R'":
                    r_();
                    break;
                case "L":
                    l();
                    break;
                case "L'":
                    l_();
                    break;
                case "U":
                    u();
                    break;
                case "U'":
                    u_();
                    break;
                case "D" :
                    d();
                    break;
                case "D'":
                    d_();
                    break;
                case "F":
                    f();
                    break;
                case "F'":
                    f_();
                    break;
                case "B":
                    b();
                    break;
                case "B'":
                    b_();
                    break;
                case "X":
                    rotateCubeD();
                    break;
                case "X'":
                    rotateCubeU();
                    break;
                case "Y":
                    rotateCubeR();
                    break;
                case "Y'":
                    rotateCubeL();
                    break;
                case "RALG":
                    rAlg();
                    break;
                case "LALG":
                    lAlg();
                    break;
                case "IRALG":
                    inverseRAlg();
                    break;
                case "ILALG":
                    inverseLAlg();
                    break;
                case "TPERM":
                    tPerm();
                    break;
                case "YPERM":
                    yPerm();
                    break;
            }
        }
    }

    public void printCube()
    {
        // ⬜ \u2B1C
        // 🟧 \u1F7E7
        // 🟩 \u1F7E9
        // 🟥 \u1F7E5
        // 🟦 \u1F7E6
        // 🟨 \u1F7E8

        System.out.print("\t\t");
        for(int i = 0; i < 9; i++)
        {
            if(i%3==0 && i != 0)
            {
                System.out.print("\n\t\t");
            }
            System.out.print(getString(i, 5));
        }

        System.out.println("");
        for(int i = 0; i < 3; i++)
            System.out.print(getString(i, 3));
        System.out.print(" ");
        for(int i = 0; i < 3; i++)
            System.out.print(getString(i, 0));
        System.out.print(" ");
        for(int i = 0; i < 3; i++)
            System.out.print(getString(i, 1));
        System.out.print(" ");
        for(int i = 0; i < 3; i++)
            System.out.print(getString(i, 2));

        System.out.println("");
        for(int i = 3; i < 6; i++)
            System.out.print(getString(i, 3));
        System.out.print(" ");
        for(int i = 3; i < 6; i++)
            System.out.print(getString(i, 0));
        System.out.print(" ");
        for(int i = 3; i < 6; i++)
            System.out.print(getString(i, 1));
        System.out.print(" ");
        for(int i = 3; i < 6; i++)
            System.out.print(getString(i, 2));

        System.out.println("");
        for(int i = 6; i < 9; i++)
            System.out.print(getString(i, 3));
        System.out.print(" ");
        for(int i = 6; i < 9; i++)
            System.out.print(getString(i, 0));
        System.out.print(" ");
        for(int i = 6; i < 9; i++)
            System.out.print(getString(i, 1));
        System.out.print(" ");
        for(int i = 6; i < 9; i++)
            System.out.print(getString(i, 2));

        for(int i = 0; i < 9; i++)
        {
            if(i%3==0)
            {
                System.out.print("\n\t\t");
            }
            System.out.print(getString(i, 4));
        }
        System.out.println();

    }
    //  5
    //3 0 1 2
    //  4
    //
    //  W
    //O G R B
    //  Y
    //

    public String getString(int i, int j)
    {
        boolean locationValue = false;
        if(locationValue)
        return i + "";
        switch (cubeFaces[j][i])
        {
            case white:
                return "⬜";
            case orange:
                return "\uD83D\uDFE7";
            case green:
                return "\uD83D\uDFE9";
            case red:
                return "\uD83D\uDFE5";
            case blue:
                return "\uD83D\uDFE6";
            case yellow:
                return "\uD83D\uDFE8";
            default:
                return "";
        }
    }

}
