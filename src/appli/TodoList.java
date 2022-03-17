package appli;

import java.util.ArrayList;
import  java.util.Scanner;
public class TodoList {
    Scanner sc = new Scanner(System.in);
    private  ArrayList<String> tache;
    private TodoList listeTache;
    private boolean enMarche;

    public TodoList() {
        this.tache = new ArrayList<String>(tache);
        }


    public String toString() {
        int var1 = this.tache.size();
        String var2 = "Vous avez " + var1 + " tache a faire  a faire :\n";

        for(int var3 = 0; var3 < var1; ++var3) {
            var2 = var2 + "Tache " + (var3 + 1) + " : " + (String)this.tache.get(var3) + " \n";
        }

        return var2;
    }

    public void ajouter_tache(String var1) {
        this.tache.add(var1);
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

    private boolean retirer_tache(int var1) {
        return false;
    }
    public void lancerAppli() {
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
                default:
                    System.out.println("Choix incorrect");

}
        }

    }
    }





