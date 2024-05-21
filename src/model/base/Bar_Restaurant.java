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
public class Bar_Restaurant extends Loc {

    String desc;
    String type;

    public Bar_Restaurant(String name, int x, String desc, String type) {
        super(name, x);
        setCategory(Category.Bar_Restaurant);
        this.desc = desc;
        this.type = type;

    }

    @Override
    public String toString() {
        return "Bar/Restaurant:  name= " + super.name + ", number of vertex = " + super.x + ", description = " + this.desc + ", type of restaurant= " + this.type + "\n";
    }

}
