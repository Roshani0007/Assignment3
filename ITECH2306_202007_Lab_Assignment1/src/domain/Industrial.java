package domain;

/**
 * @author Yangji
 */
public class Industrial extends Property {
	
	private String hazardType;
	private String vehicleType;

	private static final double CIV_RATE = 0.0059; //0.59% this is Given
	private static final int INDUSTRIAL_WASTE_MANAGEMENT_UNITS = 4;
	private static final double INDUSTRIAL_WASTE_MANAGEMENT_FEES = 500.00;
	private static final double FIRE_SERVICE_BASE = 200;
	private static final double FIRE_SERVICE_PERCENT = 0.00006;
	private ServiceType industrialWasteManagement;
	private ServiceType fireServiceLevy;
	
	public Industrial() {
		super();
		// We are explicit about our defaults for Strings
		this.setHazardType("physical");
		this.setVehicleType("heavy");
		setCapitalImprovedRate(CIV_RATE);
	}
	public String getHazardType() {
		return hazardType;
	}

	public void setHazardType(String hazardType) {
		this.hazardType = hazardType;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	
	@Override
	public void setUpExtraServices() {
		// At this stage,with the given information we are calculating.
		industrialWasteManagement = new UnitAndRateService("Industrial Waste Management",
				  INDUSTRIAL_WASTE_MANAGEMENT_UNITS,
				  INDUSTRIAL_WASTE_MANAGEMENT_FEES);
		fireServiceLevy = new BaseAndPercentageOfValueService("Fire Levy",
										FIRE_SERVICE_BASE,
										FIRE_SERVICE_PERCENT,
										getCapitalImprovedValue());
	}
	
	@Override
	public double calculateExtraServices() {
		
		return industrialWasteManagement.calculateChargeForServiceType() +
			   fireServiceLevy.calculateChargeForServiceType();
	}

	@Override
	public String toString() {
		return  super.toString() + "Industiral [\n" + 
							industrialWasteManagement.toString() + "\n" +
								fireServiceLevy.toString() + " ]\n ";
	}

	

