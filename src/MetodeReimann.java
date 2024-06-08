public class MetodeReimann {

    public static void main(String[] args) {
        double lowerBound = 0.0; // Lower bound of the integral
        double upperBound = 1.0; // Upper bound of the integral
        double result = 0;
        double rmsError = 0;
        for(int n = 10; n <= 10000; n = n*10) {
            result = riemannSum(lowerBound, upperBound, n);
            rmsError = calculateRMSError(3.14159265358979323846, result);
            System.out.println("Approximate integral value for N = " + n + " : " + result + " with RMS error value: " + rmsError);
        }
    }

    public static double function(double x) {
        return 4.0 / (1.0 + x * x); // Define the function f(x)
    }

    public static double riemannSum(double a, double b, int n) {
        double deltaX = (b - a) / n; // Width of each rectangle
        double sum = 0.0;

        for (int i = 0; i < n; i++) {
            double x = a + i * deltaX; // x-coordinate of the rectangle's left edge
            sum += function(x) * deltaX; // Area of the rectangle and add to sum
        }

        return sum;
    }

    public static double calculateTrueIntegral(double x) {
        return 4.0 * Math.atan(x); // True integral of the function
    }

    public static double calculateRMSError(double trueValue, double approximateValue) {
        return Math.sqrt(Math.pow(trueValue - approximateValue, 2)); // RMS error calculation
    }
}
