// 4. **Library of Movies (Movie Catalog)** 🎬
//    * Classes: `Movie`, `Actor`, `Director`.
//    * Store movies in a `Map<String, Movie>` (key = movie title).
//    * Features: add movies, search by genre, list movies by actor.

package projects.project4;

import java.util.ArrayList;
import java.util.List;

abstract class Movie {
    private String title;
    private String genre;
    private int year;
    private Director director;
    private List<Actor> actors;

    public Movie(String title, String genre, int year, Director director) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.director = director;
        this.actors = new ArrayList<>();
    }

    public void addActor(Actor actor) {
        actors.add(actor);
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public Director getDirector() {
        return director;
    }

    public List<Actor> getActors() {
        return actors;
    }

    @Override
    public String toString() {
        return title + " (" + year + ") - " + genre + " - Director: " + director.getName();
    }
}
