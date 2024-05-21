/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.base;

import java.io.Serializable;

/**
 *
 * @author anisl
 */
public class Loc implements Serializable{

  int x;
 String name;
  Category category;

    public Loc(String name, int x) {
        this.name = name;
        this.x = x;

    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Location: " + "name = " + name + ", number of vertex = " + x + "\n";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

}
