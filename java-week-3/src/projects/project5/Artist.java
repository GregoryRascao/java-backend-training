package projects.project5;

public class Artist {
    private final String name;

    public Artist(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Artist name cannot be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
