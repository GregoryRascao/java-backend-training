/**
 * 1. Build an object using Builder Pattern.
 * 2. Print the created object.
 */

package modern.examples;

public class Example4
{
    static class User
    {
        private final String name;
        private final int age;
        private final boolean active;

        private User(Builder builder)
        {
            this.name = builder.name;
            this.age = builder.age;
            this.active = builder.active;
        }

        @Override
        public String toString()
        {
            return "User{name='" + name + "', age=" + age + ", active=" + active + "}";
        }

        static class Builder
        {
            private String name;
            private int age;
            private boolean active;

            public Builder name(String name)
            {
                this.name = name;
                return this;
            }

            public Builder age(int age)
            {
                this.age = age;
                return this;
            }

            public Builder active(boolean active)
            {
                this.active = active;
                return this;
            }

            public User build()
            {
                return new User(this);
            }
        }
    }

    public static void main(String[] args)
    {
        User user = new User.Builder()
                .name("Student")
                .age(35)
                .active(true)
                .build();

        System.out.println(user);
    }
}
