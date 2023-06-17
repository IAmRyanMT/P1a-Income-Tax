/*************
Task: Create a Program that Computes the Income Tax where

Annual Income Tax              Tax Rate          Annual Income Tax Valie
Php 250,000 below              0%                   -
Php 250,001 - 299,999          20%                 250,000
Php 300,000 above              30%                 300,000


Income Tax:
= ((Annual Next Income - Annual Income Tax Value) x 20)/12

To Compute the Annual Net Income, just add all the monthly net Income where years is equal to 12 months


*/

import java.util.*;
public class Main {


	public class Tax {
		Scanner scanner = new Scanner(System.in);
		private double [] monthly_net_income;
		private double sum = 0;
		private String [] months = {
		    "January", "February", "March",
		    "April", "May", "June",
		    "July", "August", "September",
		    "October", "November", "December"
		};
		
		
		public Tax(double[] monthly_net_income, double sum) {
			this.monthly_net_income = monthly_net_income;
			this.sum = sum;
		}
		
		public Tax set_monthly_net_income(double[] monthly_net_income) {
			this.monthly_net_income = monthly_net_income;
			return this;
		}
		
		public double[] get_monthly_net_income() {
			return monthly_net_income;
		}
		
		public double get_income_tax() {
		    for(int i=0; i<monthly_net_income.length; i++) {
		        sum += monthly_net_income[i];
		    }
		    return sum;
		}
		
		public void print_values() {
		    for(int i=0; i<12; i++){
		        System.out.println(months[i]+": "+monthly_net_income[i]);
		    }
		    System.out.println("Sum "+sum);
		}
		
		


	}

	// Driver Code
	public static void main(String[] args) {
	    Main method = new Main();
	    
	    double [] monthly_net_income = {
	        28000,28500,28500,
	        28300,28800,28800,
	        28500,28800,28500,
	        28500,28500,28500
	    };
	    double sum = 0;
	    
		Tax year = method.new Tax(monthly_net_income, sum);
		
		year.set_monthly_net_income(monthly_net_income);
		year.print_values();
	}
}
