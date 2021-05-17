package controller;

import utility.Security;

public class SecretWriting {

	public static void main(String[] args) {
		String clinicalTrialData = "Drug: Placebo\n Saline for injection.\n\nBiological: SARS-CoV"
				+ "\n Whole-virus vaccine, grown in certified Vero cells and doubly inactivated by treatment "
				+ "with formalin and ultraviolet light (UV). Supplied in liquid formulation in single dose "
				+ "vials with and without aluminum hydroxide as an adjuvant. Doses supplied without aluminum "
				+ "hydroxide will be 2.5, 5.0 and 10.0 mcg. Doses supplied with aluminum hydroxide adjuvant "
				+ "will be 2.5 and 5.0 mcg.";
		
		String secretData = Security.encrypt(clinicalTrialData);
		System.out.println(secretData);

	}

}
