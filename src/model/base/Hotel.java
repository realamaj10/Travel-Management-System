/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.base;

/**
 *
 * @author anisl
 */
public class Hotel extends Loc {

    String desc;
    int stars;

    public Hotel(String name, int x, String desc, int stars) {
        super(name, x);
        setCategory(Category.Hotel);
        this.desc = desc;
        this.stars = stars;

    }

    @Override
    public String toString() {
        return "Hotel:  name= " + super.name + ", number of vertex = " + super.x + ", description= " + this.desc + ", number of stars= " + this.stars + "/5 \n";
    }

}
