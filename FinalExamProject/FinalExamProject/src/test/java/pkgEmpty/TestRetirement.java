package pkgEmpty;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pkgCore.Retirement;

public class TestRetirement {

	@Test
	public void testAmountToSave() {
		Retirement rtmt = new Retirement();
		rtmt.setToSaveValues(new double[] { 40, 7 });
		rtmt.setTotalAmountSavedValues(new double[] { 20, 2, 10000, 2642 });
		assertEquals(554.13, rtmt.AmountToSave(), 0.01);
	}

	@Test
	public void testTotalAmountSaved() {
		Retirement rtmt = new Retirement();
		rtmt.setTotalAmountSavedValues(new double[] { 20, 2, 10000, 2642 });
		assertEquals(1454485.55, rtmt.TotalAmountSaved(), 0.01);
	}

}
