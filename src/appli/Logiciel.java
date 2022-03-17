package appli;

import java.util.Scanner;

public class Logiciel {


    public void lancerLogiciel() {
    }

    public class Logicel {
        private TodoList listeTache;
        private boolean enMarche;
        private Scanner sc;

        public void Logiciel() {
            this.sc = new Scanner(System.in);
            this.listeTache = new TodoList();
            this.enMarche = true;
        }

        public void saisirTache() {
            System.out.println("Veuillez saisir une tache ...");
            String var1 = this.sc.nextLine();
            this.listeTache.ajouter_tache(var1);
            System.out.println("Tache ajoutee !");
        }

        public void afficheListe() {
            System.out.println(this.listeTache.toString() + "\n");
        }

        public void supprimerTache() {
            this.afficheListe();
            System.out.println("Veuillez saisir le numero d'une ...");
            int var1 = this.sc.nextInt();
            if (this.listeTache.retirer_tache(var1)) {
                System.out.println("suppression effectuer ");
            } else {
                System.out.println("erreur de supression");
            }

        }

        public void fermerLogiciel() {
            System.out.println("\n\n A bientot !");
            this.enMarche = false;
        }

        public void lancerLogiciel() {
            System.out.println("Bienvenu sur le logiciel !\n");
            Scanner var2 = new Scanner(System.in);

            while(this.enMarche) {
                System.out.println("Que voulez vou faire\n 1 : ajouter une tache\n 2 : retirer une tache\n 3 : afficher la liste de tache\n 4 : fermer le logiciel");
                int var1 = var2.nextInt();
                switch(var1) {
                    case 1:
                        this.saisirTache();
                        break;
                    case 2:
                        this.supprimerTache();
                        break;
                    case 3:
                        this.afficheListe();
                        break;
                    case 4:
                        this.fermerLogiciel();
                        break;
                    default:
                        System.out.println("Choix incorrect");
                }
            }

        }
    }
}
