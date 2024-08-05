package catering.businesslogic.recipe;

import catering.persistence.PersistenceManager;
import catering.persistence.ResultHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.util.*;

public class Recipe extends KitchenDuty {
    private static Map<Integer, Recipe> all = new HashMap<>();

    private int id;

    private Recipe() {
        super();
    }

    public Recipe(String name, String author, String instructions, Double quantity, Duration activityTime,
            ArrayList<String> tags, int id) {
        super(name, author, instructions, quantity, activityTime, tags);
        this.id = id;
    }

    public Recipe(String name, int id, String name2) {
        super(name);
        this.id = id;
    }

    public Recipe(int id, String name) {
        this.id = id;
    }

    public Recipe(String name) {
        id = 0;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return this.getName();
    }

    // STATIC METHODS FOR PERSISTENCE

    public static ArrayList<Recipe> loadAllRecipes() {
        String query = "SELECT * FROM Recipes";
        PersistenceManager.executeQuery(query, new ResultHandler() {
            @Override
            public void handle(ResultSet rs) throws SQLException {
                int id = rs.getInt("id");
                if (all.containsKey(id)) {
                    Recipe rec = new Recipe();
                    rec.setName(rs.getString("name"));
                } else {
                    Recipe rec = new Recipe(rs.getString("name"));
                    rec.id = id;
                    all.put(rec.id, rec);
                }
            }
        });
        ArrayList<Recipe> ret = new ArrayList<Recipe>(all.values());
        Collections.sort(ret, new Comparator<Recipe>() {
            @Override
            public int compare(Recipe o1, Recipe o2) {
                return (o1.getName().compareTo(o2.getName()));
            }
        });
        return ret;
    }

    public static ArrayList<Recipe> getAllRecipes() {
        return new ArrayList<Recipe>(all.values());
    }

    public static Recipe loadRecipeById(int id) {
        if (all.containsKey(id))
            return all.get(id);
        Recipe rec = new Recipe();
        String query = "SELECT * FROM Recipes WHERE id = " + id;
        PersistenceManager.executeQuery(query, new ResultHandler() {
            @Override
            public void handle(ResultSet rs) throws SQLException {

                rec.setName(rs.getString("name"));
                rec.id = id;
                all.put(rec.id, rec);
            }
        });
        return rec;
    }

}
