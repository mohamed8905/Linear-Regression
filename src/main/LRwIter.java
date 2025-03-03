package org.example;

import java.text.DecimalFormat;

public class LRwIter {
    double w0 = 0, w1 = 0, eta;
    double[][] p;

    LRwIter(double[][] p, double eta) {
        this.p = p;
        this.eta = eta;
        solve();
    }

    void solve() {
        double prevW0, prevW1;
        double epsilon = 1e-10; 
        int maxIter = 10000;   

        for (int i = 0; i < maxIter; i++) {
            prevW0 = w0;
            prevW1 = w1;
            
            w0 -= eta * jw0();
            w1 -= eta * jw1();
            
            // Check if changes are small enough to stop
            if (Math.abs(w0 - prevW0) < epsilon && 
                Math.abs(w1 - prevW1) < epsilon) {
                break;
            }
        }
    }

    private double jw0() {
        double S = 0;
        for (int i = 0; i < this.p.length; i++) {
            S += this.p[i][1]-w0-w1*this.p[i][0];
        }
        return -S/this.p.length;
    }

    private double jw1() {
        double S = 0;
        for (int i = 0; i < this.p.length; i++) {
            S += (this.p[i][1]-w0-w1*this.p[i][0])*this.p[i][0];
        }
        return -S/this.p.length;
    }

    void display() {
        DecimalFormat df = new DecimalFormat("#.####");

        System.out.println("The Linear Equation is: ");
        System.out.println("Y = " + df.format(this.w0) + " + " + df.format(this.w1) + " X");
    }
}
