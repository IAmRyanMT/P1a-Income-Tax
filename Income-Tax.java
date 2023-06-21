/*************
Task: Create a Program that Computes the Income Tax where

Annual Income Tax              Tax Rate          Annual Income Tax Valie
Php 250,000 below              0%                   -
Php 250,001 - 299,999          20%                 250,000
Php 300,000 above              30%                 300,000


Income Tax:
= ((Annual Net Income - Annual Income Tax Value) x 20)/12

To Compute the Annual Net Income, just add all the monthly net Income where years is equal to 12 months
*/

import java.util.*;
public class Main {
	public static void border() {
		for (int i = 0; i < 21; i++)
			System.out.print("•");
		System.out.println();
	}

	// Constructor
	public class Tax {
		// Variables
		private double [] monthly_net_income;
		private String [] months;
		double tax_rate;
		double annual_income_tax_value = 0;
		double income_tax = 0;

		// Constructor
		public Tax(double[] monthly_net_income, String[] months) {
			this.monthly_net_income = monthly_net_income;
			this.months = months;
		}

		// Setter
		public Tax set_monthly_net_income(double[] monthly_net_income) {
			this.monthly_net_income = monthly_net_income;
			return this;
		}

		// Getter
		public double[] get_monthly_net_income() {
			return monthly_net_income;
		}

		// Annual Net Income
		public double get_annual_net_income() {
			int sum = 0;
			for (int i = 0; i < monthly_net_income.length; i++) {
				sum += monthly_net_income[i];
			}
			return sum;
		}

		// Tax Rate
		public double get_tax_rate() {
			if (get_annual_net_income() >= 0 && get_annual_net_income() <= 250000)
				tax_rate = 0;
			else if (get_annual_net_income() > 250000 && get_annual_net_income() <= 300000)
				tax_rate = 0.2;
			else
				tax_rate = 0.3;
			return tax_rate;
		}

		// Annual Income Tax Value
		public double get_annual_income_tax_value() {
			if (get_annual_net_income() >= 0 && get_annual_net_income() <= 250000)
				annual_income_tax_value = 0;
			else if (get_annual_net_income() > 250000 && get_annual_net_income() <= 300000)
				annual_income_tax_value = 250000;
			else
				annual_income_tax_value = 300000;
			return annual_income_tax_value;
		}

		// Get Tax Exemption Case
		public boolean tax_exemption() {
			boolean state;
			if (get_tax_rate() == 0)
				state = true;
			else
				state = false;
			return state;
		}
		// Get Income Tax
		public double get_income_tax() {
			return ((get_annual_net_income() - get_annual_income_tax_value()) * get_tax_rate()) / monthly_net_income.length;
		}

		// Printing Values
		public void print_values() {
			String no_tax = "Tax Exempted";
			System.out.print("Annual Net Income: Php " + Math.round(get_annual_net_income() * 100.0) / 100.0);

			if (tax_exemption() == true)
				System.out.print("\nIncome Tax: Tax Exempted");
			else
				System.out.print("\nIncome Tax: Php " + Math.round(get_income_tax() * 100.0) / 100.0);
		}
	}

	// Driver Code
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Main method = new Main();

		border();
		System.out.println(" Compute Income Tax");
		border();
//		double [] monthly_net_income = {
//			28800, 28500, 28500,
//			28300, 28800, 28800,
//			28800, 28500, 28800,
//			28500, 28500, 28500
//		};

		String [] months = {
			"January", "February", "March",
			"April", "May", "June",
			"July", "August", "September",
			"October", "November", "December"
		};

		double [] monthly_net_income = new double[months.length];

		for (int i = 0; i < months.length; i++) {
			System.out.print(months[i] + ": ");
			monthly_net_income[i] = in.nextDouble();
		}
		border();

		Tax year = method.new Tax(monthly_net_income, months);
		year.set_monthly_net_income(monthly_net_income);
		year.print_values();
	}
}
