package domain;

/***
 * @author Roshani and Yangji 
 * @version 1.0
 * @created 05-may-2020 19:30:00am
 */
public class SchoolCommunity extends Property{

	private String classification;
	private String category;
	
	private static final double CIV_RATE= 0.0025; //0.25%
	private static final double Industrial_Waste_Disposal_FEE=500.00;
	private static final int Industrial_Waste_Disposal_UNIT=2;
	private static final double FIRE_SERVICES_BASE=200;
	private static final double FIRE_SERVICES_PERCENT=0.0006;//0.006% GIVEN
	private static final double TRAFFIC_MANAGEMENT_BASE=200;
	private double categoryAmount;

	private ServiceType industrialWasteManagement;
	private ServiceType fireServicesLevy;
	private ServiceType trafficManagementLevy;

	
	public SchoolCommunity(int categoryA) {
		super();
		// this is explicit for the defaults strings
		this.setClassification("local");
		this.setCategory("KG");
		
	setCapitalImprovedRate(CIV_RATE);
}


public String getClassification() {
	return classification;
}


public void setClassification(String classification) {
this.classification = classification;
}

public String getCategory() {
	return category;
}

public void setCategory(String category){
this.category = category;
}
public double getCategoryA() {
	return categoryAmount;
}

public void setCategoryA(int categoryA)
{
switch(categoryA) {

case 1:
	this.categoryAmount=60.00;
    break;
case 2:
this.categoryAmount=80.00;
	break;
case 3:
this.categoryAmount=100.00;
	break;
     
}
	}
	
	@Override
	public double calculateExtraServices() {
		// 
		return industrialWasteManagement.calculateChargeForServiceType() +
			   fireServicesLevy.calculateChargeForServiceType()+
			   trafficManagementLevy.calculateChargeForServiceType();
	}

	@Override
	public void setUpExtraServices() {
		//
		industrialWasteManagement= new UnitAndRateService("Industrial Waste Management",
				Industrial_Waste_Disposal_UNIT,
				Industrial_Waste_Disposal_FEE);
		
		
		fireServicesLevy = new BaseAndPercentageOfValueService("Fire  Srvice Levy",
				FIRE_SERVICES_BASE,
				FIRE_SERVICES_PERCENT,
				getCapitalImprovedValue());
		trafficManagementLevy=new BaseAndExtraService("traffic Management Levvy",TRAFFIC_MANAGEMENT_BASE+categoryAmount,0);	
	}
	@Override
		public String toString()
		{
		return super.toString()+"SchoolCommunity [\n"+
		industrialWasteManagement.toString()+"\n"+
				fireServicesLevy.toString()+"\n"+
		trafficManagementLevy.toString()+"]\n";
		
		
		
		
		}



}
