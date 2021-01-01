package practice.functional.biman.prg2;

import practice.functional.biman.prg1.Function;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static practice.functional.biman.prg2.Result.*;

public class EmailChecker {
    static Matcher matcher;
    static String regex = "^[\\w\\.\\-+_]+@[a-zA-Z]+\\.[a-zA-Z]+";
    static Pattern pattern = Pattern.compile(regex);

    static Function<String, Result> emailChecker = (emailID) -> {
        if (emailID == null)
            return failure("Email can not be null");
        else if (emailID.isEmpty())
            return failure("Email can not be empty");
        else {
            if (pattern.matcher(emailID).matches()) {
                return success();
            } else {
                return failure("Invalid email id");
            }
        }
    };

  /*  private static void validateEmail(String emailID) {
        if (emailID != null) {
            if (emailID.isEmpty())
                logError("email id can not be empty");
            else {
                matcher = pattern.matcher(emailID);
                if (matcher.matches()) {
                    sendVerificationEmail(emailID);
                } else {
                    logError("Invalid email id");
                }
            }
        } else
            logError("email id can not be null");
    } */

    private static void validateEmail(String emailID) {
        Result result = emailChecker.apply(emailID);
        if (result instanceof Result.Success)
            sendVerificationEmail(emailID);
        else
            logError(((Result.Failure) result).getFailureMessage());
    }

    private static void sendVerificationEmail(String emailID) {
        System.out.println("Valid Email : " + emailID);
    }

    private static void logError(String message) {
        System.out.println(message);
    }

    public static void main(String... args) {
        EmailChecker.validateEmail("@yahoo.com");
        EmailChecker.validateEmail("user@domain.com");
        EmailChecker.validateEmail(null);
        EmailChecker.validateEmail("");


    }

}
