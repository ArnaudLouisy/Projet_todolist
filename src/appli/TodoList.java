package appli;

import java.util.ArrayList;
public class TodoList {
    private  ArrayList<String> tache;

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

    public boolean retirer_tache(int var1) {
        if (var1 < this.tache.size() + 1) {
            int var2 = this.tache.size();
            this.tache.remove(var1 - 1);
            return var2 != var2 - 1;
        } else {
            System.out.println("Numero pas dans la liste");
            return false;
        }
    }
}




