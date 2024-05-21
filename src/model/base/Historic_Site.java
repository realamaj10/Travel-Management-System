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
public class Historic_Site extends Loc {

    String desc;
    double entrance_fee;

    public Historic_Site(String name, int x, String desc, double entrance_fee) {
        super(name, x);
        setCategory(Category.Historic_Site);
        this.desc = desc;
        this.entrance_fee = entrance_fee;

    }

    @Override
    public String toString() {
        return "Historic Site:  name= " + super.name + ", number of vertex = " + super.x + ", description = " + this.desc + ", entrance fee= " + this.entrance_fee + "\n";
    }

}
