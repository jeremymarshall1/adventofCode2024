import java.util.Objects;

class Main {
    public static void main(String[] args) {
        String className = "";
        Object tests;
        boolean single = false;

        // Check for any command-line arguments
        // 1st - Day # to run
        // 2nd + - arguments for that problem's class
        // This logic will set the problem to run as well as remove it from the args
        if (args.length > 0) {
            System.out.println("Running Day " + args[0] + ": ");
            className = "day" + args[0];
            String[] argsTemp = new String[args.length - 1];
            System.arraycopy(args, 1, argsTemp, 0, argsTemp.length);
            args = argsTemp;
            single = true;
        }

        try {
            for (int x = 1;; x++){
                // If a command-line argument was passed in, don't iterate through all classes
                if (!single) {
                    className = "day" + x;
                }

                tests = Class.forName(className).getDeclaredConstructor().newInstance();
                System.out.print(tests.getClass().getName() + ": \n");
                tests.getClass().getMethod("solve",String[].class).invoke(tests, new Object[]{args});



                // If a command-line argument was passed in, only do the specified problem
                if (single) {
                    break;
                }

            }
        } catch (Exception err) {
            if (Objects.equals(err.getClass().getName(), "java.lang.ClassNotFoundException")) {
                System.out.println("There are no more tests");
            } else {
                System.out.println(err.getCause());
                System.out.println("Error!");
            }


        }
    }
}