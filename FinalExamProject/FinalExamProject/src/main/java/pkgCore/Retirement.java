package pkgCore;

import java.text.DecimalFormat;

import org.apache.poi.ss.formula.functions.FinanceLib;

public class Retirement {

	private int iYearsToWork;
	private double dAnnualReturnWorking;
	private int iYearsRetired;
	private double dAnnualReturnRetired;
	private double dRequiredIncome;
	private double dMonthlySSI;

	private DecimalFormat df;

	public Retirement() {
		clear();
		df = new DecimalFormat("0.00");

	}

	public void clear() {
		this.iYearsToWork = 0;
		this.dAnnualReturnWorking = 0;

		this.iYearsRetired = 0;
		this.dAnnualReturnRetired = 0;
		this.dRequiredIncome = 0;
		this.dMonthlySSI = 0;
	}

	public void setToSaveValues(double[] values) {
		if (values.length == 2) {
			iYearsToWork = (int) values[0];
			dAnnualReturnWorking = values[1];

			if (dAnnualReturnWorking > 1) {
				dAnnualReturnWorking /= 100;
			}
		}
	}

	public void setTotalAmountSavedValues(double[] values) {
		if (values.length == 4) {
			iYearsRetired = (int) values[0];
			dAnnualReturnRetired = values[1];
			dRequiredIncome = values[2];
			dMonthlySSI = values[3];

			if (dAnnualReturnRetired > 1) {
				dAnnualReturnRetired /= 100;
			}
		}
	}

	public double AmountToSave() {
		System.out.println("Years to Work: " + iYearsToWork);
		System.out.println("Annual Return Working: " + dAnnualReturnWorking);

		Double expected = Math
				.abs(FinanceLib.pmt(dAnnualReturnWorking / 12, iYearsToWork * 12, 0, TotalAmountSaved(), false));

		String result = df.format(expected);

		expected = Double.valueOf(result);

		System.out.println("Amount To Save: " + expected);

		return expected;
	}

	public double TotalAmountSaved() {
		System.out.println("Years Retired: " + iYearsRetired);
		System.out.println("Annual Return Retired: " + dAnnualReturnRetired);
		System.out.println("Required Income: " + dRequiredIncome);
		System.out.println("Monthly SSI: " + dMonthlySSI);

		Double expected = Math.abs(
				FinanceLib.pv(dAnnualReturnRetired / 12, iYearsRetired * 12, dRequiredIncome - dMonthlySSI, 0, false));

		String result = df.format(expected);

		expected = Double.valueOf(result);

		System.out.println("total Amount Saved: " + expected);

		return expected;
	}

	public int getiYearsToWork() {
		return iYearsToWork;
	}

	public void setiYearsToWork(int iYearsToWork) {
		this.iYearsToWork = iYearsToWork;
	}

	public double getdAnnualReturnWorking() {
		return dAnnualReturnWorking;
	}

	public void setdAnnualReturnWorking(double dAnnualReturnWorking) {
		this.dAnnualReturnWorking = dAnnualReturnWorking;
	}

	public int getiYearsRetired() {
		return iYearsRetired;
	}

	public void setiYearsRetired(int iYearsRetired) {
		this.iYearsRetired = iYearsRetired;
	}

	public double getdAnnualReturnRetired() {
		return dAnnualReturnRetired;
	}

	public void setdAnnualReturnRetired(double dAnnualReturnRetired) {
		this.dAnnualReturnRetired = dAnnualReturnRetired;
	}

	public double getdRequiredIncome() {
		return dRequiredIncome;
	}

	public void setdRequiredIncome(double dRequiredIncome) {
		this.dRequiredIncome = dRequiredIncome;
	}

	public double getdMonthlySSI() {
		return dMonthlySSI;
	}

	public void setdMonthlySSI(double dMonthlySSI) {
		this.dMonthlySSI = dMonthlySSI;
	}
}
