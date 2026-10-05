/**
 * 1. Create a User class (username, password).
 * 2. Mark password as transient.
 * 3. Serialize and deserialize a User object.
 * 4. Show that the password field is null after deserialization.
 */

package serialization.exercises;

import java.io.*;

public class Exercise3 {
    static class User implements Serializable {
        public String username;
        public transient String password;

        public User(String userName, String password) {
            this.username = userName;
            this.password = password;
        }

        @Override
        public String toString() {
            return "User{" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }

    }

    public static void main(String[] args) {

        User user = new User("gregory", "secret123");
        String fileName = "User.ser";
        // serialization
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(user);
            System.out.println("User saved to " + fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        User loadedUser = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            loadedUser = (User) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("After deserialization : " + loadedUser);
        System.out.println("password null ? " + (loadedUser.password == null));
    }
}
