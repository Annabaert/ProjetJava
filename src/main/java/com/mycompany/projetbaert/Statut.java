package com.mycompany.projetbaert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author annabelle
 */
public class Statut {

    protected int id;
    protected String code;
    protected String type;
    protected String description;
    protected String name;

    public Statut(int id, String code, String type, String description, String name) {
        this.id = id;
        this.code = code;
        this.type = type;
        this.description = description;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static ArrayList<Statut> findAll() throws SQLException {
        ArrayList<Statut> tab = new ArrayList();
        Database data = null;
        try {
            data = Database.getInstance();
        } catch (SQLException ex) {
            Logger.getLogger(Statut.class.getName()).log(Level.SEVERE, null, ex);
        }
        Statement stat = null;
        try {
            stat = data.getConnection().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Statut.class.getName()).log(Level.SEVERE, null, ex);
        }
        String query = "SELECT * FROM httpstatuses";
        ResultSet resultset = stat.executeQuery(query);

        while (resultset.next()) {
            int id;
            String code;
            String type;
            String description;
            String nom;

            Statut st;

            id = resultset.getInt("id");
            code = resultset.getString("code");
            type = resultset.getString("type");
            description = resultset.getString("description");
            nom = resultset.getString("name");

            st = new Statut(id, code, type, description, nom);
            tab.add(st);

        }
        stat.close();
        resultset.close();
        return tab;
    }

    // @Override
    @Override
    public String toString() {
        return String.format("%s %s", code, name);
    }
}
