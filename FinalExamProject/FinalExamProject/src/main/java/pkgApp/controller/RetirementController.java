package pkgApp.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pkgApp.RetirementApp;
import pkgCore.Retirement;

public class RetirementController implements Initializable {

	private RetirementApp mainApp = null;

	@FXML
	private Label lblSaveEachMonth;
	@FXML
	private Label lblToSave;

	@FXML
	private TextField txtYearsToWork;
	@FXML
	private TextField txtAnnualReturn1;

	@FXML
	private TextField txtYearsRetired;
	@FXML
	private TextField txtAnnualReturn2;
	@FXML
	private TextField txtRequiredIncome;
	@FXML
	private TextField txtMonthlySSI;

	ArrayList<TextField> toSaveFields;
	ArrayList<TextField> totalAmountSavedFields;
	ArrayList<TextField> textFields;
	ArrayList<Label> labels;

	Retirement retirement;

	public RetirementApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(RetirementApp mainApp) {
		this.mainApp = mainApp;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		toSaveFields = new ArrayList<TextField>();
		totalAmountSavedFields = new ArrayList<TextField>();
		textFields = new ArrayList<TextField>();
		labels = new ArrayList<Label>();

		toSaveFields.add(txtYearsToWork);
		toSaveFields.add(txtAnnualReturn1);
		totalAmountSavedFields.add(txtYearsRetired);
		totalAmountSavedFields.add(txtAnnualReturn2);
		totalAmountSavedFields.add(txtRequiredIncome);
		totalAmountSavedFields.add(txtMonthlySSI);

		textFields.addAll(toSaveFields);
		textFields.addAll(totalAmountSavedFields);

		labels.add(lblSaveEachMonth);
		labels.add(lblToSave);

		retirement = new Retirement();
	}

	@FXML
	public void btnClear(ActionEvent event) {
		for (TextField field : textFields) {
			field.clear();
		}

		for (Label label : labels) {
			label.setText("");
		}

		retirement.clear();

		System.out.println("Clear pressed");
	}

	@FXML
	public void btnCalculate(ActionEvent event) {

		double[] toSaveVals = new double[toSaveFields.size()];
		double[] totalAmountSavedVals = new double[totalAmountSavedFields.size()];

		for (TextField field : textFields) {
			if (field.getText().equals("") || !(field.getText().matches(".*\\d+.*"))) {
				lblSaveEachMonth.setText("Make sure there are numbers in every field!");

				System.out.println("A field does not have numbers.");
				return;
			}
		}

		for (int i = 0; i < toSaveVals.length; i++) {
			toSaveVals[i] = Double.valueOf(toSaveFields.get(i).getText());
		}
		for (int i = 0; i < totalAmountSavedVals.length; i++) {
			totalAmountSavedVals[i] = Double.valueOf(totalAmountSavedFields.get(i).getText());
		}

		retirement.setToSaveValues(toSaveVals);
		retirement.setTotalAmountSavedValues(totalAmountSavedVals);

		double dSaveEachMonth = retirement.AmountToSave();
		double dToSave = retirement.TotalAmountSaved();

		String saveEachMonth = String.valueOf(dSaveEachMonth);
		String toSave = String.valueOf(dToSave);

		lblSaveEachMonth.setText(saveEachMonth);
		lblToSave.setText(toSave);

		System.out.println("Calculate pressed");
	}

}
