// 4. **Library of Movies (Movie Catalog)** 🎬
//    * Classes: `Movie`, `Actor`, `Director`.
//    * Store movies in a `Map<String, Movie>` (key = movie title).
//    * Features: add movies, search by genre, list movies by actor.

package projects.project4;

public class Actor{
    private String name;

    public Actor(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override 
    public String toString(){
        return name;
    }
}
