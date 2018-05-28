package com.biomimetisme.val.bioquizz.model;

/**
 * Created by Valérie Criton on 09/05/18.
 * Classe utilisateur
 */
public class User {

    private String mFirstName;

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {

        mFirstName = firstName;
    }

    // interessante si on veut afficher la valeur du contenu
    @Override
    public String toString() {
        return "User{" +
                "mFirstName='" + mFirstName + '\'' +
                '}';
    }
}
