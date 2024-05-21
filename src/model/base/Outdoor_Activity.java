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
public class Outdoor_Activity extends Loc {

    String desc;
    String attraction;
    String activities;

    public Outdoor_Activity(String name, int x, String desc, String attraction, String activities) {
        super(name, x);
        setCategory(Category.Bar_Restaurant);
        this.desc = desc;
        this.attraction = attraction;
        this.activities = activities;

    }

    @Override
    public String toString() {
        return "Outdoor Activity  name = " + super.name + ", number of vertex = " + super.x + ", description = " + this.desc + ", attractions = " + this.attraction + ", list of activities = " + this.activities + "\n";
    }

}
