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
public class Edge{

    Loc source;
    Loc destination;
    int weight;

    public Edge(Loc source, Loc destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}
