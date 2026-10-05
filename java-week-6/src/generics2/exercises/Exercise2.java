package generics2.exercises;

/**
 * Exercise 2 — Validator
 *
 * Create an interface:
 *
 * interface Validator<T>
 *
 * Method:
 *   boolean validate(T value)
 *
 * Example implementations:
 *
 * EmailValidator implements Validator<String>
 * PositiveNumberValidator implements Validator<Integer>
 */
public class Exercise2 {
    
    public interface Validator<T> {

        boolean validate(T value);
        
    }
    public static class EmailValidator implements  Validator<String>{
        @Override 
        public boolean validate(String email){
            return email != null && email.contains("@") && email.contains(".");
        }
    }

    public static class PositiveNumberValidator implements  Validator<Integer>{
        @Override 
        public boolean validate(Integer value){
            return value != null && value > 0;
        }
    }

    public static void main(String[] args) {
        Validator<String> emailValidator = new EmailValidator();
        Validator<Integer> positiveNumberValidator = new PositiveNumberValidator();

        System.out.println(emailValidator.validate("test@example.com")); 
        System.out.println(emailValidator.validate("invalid-email"));

        System.out.println(positiveNumberValidator.validate(10)); 
        System.out.println(positiveNumberValidator.validate(-5));
    }
}
