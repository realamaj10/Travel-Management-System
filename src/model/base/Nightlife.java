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
public class Nightlife extends Loc {

    String desc;
    String type;

    public Nightlife(String name, int x, String desc, String type) {
        super(name, x);
        setCategory(Category.Nightlife);
        this.desc = desc;
        this.type = type;

    }

    @Override
    public String toString() {
        return "Nightlife:  name = " + super.name + ", number of vertex = " + super.x + ", description = " + this.desc + ", type of nightlife = " + this.type + "\n";
    }

}
