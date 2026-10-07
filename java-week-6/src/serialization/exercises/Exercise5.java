/**
 * 1. Create a Settings class (theme, volume, language).
 * 2. Have the language field transient.
 * 3. In main, create a LinkedHashSet with 3 items
 * 4. Serialize the Settings object to "settings.ser".
 * 5. Change the object values in the set in your code.
 * 6. Deserialize the old version of set from file and display both.
 * 7. Check if they are the same
 */

package serialization.exercises;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

public class Exercise5 {
    public static class Settings implements Serializable {
        private String theme;
        private double volume;
        private transient String language;

        public Settings(String theme, double volume, String language) {
            this.theme = theme;
            this.volume = volume;
            this.language = language;
        }

        @Override
        public String toString() {
            return "This are the settings :" + theme + " ,volume =" + volume + " language = " + language;
        }

        public String getTheme() {
            return theme;
        }

        public double getVolume() {
            return volume;
        }

        public String getLanguage() {
            return language;
        }
    }

    public static void main(String[] args) {
        Set<Settings> config = new LinkedHashSet<>();
        config.add(new Settings("dark", 90.0, "fr"));
        config.add(new Settings("white", 70, "pt"));
        config.add(new Settings("dark", 60, "en"));

        String fileName = "../../../resources/settings.ser";
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(config);
            System.out.println("Config Saved to " + fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Set<Settings> newConfig = new LinkedHashSet<>();
        config.add(new Settings("brown", 30, "fr"));
        config.add(new Settings("white", 05, "pt"));
        config.add(new Settings("dark", 90, "en"));

        System.out.println("Old set: " + config);
        System.out.println("New set: " + newConfig);

        Set<Settings> loadedSet = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            loadedSet = (Set<Settings>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Loaded old set: " + loadedSet);

        System.out.println("Are they the same? " + config.equals(loadedSet));
    }
}
