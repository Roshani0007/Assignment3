package domain;

/***
 * @author Roshani 
 * @version 1.0
 * @created 05-may-2020 19:30:00am
 */
public class SchoolCommunity {

	private String classification;
	private String category;
	
	private static final double CIV_RATE= 0.0025;//0.25% GIVEN
	private static final double Industrial_Waste_Disposal_FEE=500.00;
	private static final int Industrial_Waste_Disposal_UNIT=2;
	
	private static final double FIRE_SERVICES_BASE=200;
	private static final double FIRE_SERVICES_PERCENT=0.0006;//0.006% GIVEN

	
	public SchoolCommunity(int category) {
		super();
		// this is explicit for the defaults strings
		this.setClassification("public");
		this.setCategory("Lower Secondary");
		
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

public void setCotegory(String category){
this.category = category;
}


public void setCategory(int category)
{
switch(category) {

case 1:
	this.categoryAmount=60;
    break;
case 2:
	this.categoryAmount=80;
	break;
case 3:
	this.categoryAmount=100;
	break;
     }
	
	}

@Override
public double calculateExtreServices() {
	//TODO auto-genertated method
	return industrialWasteDisposal calculateChargesForServiceType().calculateChargesForServiceTypefire
}

@Override
public String toString() {
	return super.toString()+"Industrial"[\n"+"
			+ " industrialWasteDisposal.toString()"
			+ "\n"+ fireServicesLevy.
	                                     ]
		
}

	
}




}
