package org.example;

import java.text.DecimalFormat;

public class LRwIter {
    double w0 = 0, w1 = 0, eta;
    double [][] p;


    LRwIter (double [][] p, double eta) {
        this.p = p;
        this.eta = eta;
        solve();
    }

    void solve () {
        for (int i = 0; i < 10000; i++) {
            this.w0 -= this.eta*jw0();
            this.w1 -= this.eta*jw1();
        }
    }

    private double jw0 () {
        double S = 0;
        for (int i = 0; i < this.p.length; i++) {
            S += this.p[i][1]-w0-w1*this.p[i][0];
        }
        return -S/this.p.length;
    }

    private double jw1 () {
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
