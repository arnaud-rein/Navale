package bataille.navale;

import java.util.Scanner;

public class Grid {

    String name;

    String[][] gridTest;
    String[][] gridDeRoute;
    int userChoiceY;
    int userChoiceX;

    Grid(String name) {
        this.name = name;

    }

    Scanner input = new Scanner(System.in);

    public void demanderTaille() {

        System.out.println("Combien de lignes voulez-vous ?");
        this.userChoiceX = input.nextInt();
        System.out.println("Combien de colonnes voulez-vous ?");
        this.userChoiceY = input.nextInt();

        this.gridTest = new String[userChoiceX][userChoiceY];
        this.gridDeRoute = new String[userChoiceX][userChoiceY];

        for (int nombreHaut = 0; nombreHaut < userChoiceX; nombreHaut++) {
            System.out.print(nombreHaut);
        }
        System.out.println();
        for (int line = 0; line < userChoiceX; line++) {
            for (int col = 0; col < userChoiceY; col++) {
                System.out.print("-");
                gridTest[line][col] = "-";
                gridDeRoute[line][col] = "-";
                // gridDeRoute[line][col] = "-";
            }
            System.out.print(line);
            System.out.println();
        }

        System.out.println(gridTest[1][1]);

    }

    public void afficherGrid() {

        for (int nombreHaut = 0; nombreHaut < this.userChoiceX; nombreHaut++) {
            System.out.print(nombreHaut);
        }
        System.out.println();
        for (int line = 0; line < this.userChoiceX; line++) {
            for (int col = 0; col < this.userChoiceY; col++) {

                System.out.print(gridTest[line][col]);
                // gridDeRoute[line][col] = "-";
            }
            System.out.print(line);
            System.out.println();
        }

        System.out.println(gridTest[1][1]);

    }

    public void afficherGridDeRoute() {

        for (int nombreHaut = 0; nombreHaut < this.userChoiceX; nombreHaut++) {
            System.out.print(nombreHaut);
        }
        System.out.println();
        for (int line = 0; line < this.userChoiceX; line++) {
            for (int col = 0; col < this.userChoiceY; col++) {

                System.out.print(this.gridDeRoute[line][col]);
                // gridDeRoute[line][col] = "-";
            }
            System.out.print(line);
            System.out.println();
        }

        System.out.println(this.gridDeRoute[1][1]);

    }

    public void placerLeNavireDeGuerre() {
        System.out.println("entrer les coordonnées x du premier navire :");
        int nav1Line = input.nextInt();
        System.out.println("entrer les coordonnées y du premier navire :");
        int nav1Col = input.nextInt();
        System.out.println("dans quel sens voulez placer votre navire, vertical => v ou horizontal => h ? ");
        String choixPlacement = input.next();

        if (choixPlacement.equals("v")) {
            for (int bat = 0; bat < 4; bat++) {
                if (bat == 0 || bat == 4) {
                    this.gridTest[nav1Line][bat + nav1Col] = "4";
                } else {
                    this.gridTest[nav1Line][bat + nav1Col] = "4";
                }

            }

        } else if (choixPlacement.equals("h")) {

            for (int bat = 0; bat < 4; bat++) {
                if (bat == 0 || bat == 4) {
                    this.gridTest[bat + nav1Line][nav1Col] = "4";

                } else {
                    this.gridTest[bat + nav1Line][nav1Col] = "4";
                }

            }
        }

    }

    public void placerLeNavireDeGuerreV2(int tailleNav) {
        int nbRecuperer = tailleNav;
        String recup2 = nbRecuperer + "";
        System.out.println(
                "entrer les coordonnées y puis x puis mettez 'h' pour horizontal ou 'v' pour vertical  du navire de taille: "
                        + tailleNav);
        int nav1Line = input.nextInt();
        int resNavLine = nav1Line;
        int nav1Col = input.nextInt();
        int resNavCol = nav1Col;
        String choixPlacement = input.next();

        if (choixPlacement.equals("v")) {
            boolean continuerAlgo = true;
            for (int bat = 0; bat < tailleNav; bat++) {
                if (bat == 0 || bat == tailleNav) {

                    if (continuerAlgo) {
                        if (PossibilityPlaceNav(tailleNav, resNavCol, resNavLine, choixPlacement)) {
                            this.gridTest[nav1Line][bat + nav1Col] = recup2;
                            resNavCol += 1;
                            continuerAlgo = false;
                            // System.out.println(PossibilityPlaceNav(tailleNav, nav1Line, nav1Col,
                            // choixPlacement));
                        } else {
                            System.out.println("vous avez fait une erreur");
                            placerLeNavireDeGuerreV2(tailleNav);
                        }

                    } else {
                        this.gridTest[nav1Line][bat + nav1Col] = recup2;
                        resNavCol += 1;

                    }

                } else {                    

                        this.gridTest[nav1Line][bat + nav1Col] = recup2;
                        resNavCol += 1;                

                }

            }

        } else if (choixPlacement.equals("h")) {
            boolean continuerAlgo = true; // la portée de la variable que l'on avait initialisée juste avant n'est valable que dans la condition if
            for (int bat = 0; bat < tailleNav; bat++) {
                if (bat == 0 || bat == tailleNav) {
                    if(continuerAlgo){
                        if (PossibilityPlaceNav(tailleNav, resNavLine, resNavCol, choixPlacement)) {
                            this.gridTest[bat + nav1Line][nav1Col] = recup2;
                            afficherGrid();
                            resNavLine += 1;
                        } else {
                            System.out.println("vous avez fait une erreur");
                            placerLeNavireDeGuerreV2(tailleNav);
                        }
                    }else{
                        this.gridTest[bat + nav1Line][nav1Col] = recup2;
                            afficherGrid();
                            resNavLine += 1;
                    }

                } else {                   
                        this.gridTest[bat + nav1Line][nav1Col] = recup2;
                        resNavLine += 1;                    
                }

            }
        }

    }

    public boolean PossibilityPlaceNav(int tailleBateau, int coorY, int coorX, String coline) {
        boolean decision = true;
        if (coline.equals("h")) {
            for (int i = 0; i < tailleBateau; i++) {
                int suivi = coorY + i;
                if (!this.gridTest[suivi][coorX].equals("-")) {
                    decision = false;
                    break;

                } else {
                    this.gridTest[suivi][coorX] = "r";
                    afficherGrid();
                }
            }
        } else if (coline.equals("v")) {
            for (int i = 0; i < tailleBateau; i++) {
                if (this.gridTest[coorX + i][coorY] != "-") {
                    decision = false;

                    break;

                }
            }

        }

        return decision;

    }

    public void placerToutLesNavires() {

        placerLeNavireDeGuerreV2(4);

    }

    public void placerNavire() {
        for (int nb_navire = 0; nb_navire < 5; nb_navire++) {
            System.out.println("placer un navire, X");
            int choiceTorpilleX = input.nextInt();
            System.out.println("placer un navire, Y");
            int choiceTorpilleY = input.nextInt();
            this.gridTest[choiceTorpilleX][choiceTorpilleY] = "@";
        }

    }

    public void recevoirTorpille() {
        System.out.println("donnez la coordonnée X afin de torpiller");
        int choiceCoordX = input.nextInt();
        System.out.println("donnez la coordonnée Y afin de torpiller");
        int choiceCoordY = input.nextInt();

        if (this.gridTest[choiceCoordX][choiceCoordY].equals("@")) {
            System.out.println("bien joué, vous avez fait couler un navire adverse");
            this.gridTest[choiceCoordX][choiceCoordY] = "X";
            this.gridDeRoute[choiceCoordX][choiceCoordY] = "X";

        } else if (this.gridTest[choiceCoordX][choiceCoordY].equals("-")) {
            System.out.println("vous n'avez rien touché");
            this.gridTest[choiceCoordX][choiceCoordY] = "O";
            this.gridDeRoute[choiceCoordX][choiceCoordY] = "O";
        } else if (this.gridTest[choiceCoordX][choiceCoordY].equals("O")
                || this.gridTest[choiceCoordX][choiceCoordY].equals("@")) {
            System.out.println("vous avez déjà joué cette case");
            recevoirTorpille();
        } else {
            System.out.println("il y'a une erreur, veuillez réessayer");
            recevoirTorpille();
        }

    }

    public void testDouble() {

        int test1 = input.nextInt();
        int test2 = input.nextInt();

        System.out.println("donner moi une coordonée x" + test1 + "  " + test2);
    }

}
