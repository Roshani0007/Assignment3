package domain;

/**
 * @author Roshani
 * @version 1.0
 * @created 13-May-2020 10:30:00am
 */
 public class Hospital{
    	
	private String facilities;
	private int floorNumber;
	private String status;
	
	private static final double CIV_RATE = 0.0035; // 0.35% Given
	private static final int INDUSTRIAL_WASTE_DISPOSAL_UNITS = 4;
	private static final double INDUSTRIAL_WASTE_DISPOSAL_FEES = 500.00;
	private static final double FIRE_SERVICES_LEVY_BASE = 200;
	private static final double FIRE_SERVICES_LEVY_PERCENT = 0.00006;
	private ServiceType industiralWasteManagement;
	private ServiceType fireServicesLevy;
	
	public Hospital() {
		super();
		// We are explicit about our defaults for Strings
		this.setFacilities("Nurse");
		this.setFloorNumber("07");
		setCapitalImprovedRate(CIV_RATE);
	}
	
	public String getFacilities() {
		return facilities;
	}

	public void setFacilities() {
		this.facilities = facilities;
	}

	public int getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber() {
		this.floorNumber = floorNumber;
	}
	
	@Override
	public void setUpExtraServices() {
		// we have all the given vaules, and going to input for the results.
		industiralWasteManagement = new UnitAndRateService("Industiral Waste Management",
				INDUSTRIAL_WASTE_MANAGEMENT_UNITS,
				INDUSTRIAL_WASTE_MANAGEMENT_FEES);
		fireServicesLevy = new BaseAndPercentageOfValueService("Fire Levy",
																FIRE_SERVICES__LEVY_BASE,
																FIRE_SERVICES_LEVY_PERCENT,
																getCapitalImprovedValue());
	}
	
	@Override
	public double calculateExtraServices() {
		
		return industrialWasteManagement.calculateChargeForServiceType() +
			   fireServicesLevy.calculateChargeForServiceType();
	}

	@Override
	public String toString() {
		return  super.toString() + "Hospital2 [\n" + 
									industriaWasteManagement.toString() + "\n" +
									fireServicesLevy.toString() + " ]\n ";
	}

}


