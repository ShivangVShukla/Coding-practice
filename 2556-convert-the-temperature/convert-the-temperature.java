class Solution {
    public double[] convertTemperature(double celsius) {
        double[] soln = new double[2];
        double K = celsius+273.15;
        double fh = (celsius*1.80)+32.00;
        soln[0] = K;
        soln[1] = fh;
        return soln;
    }
}