import com.sun.istack.internal.Nullable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import static java.lang.Integer.valueOf;

@SuppressWarnings("Duplicates")
public class Main {
    private static int testCounter = 1;

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
//        testingStuff();
        System.out.println((-10 + -10));
    }


    private static int checkUsableValue(String valueString) {
        try {
            // replace whitespace with empty space
            valueString = valueString.replace(" ", "");
            if (valueString.trim().isEmpty())
                return 0;
            return compareMinMax(valueOf(valueString));
        } catch (Exception e) {
            // Value is null or cannot be parsed
            return -10;
        }
    }





    public static void fMain(String[] args) {
        int sleepTime=25;int randDeviation=new Random().nextInt(21);
        sleepTime=new Random().nextBoolean()?sleepTime+randDeviation:sleepTime-randDeviation;
        System.out.println(sleepTime);try{Thread.sleep((60 + randDeviation)*1000);
        }catch(InterruptedException e){System.out.println(e.getMessage());}
        if(args.length>0&&args[0].equals("true"))System.exit(1);
    }

    private static void testingStuff() {

        testCase("both empty", "","", true);
        testCase("confOne smaller than confTwo", "2","3", false);
        testCase("confOne larger", "3","2", true);
        testCase("both equal", "2","2", true);

        testCase("confOne too small","0","1", false);
        testCase("confTwo too small","1","0", false);
        testCase("both too small", "0", "0", false);

        testCase("confOne too large","51","1", false);
        testCase("confTwo too large","1","51", false);
        testCase("both too large","51","51", false);

        testCase("confOne is NAN", "a", "1", false);
        testCase("confTwo is NAN", "1", "a", false);

        testCase("confOne is too large, confTwo is too small", "51","0", false);
        testCase("confOne is too small, confTwo is too large", "0","51", false);
//        System.out.println(compareMinMax(0) + compareMinMax(0));
//        System.out.println(compareMinMax(51) + compareMinMax(51));
//        System.out.println(compareMinMax(51) - compareMinMax(0));
//        System.out.println(compareMinMax(0) - compareMinMax(51));
    }


    private static void testCase(String testDescription, String conf_one, String conf_two, boolean expect) {
        System.out.println(String.format("Test %d: %s", testCounter, testDescription));
        checkValues(conf_one, conf_two, expect);
        System.out.println();
        testCounter++;
    }

    private static void checkValues(String conf_one, String conf_two, boolean expect) {
        int cOne, cTwo;
        try {
            cOne = conf_one.trim().isEmpty() ? /* default value */ 6 : valueOf(conf_one);
            cTwo = conf_two.trim().isEmpty() ? /* default value */ 3 : valueOf(conf_two);
            System.out.println(String.format("One:%d\tTwo:%d", cOne, cTwo));

            if (compareMinMax(cOne) != 0 || compareMinMax(cTwo) != 0) {
                if (compareMinMax(cOne) + compareMinMax(cTwo) == -2)
                    throw new Exception("Both values are below the minimum value");
                if (compareMinMax(cOne) + compareMinMax(cTwo) == 2)
                    throw new Exception("Both values are above the maximum value");


                if (compareMinMax(cOne) != 0) // check if value is not within the min or max value
                    throw new Exception(compareMinMax(cOne) == -1 ?
                            "Cannot use: " + cOne + " for conf_one, the min value is 1" :
                            "Cannot use: " + cOne + " for conf_one, the max value is 50");
                if (compareMinMax(cTwo) != 0) // check if value is not within the min or max value
                    throw new Exception(compareMinMax(cTwo) == -1 ?
                            "Cannot use: " + cTwo + " for conf_two, the min value is 1" :
                            "Cannot use: " + cTwo + " for conf_two, the max value is 50");
            }
            if (cOne < cTwo)
                throw new Exception("confOne must be equal or larger than confTwo");

        } catch (NumberFormatException nfe) {
            System.out.println(String.format(
                    "Expect: %b\nResult: %b\nMessage: %s", expect, false, "Value has to be an integer"));
            return;
        } catch (Exception e) {
            System.out.println(String.format(
                    "Expect: %b\nResult: %b\nMessage: %s", expect, false, e.getMessage()));
            return;
        }
        System.out.println("Expect: " + expect);
        System.out.println("Result: " + true);
    }

    private static int compareMinMax(int value) {
        if (value < 1)
            return -1;
        if (value > 50)
            return 1;
        return 0;
    }

    private static int parseOrError(String input) {
        try {
            return Integer.valueOf(input);
        } catch (NumberFormatException nfe) {
            throw new NumberFormatException("input must be an integer");
        }
    }

    private static void doCheckInputOk(String candidates, String stepsBack, String target) {
        Integer candidatesValue = getInputValue(candidates, 3);
        Integer stepsBackValue = getInputValue(stepsBack, 6);
        Integer checkedCandidates = checkValueOK(candidatesValue);
        Integer checkedStepsBack = checkValueOK(stepsBackValue);
        if (inputIsNaN(checkedCandidates, checkedStepsBack)) {
            System.out.println("Neither of the values are integers");
            return;
        }
        if (inputIsNaN(checkedCandidates) || inputIsNaN(checkedStepsBack)) {
            System.out.println("value must be an integer");
            return;
        }
        System.out.println("wawa");


    }

    private static boolean inputIsNaN(Integer isCandidateNaN, Integer isStepsBackNaN) {
        return isCandidateNaN == null && isStepsBackNaN == null;
    }

    private static boolean inputIsNaN(Integer checkIfNaN) {
        return checkIfNaN == null;
    }

    private static Integer checkValueOK(@Nullable Integer target) {
        if (target == null)
            return null;
        if (compareMinMax(target) != 0) {
            return compareMinMax(target) == -1 ? -1 : 1;
        }
        return 0;
    }

    private static Integer getInputValue(String inputValue, int defaultValue) {
        if (inputValue.trim().isEmpty())
            return defaultValue;
        try {
            return valueOf(inputValue);
        } catch (NumberFormatException nfe) {
            return null;
        }
    }

    private static int compareInputCompatibility(int candidates, int stepsBack) {
        if (candidates > stepsBack)
            return -1;
        if (candidates == 3)
            return 5;
        return 0;
    }


    private static void dump(String[] args) throws IllegalAccessException {
        if (args.length > 0) {
            System.exit(1);
        }
        System.out.println();
//        new a();
//        new ContactTest();
        Contact c1 = new Contact("gunnar", "carlsson");
        Contact c2 = new Contact("gunnar", "carlsson");
//        Contact c3 = c1;
//        Set<Contact> set = new HashSet<>();
//        System.out.println(Objects.equals(c1, c2));
//        set.add(c1);
//        set.add(c2);
//        set.add(c3);
//        System.out.println(set);
        boolean invokeEqual = false;
        String who = "banana";
        String strong = "is Strong";
        List<Method> methods = Arrays.asList(c1.getClass().getDeclaredMethods());
        List<Field> fields = Arrays.asList(c1.getClass().getDeclaredFields());
//        for (Method method : methods) {
//            if (method.getName().contains("get")) {
//                invokeEqual = method.invoke(c1, null) == method.invoke(c2, null);
//                if (!invokeEqual) {
//                    break;
//                }
//            }
//        }
//        System.out.println(invokeEqual);

        for (Field field : fields) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
                invokeEqual = Objects.equals(field.get(c1), field.get(c2));
                field.setAccessible(false);
            }
        }
        System.out.println(invokeEqual);
        try {
            System.out.println("\n" + fields.get(1).get(c1));
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
    }
}
