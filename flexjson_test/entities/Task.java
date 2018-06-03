/**
 * @file:    Task.java
 * @package: flexjson_test.entities
 * @info:    test flexjson library / http://flexjson.sourceforge.net
 *
 * @author:  Moisés Alcocer, 2018
 * @link:    https://www.ironwoods.es
 * @license: MIT License
 */
package flexjson_test.entities;


public class Task {
    private int id;
    private String name;

    public Task() {}
    public Task(int id, String name) {
        this.id   = id;
        this.name = name;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

} // class
