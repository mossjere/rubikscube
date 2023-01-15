import java.util.Arrays;
import java.util.Random;

public class Cube {
    private enum color{
        green, red, blue, orange, yellow, white
    }

    public String scrambleCode = "";
    public String solveCode = "";
    public boolean edgesFinished = false;
    public boolean cornersFinished = false;

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

    private final color[][] cubeFaces = new color[6][9];
    private void createCube()
    {
        for(int i = 0; i < cubeFaces.length; i++)
        {
            Arrays.fill(cubeFaces[i], color.values()[i]);
        }
    }

    public void r()
    {
        verticalFaceRotation(true, false);
        rotatingFaceClockWise(1);
    }

    public void l()
    {
        verticalFaceRotation(false, true);
        rotatingFaceClockWise(3);
    }

    public void u()
    {
        horizontalFaceRotation(0,3,3,1);
        rotatingFaceClockWise(5);
    }

    public void d()
    {
        horizontalFaceRotation(6,9,1,3);
        rotatingFaceClockWise(4);
    }

    public void r_()
    {
        verticalFaceRotation(false, false);
        rotatingFaceCounterClockWise(1);
    }

    public void l_()
    {
        verticalFaceRotation(true, true);
        rotatingFaceCounterClockWise(3);
    }

    public void u_()
    {
        horizontalFaceRotation(0,3,1,3);
        rotatingFaceCounterClockWise(5);
    }

    public void d_()
    {
        horizontalFaceRotation(6,9,3,1);
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

    private void horizontalFaceRotation(int start, int end, int x, int y)
    {
        color[] temp = new color[2];
        for(int i = start; i < end; i++) {
            temp[0] = cubeFaces[0][i];
            temp[1] = cubeFaces[x][i];
            cubeFaces[x][i] = temp[0];
            temp[0] = cubeFaces[2][i];
            cubeFaces[2][i] = temp[1];
            temp[1] = cubeFaces[y][i];
            cubeFaces[y][i] = temp[0];
            cubeFaces[0][i] = temp[1];
        }
    }

    private void verticalFaceRotation(boolean topFirst, boolean leftSide)
    {
        int x = topFirst ? 5 : 4;
        int y = topFirst ? 4 : 5;
        color[] temp = new color[2];
        for(int i = leftSide ? 0 : 2; i < 9; i+=3) {
            temp[0] = cubeFaces[0][i];
            temp[1] = cubeFaces[x][i];
            cubeFaces[x][i] = temp[0];
            if(leftSide)
            {
                temp[0] = cubeFaces[2][((((i/3)-2)/-1)*3)+2];
                cubeFaces[2][((((i/3)-2)/-1)*3)+2] = temp[1];
            }
            else
            {
                temp[0] = cubeFaces[2][((((i-2)/3)*-1)+2)*3];
                cubeFaces[2][((((i-2)/3)*-1)+2)*3] = temp[1];
            }
            temp[1] = cubeFaces[y][i];
            cubeFaces[y][i] = temp[0];
            cubeFaces[0][i] = temp[1];
        }
    }

    private void rotatingFaceClockWise(int face)
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
        System.arraycopy(cubeFaces[face], 0, tempFace, 0, 9);
        cubeFaces[face][0] = tempFace[6];
        cubeFaces[face][1] = tempFace[3];
        cubeFaces[face][2] = tempFace[0];
        cubeFaces[face][3] = tempFace[7];
        cubeFaces[face][5] = tempFace[1];
        cubeFaces[face][6] = tempFace[8];
        cubeFaces[face][7] = tempFace[5];
        cubeFaces[face][8] = tempFace[2];
    }

    private void rotatingFaceCounterClockWise(int face)
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
        System.arraycopy(cubeFaces[face], 0, tempFace, 0, 9);
        cubeFaces[face][0] = tempFace[2];
        cubeFaces[face][1] = tempFace[5];
        cubeFaces[face][2] = tempFace[8];
        cubeFaces[face][3] = tempFace[1];
        cubeFaces[face][5] = tempFace[7];
        cubeFaces[face][6] = tempFace[0];
        cubeFaces[face][7] = tempFace[3];
        cubeFaces[face][8] = tempFace[6];
    }

    public void rotateCubeR()
    {
        color[][] tempFace = new color[2][9];
        System.arraycopy(cubeFaces[0], 0, tempFace[0], 0, 9);
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
        System.arraycopy(cubeFaces[0], 0, tempFace[0], 0, 9);
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
        System.arraycopy(cubeFaces[0], 0, tempFace[0], 0, 9);
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
        System.arraycopy(cubeFaces[0], 0, tempFace[0], 0, 9);
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
        StringBuilder stringBuilder = new StringBuilder(scrambleCode);
        for(int i = 0; i < iterations; i++)
        {
            //r,l,r_,l_,u,u_,d,d_,f,f_,b,b_,rotateR,rotateL,rotateU,rotateD
            int operation = rand.nextInt(16);
            switch (operation) {
                case 0 -> {
                    r();
                    stringBuilder.append("R");
                }
                case 1 -> {
                    l();
                    stringBuilder.append("L");
                }
                case 2 -> {
                    r_();
                    stringBuilder.append("R'");
                }
                case 3 -> {
                    l_();
                    stringBuilder.append("L'");
                }
                case 4 -> {
                    u();
                    stringBuilder.append("U");
                }
                case 5 -> {
                    u_();
                    stringBuilder.append("U'");
                }
                case 6 -> {
                    d();
                    stringBuilder.append("D");
                }
                case 7 -> {
                    d_();
                    stringBuilder.append("D'");
                }
                case 8 -> {
                    f();
                    stringBuilder.append("F");
                }
                case 9 -> {
                    f_();
                    stringBuilder.append("F'");
                }
                case 10 -> {
                    b();
                    stringBuilder.append("B");
                }
                case 11 -> {
                    b_();
                    stringBuilder.append("B'");
                }
                case 12 -> {
                    rotateCubeR();
                    stringBuilder.append("Y");
                }
                case 13 -> {
                    rotateCubeL();
                    stringBuilder.append("Y'");
                }
                case 14 -> {
                    rotateCubeU();
                    stringBuilder.append("X'");
                }
                case 15 -> {
                    rotateCubeD();
                    stringBuilder.append("X");
                }
            }
        }
        scrambleCode+=stringBuilder.toString();
    }

    public void inputMove(String move)
    {
        String[] moves = move.split(" ");
        for (String s : moves) {
            switch (s.toUpperCase()) {
                case "R" -> r();
                case "R'" -> r_();
                case "L" -> l();
                case "L'" -> l_();
                case "U" -> u();
                case "U'" -> u_();
                case "D" -> d();
                case "D'" -> d_();
                case "F" -> f();
                case "F'" -> f_();
                case "B" -> b();
                case "B'" -> b_();
                case "X" -> rotateCubeD();
                case "X'" -> rotateCubeU();
                case "Y" -> rotateCubeR();
                case "Y'" -> rotateCubeL();
                case "RALG" -> rAlg();
                case "LALG" -> lAlg();
                case "IRALG" -> inverseRAlg();
                case "ILALG" -> inverseLAlg();
                case "TPERM" -> tPerm();
                case "YPERM" -> yPerm();
                case "M" -> m();
                case "M'" -> m_();
                case "E" -> e();
                case "E'" -> e_();
                case "S" -> s();
                case "S'" -> s_();
                case "Z" -> z();
                case "Z'" -> z_();
                case "UW", "WU" -> uw();
                case "UW'", "WU'" -> uw_();
                case "DW", "WD" -> dw();
                case "DW'", "WD'" -> dw_();
                case "RW", "WR" -> rw();
                case "RW'", "WR'" -> rw_();
                case "LW", "WL" -> lw();
                case "LW'", "WL'" -> lw_();
                case "FW", "WF" -> fw();
                case "FW'", "WF'" -> fw_();
                case "BW", "WB" -> bw();
                case "BW'", "WB'" -> bw_();
                case "R2" -> {
                    r();
                    r();
                }
                case "L2" -> {
                    l();
                    l();
                }
                case "U2" -> {
                    u();
                    u();
                }
                case "D2" -> {
                    d();
                    d();
                }
                case "F2" -> {
                    f();
                    f();
                }
                case "B2" -> {
                    b();
                    b();
                }
                case "RALG3" -> {
                    rAlg();
                    rAlg();
                    rAlg();
                }
                case "LALG3" -> {
                    lAlg();
                    lAlg();
                    lAlg();
                }
                case "Y2" -> {
                    rotateCubeR();
                    rotateCubeR();
                }
                case "X2" -> {
                    rotateCubeU();
                    rotateCubeU();
                }
            }
        }
    }

    /**
     * Returns true if cube is solved
     */
    public boolean checkSolved()
    {
        for(int i = 0; i < 6; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                if(cubeFaces[i][j] != cubeFaces[i][4])
                    return false;
            }
        }
        return true;
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

        System.out.println();
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

        System.out.println();
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

        System.out.println();
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
        System.out.println("\n");

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
        return switch (cubeFaces[j][i]) {
            case white -> "⬜";
            case orange -> "\uD83D\uDFE7";
            case green -> "\uD83D\uDFE9";
            case red -> "\uD83D\uDFE5";
            case blue -> "\uD83D\uDFE6";
            case yellow -> "\uD83D\uDFE8";
        };
    }
    
    public void oldPachmann() {
        solveCode = "";
        while (cubeFaces[0][4] != color.white && cubeFaces[2][4] != color.white && cubeFaces[5][4] != color.white && cubeFaces[4][4] != color.white) {
            rotateCubeR();
            solveCode += "Y";
        }
        while (cubeFaces[5][4] != color.white) {
            rotateCubeU();
            solveCode += "X'";
        }
        while (cubeFaces[0][4] != color.green) {
            rotateCubeR();
            solveCode += "Y";
        }
        while (!edgesFinished)
        {
            String edgeLetter = getPieceLetter(true);
            switch (edgeLetter)
            {
                case "B","M":
                    String unsolvedPiece = nextUnsolvedEdge();
                    if(unsolvedPiece.equals("Z"))
                        edgesFinished = true;
                    else
                        edgeSwap(unsolvedPiece);
                    break;
                default:
                    edgeSwap(edgeLetter);
            }
            printCube();
        }
        while (edgesFinished && !cornersFinished)
        {
            String cornerLetter = getPieceLetter(false);
            switch (cornerLetter)
            {
                case "A", "E", "R":
                    String unsolvedPiece = nextUnsolvedCorner();
                    if(unsolvedPiece.equals("Z"))
                        cornersFinished = true;
                    else
                        cornerSwap(unsolvedPiece);
                    break;
                default:
                    cornerSwap(cornerLetter);
            }
            printCube();
            correctSolveCode();
        }
    }

    public void edgeSwap(String piece)
    {
        switch (piece)
        {
            case "A":
                lw();
                lw();
                d_();
                l();
                l();
                tPerm();
                l();
                l();
                d();
                lw();
                lw();
                solveCode+="LW2D'L2T-PermL2DLW2";
                break;

            case "C":
                lw();
                lw();
                d();
                l();
                l();
                tPerm();
                l();
                l();
                d_();
                lw();
                lw();
                solveCode+="LW2DL2T-PermL2D'LW2";
                break;

            case "D":
                tPerm();
                solveCode+="T-Perm";
                break;

            case "E":
                l_();
                dw();
                l_();
                tPerm();
                l();
                dw_();
                l();
                solveCode+="L'DWL'T-PermLDW'L";
                break;

            case "F":
                dw_();
                l();
                tPerm();
                l_();
                dw();
                solveCode+="DW'LT-PermL'DW";
                break;

            case "G":
                l();
                dw();
                l_();
                tPerm();
                l();
                dw_();
                l_();
                solveCode+="LDWL'T-PermLDW'L'";
                break;

            case "H":
                dw();
                l_();
                tPerm();
                l();
                dw_();
                solveCode+="DWL'T-PermLDW'";
                break;

            case "I":
                lw();
                d_();
                l();
                l();
                tPerm();
                l();
                l();
                d();
                lw_();
                solveCode+="LWD'L2T-PermL2DLW'";
                break;

            case "J":
                dw();
                dw();
                l();
                tPerm();
                l_();
                dw();
                dw();
                solveCode+="DW2LT-PermL'DW2";
                break;

            case "K":
                f();
                l_();
                f_();
                tPerm();
                f();
                l();
                f_();
                solveCode+="FL'F'T-PermFLF'";
                break;

            case "L":
                l_();
                tPerm();
                l();
                solveCode+="L'T-PermL";
                break;

            case "N":
                dw();
                l();
                tPerm();
                l_();
                dw_();
                solveCode+="DWLT-PermL'DW'";
                break;

            case "O":
                d_();
                f();
                l_();
                f_();
                tPerm();
                f();
                l();
                f_();
                d();
                solveCode+="D'FL'F'T-PermFLF'D";
                break;

            case "P":
                dw_();
                l_();
                tPerm();
                l();
                dw();
                solveCode+="DW'L'T-PermLDW";
                break;

            case "Q":
                lw_();
                d();
                l();
                l();
                tPerm();
                l();
                l();
                d_();
                lw();
                solveCode+="LW'DL2T-PermL2D'LW";
                break;

            case "R":
                l();
                tPerm();
                l_();
                solveCode+="LT-PermL'";
                break;

            case "S":
                b_();
                l();
                b();
                tPerm();
                b_();
                l_();
                b();
                solveCode+="B'LBT-PermB'L'B";
                break;

            case "T":
                dw();
                dw();
                l_();
                tPerm();
                l();
                dw();
                dw();
                solveCode+="DW2L'T-PermLDW2";
                break;

            case "U":
                d_();
                l();
                l();
                tPerm();
                l();
                l();
                d();
                solveCode+="D'L2T-PermL2D";
                break;

            case "V":
                d();
                d();
                l();
                l();
                tPerm();
                l();
                l();
                d();
                d();
                solveCode+="D2L2T-PermL2D2";
                break;

            case "W":
                d();
                l();
                l();
                tPerm();
                l();
                l();
                d_();
                solveCode+="DL2T-PermL2D'";
                break;

            case "X":
                l();
                l();
                tPerm();
                l();
                l();
                solveCode+="L2T-PermL2";
                break;
        }
    }

    public void cornerSwap(String piece)
    {
        switch (piece)
        {
            case "B":
                r();
                r();
                yPerm();
                r();
                r();
                solveCode+="R2Y-PermR2";
                break;

            case "C":
                r();
                r();
                d_();
                yPerm();
                d();
                r();
                r();
                solveCode+="R2D'Y-PermDR2";
                break;

            case "D":
                f();
                f();
                yPerm();
                f();
                f();
                solveCode+="F2Y-PermF2";
                break;

            case "F":
                f_();
                d();
                yPerm();
                d_();
                f();
                solveCode+="F'DY-PermD'F";
                break;

            case "G":
                f_();
                yPerm();
                f();
                solveCode+="F'Y-PermF";
                break;

            case "H":
                d_();
                r();
                yPerm();
                r_();
                d();
                solveCode+="D'RY-PermR'D";
                break;

            case "I":
                f();
                r_();
                yPerm();
                r();
                f_();
                solveCode+="FR'Y-PermRF'";
                break;

            case "J":
                r_();
                yPerm();
                r();
                solveCode+="R'Y-PermR";
                break;

            case "K":
                f_();
                r_();
                yPerm();
                r();
                f();
                solveCode+="F'R'Y-PermRF";
                break;

            case "L":
                f();
                f();
                r_();
                yPerm();
                r();
                f();
                f();
                solveCode+="F2R'Y-PermRF2";
                break;

            case "M":
                f();
                yPerm();
                f_();
                solveCode+="FY-PermF'";
                break;

            case "N":
                r_();
                f();
                yPerm();
                f_();
                r();
                solveCode+="R'FY-PermF'R";
                break;

            case "O":
                r();
                r();
                f();
                yPerm();
                f_();
                r();
                r();
                solveCode+="R2FY-PermF'R2";
                break;

            case "P":
                r();
                f();
                yPerm();
                f_();
                r_();
                solveCode+="RFY-PermF'R'";
                break;

            case "Q":
                r();
                d_();
                yPerm();
                d();
                r_();
                solveCode+="RD'Y-PermDR'";
                break;

            case "S":
                d();
                f_();
                yPerm();
                f();
                d_();
                solveCode+="DF'Y-PermFD'";
                break;

            case "T":
                r();
                yPerm();
                r_();
                solveCode+="RY-PermR'";
                break;

            case "U":
                d();
                yPerm();
                d_();
                solveCode+="DY-PermD'";
                break;

            case "V":
                yPerm();
                solveCode+="Y-Perm";
                break;

            case "W":
                d_();
                yPerm();
                d();
                solveCode+="D'Y-PermD";
                break;

            case "X":
                d();
                d();
                yPerm();
                d();
                d();
                solveCode+="D2Y-PermD2";
                break;
        }
    }
    
//    public String getEdgeLetter()
//    {
//        //[5,5] [1,5]
//        color buffer = cubeFaces[5][5];
//        color bufferSide = cubeFaces[1][5];
//        if(buffer == color.white)
//        {
//            if(bufferSide == color.blue)
//                return "A";
//            else if (bufferSide == color.red)
//                return "B";
//            else if (bufferSide == color.green)
//                return "C";
//            else
//                return "D";
//        } else if (buffer == color.orange) {
//            if(bufferSide == color.white)
//                return "E";
//            else if (bufferSide == color.green)
//                return "F";
//            else if (bufferSide == color.yellow)
//                return "G";
//            else
//                return "H";
//        } else if (buffer == color.green) {
//            if(bufferSide == color.white)
//                return "I";
//            else if (bufferSide == color.red)
//                return "J";
//            else if (bufferSide == color.yellow)
//                return "K";
//            else
//                return "L";
//        } else if (buffer == color.red) {
//            if(bufferSide == color.white)
//                return "M";
//            else if (bufferSide == color.blue)
//                return "N";
//            else if (bufferSide == color.yellow)
//                return "O";
//            else
//                return "P";
//        } else if (buffer == color.blue) {
//            if(bufferSide == color.white)
//                return "Q";
//            else if (bufferSide == color.orange)
//                return "R";
//            else if (bufferSide == color.yellow)
//                return "S";
//            else
//                return "T";
//        }
//        else {
//            if(bufferSide == color.green)
//                return "U";
//            else if (bufferSide == color.red)
//                return "V";
//            else if (bufferSide == color.blue)
//                return "W";
//            else
//                return "X";
//        }
//    }

    public String getPieceLetter(boolean edgeMode)
    {
        color buffer, bufferAttachment;
        if(edgeMode)
        {
            buffer = cubeFaces[5][5];
            bufferAttachment = cubeFaces[1][1];
        }
        else {
            buffer = cubeFaces[3][0];
            bufferAttachment = cubeFaces[5][0];
        }
        if(buffer == color.white) {
            if (bufferAttachment == color.blue)
                return "A";
            else if (bufferAttachment == color.red)
                return "B";
            else if (bufferAttachment == color.green)
                return "C";
            else
                return "D";
        } else if (buffer == color.orange) {
            if (bufferAttachment == color.white)
                return "E";
            else if (bufferAttachment == color.green)
                return "F";
            else if (bufferAttachment == color.yellow)
                return "G";
            else
                return "H";
        } else if (buffer == color.green) {
            if (bufferAttachment == color.white)
                return "I";
            else if(bufferAttachment == color.red)
                return "J";
            else if(bufferAttachment == color.yellow)
                return "K";
            else
                return "L";
        } else if (buffer == color.red) {
            if(bufferAttachment == color.white)
                return "M";
            else if(bufferAttachment == color.blue)
                return "N";
            else if(bufferAttachment == color.yellow)
                return "O";
            else
                return "P";
        } else if (buffer == color.blue) {
            if(bufferAttachment == color.white)
                return "Q";
            else if(bufferAttachment == color.orange)
                return "R";
            else if(bufferAttachment == color.yellow)
                return "S";
            else
                return "T";
        }
        else
            if(bufferAttachment == color.green)
                return "U";
            else if(bufferAttachment == color.red)
                return "V";
            else if(bufferAttachment == color.blue)
                return "W";
            else
                return "X";
    }

    public String nextUnsolvedEdge()
    {
        if(cubeFaces[5][1] != color.white || cubeFaces[2][1] != color.blue)
            return "A";
        else if(cubeFaces[5][7] != color.white || cubeFaces[0][1] != color.green)
            return "C";
        else if(cubeFaces[5][3] != color.white || cubeFaces[3][1] != color.orange)
            return "D";
        else if(cubeFaces[3][5] != color.orange || cubeFaces[0][3] != color.green)
            return "F";
        else if(cubeFaces[3][7] != color.orange || cubeFaces[4][3] != color.yellow)
            return "G";
        else if(cubeFaces[3][3] != color.orange || cubeFaces[2][5] != color.blue)
            return "H";
        else if(cubeFaces[0][5] != color.green || cubeFaces[1][3] != color.red)
            return "J";
        else if(cubeFaces[0][7] != color.green || cubeFaces[4][1] != color.yellow)
            return "K";
        else if(cubeFaces[1][5] != color.red || cubeFaces[2][3] != color.blue)
            return "N";
        else if(cubeFaces[1][7] != color.red || cubeFaces[4][5] != color.yellow)
            return "O";
        else if(cubeFaces[2][7] != color.blue || cubeFaces[4][7] != color.yellow)
            return "S";
        else
            return "Z";
    }

    public String nextUnsolvedCorner()
    {
        if(cubeFaces[5][2] != color.white || cubeFaces[1][2] != color.red)
            return "B";
        else if(cubeFaces[5][8] != color.white || cubeFaces[0][2] != color.green)
            return "C";
        else if(cubeFaces[5][6] != color.white || cubeFaces[3][2] != color.orange)
            return "D";
        else if(cubeFaces[3][8] != color.orange || cubeFaces[4][0] != color.yellow)
            return "G";
        else if(cubeFaces[3][6] != color.orange || cubeFaces[2][8] != color.blue)
            return "H";
        else if(cubeFaces[0][8] != color.green || cubeFaces[4][2] != color.yellow)
            return "K";
        else if(cubeFaces[1][8] != color.red || cubeFaces[4][8] != color.yellow)
            return "O";
        else
            return "Z";
    }

    public void correctSolveCode()
    {
//        solveCode = solveCode.replace(" ", "");
//        solveCode = solveCode.replace("RUR'U'R'FRRU'R'U'RUR'F'"," TPERM ");
//        solveCode = solveCode.replace("RU'R'U'RUR'F'RUR'U'R'FR", " YPERM ");
//        solveCode = solveCode.replace("LLL", "L'");
//        solveCode = solveCode.replace("L'L'L'", "L");
//        solveCode = solveCode.replace("RRR", "R'");
//        solveCode = solveCode.replace("R'R'R'", "R");
//        solveCode = solveCode.replace("UUU", "U'");
//        solveCode = solveCode.replace("U'U'U'", "U");
//        solveCode = solveCode.replace("DDD", "D'");
//        solveCode = solveCode.replace("D'D'D'", "D");
//        solveCode = solveCode.replace("FFF", "F'");
//        solveCode = solveCode.replace("F'F'F'", "F");
//        solveCode = solveCode.replace("BBB", "B'");
//        solveCode = solveCode.replace("B'B'B'", "B");
//        solveCode = solveCode.replace("LL", "L2");
//        solveCode = solveCode.replace("L'L'", "L2");
//        solveCode = solveCode.replace("RR", "R2");
//        solveCode = solveCode.replace("R'R'", "R2");
//        solveCode = solveCode.replace("UU", "U2");
//        solveCode = solveCode.replace("U'U'", "U2");
//        solveCode = solveCode.replace("DD", "D2");
//        solveCode = solveCode.replace("D'D'", "D2");
//        solveCode = solveCode.replace("FF", "F2");
//        solveCode = solveCode.replace("F'F'", "F2");
//        solveCode = solveCode.replace("BB", "B2");
//        solveCode = solveCode.replace("B'B'", "B2");
        solveCode = solveCode.replace("X'X'X'", "X");
        solveCode = solveCode.replace("XXX", "X'");
        solveCode = solveCode.replace("YYY", "Y'");
        solveCode = solveCode.replace("Y'Y'Y'", "Y");
        solveCode = solveCode.replace("XX", "X2");
        solveCode = solveCode.replace("X'X'", "X2");
        solveCode = solveCode.replace("YY", "Y2");
        solveCode = solveCode.replace("Y'Y'", "Y2");

    }

}

/*
Old Pachmann
edges:
case "A":
lw();
lw();
d_();
l();
l();
tPerm();
l();
l();
d();
lw();
lw();

case "C":
lw();
lw();
d();
l();
l();
tPerm();
l();
l();
d_();
lw();
lw();

case "D":
tPerm();

case "E":
l_();
dw();
l_();
tPerm();
l();
dw_();
l();

case "F":
dw_();
l();
tPerm();
l_();
dw();

case "G":
l();
dw();
l_();
tPerm();
l();
dw_();
l_();

case "H":
dw();
l_();
tPerm();
l();
dw_();

case "I":
lw();
d_();
l();
l();
tPerm();
l();
l();
d();
lw_();

case "J":
dw();
dw();
l();
tPerm();
l_();
dw();
dw();

case "K":
f();
l_();
f_();
tPerm();
f();
l();
f_();

case "L":
l_();
tPerm();
l();

case "N":
dw();
l();
tPerm();
l_();
dw_();

case "O":
d_();
f();
l_();
f_();
tPerm();
f();
l();
f_();
d();

case "P":
dw_();
l_();
tPerm();
l();
dw();

case "Q":
lw_();
d();
l();
l();
tPerm();
l();
l();
d_();
lw();

case "R":
l();
tPerm();
l_();

case "S":
b_();
l();
b();
tPerm();
b_();
l_();
b();

case "T":
dw();
dw();
l_();
tPerm();
l();
dw();
dw();

case "U":
d_();
l();
l();
tPerm();
l();
l();
d();

case "V":
d();
d();
l();
l();
tPerm();
l();
l();
d();
d();

case "W":
d();
l();
l();
tPerm();
l();
l();
d_();

case "X":
l();
l();
tPerm();
l();
l();

b, m:
search for unfinished edge and swap that

corners:
b:
r();
r();
yPerm();
r();
r();

c:
r();
r();
d_();
yPerm();
d();
r();
r();

d:
f();
f();
yPerm();
f();
f();

f:
f_();
d();
yPerm();
d_();
f();

g:
f_();
yPerm();
f();

h:
d_();
r();
yPerm();
r_();
d();

i:
f();
r_();
yPerm();
r();
f_();

j:
r_();
yPerm();
r();

k:
f_();
r_();
yPerm();
r();
f();

l:
f();
f();
r_();
yPerm();
r();
f();
f();

m:
f();
yPerm();
f_();

n:
r_();
f();
yPerm();
f_();
r();

o:
r();
r();
f();
yPerm();
f_();
r();
r();

p:
r();
f();
yPerm();
f_();
r_();

q:
r();
d_();
yPerm();
d();
r_();

s:
d();
f_();
yPerm();
f();
d_();

t:
r();
yPerm();
r_();

u:
d();
yPerm();
d_();

v:
yPerm();

w:
d_();
yPerm();
d();

x:
d();
d();
yPerm();
d();
d();

a, e, r:
search for unfinished corners and swap that
 */
