package pages;

import java.util.Map;
import util.Property;
import cucumber.api.DataTable;

public class CreateEditStationTranslations {
	
	SeleniumUtility utility =  new SeleniumUtility();
	LocatorType locatorTypeObj = new LocatorType();
	ExplicitConditionType explicitCondTypeobj = new ExplicitConditionType();
	
	public void searchStationTranslation(DataTable values){
		utility.pageLoadTimeout();
		Map<String,String> translationMap =values.asMap(String.class, String.class);
		
		String station = translationMap.get("Translation");
		String agency=translationMap.get("Agency");
		String agencyCode=translationMap.get("Agency Station Code");
		
		if(station!=""){
			utility.enterTextAuto(locatorTypeObj.id, "name", station );
		}
		
		if(agency!=""){
			utility.enterTextAuto(locatorTypeObj.id, "agency", agency );
		}
		
		if(agencyCode.equalsIgnoreCase("Property")){
			utility.enterText(locatorTypeObj.id, "translation", Property.stationCode);
		}else if(agencyCode!=""){
			utility.enterText(locatorTypeObj.id, "translation", Property.stationCode);
			Property.stationCode = station;
		}
	}
	
	public void clickSearch(){
		utility.clickElement(locatorTypeObj.id, "search");
	}
	
	public String getStatus(){
		utility.explicitWait(explicitCondTypeobj.elementisinvisible, locatorTypeObj.id, "spinner",null );
		return utility.getText(locatorTypeObj.classtype, "listCount");
		
	}
	
	public void createTranslation(DataTable values){
		utility.pageLoadTimeout();
		Map<String,String> translationMap =values.asMap(String.class, String.class);
		String station = translationMap.get("Translation");
		String agency=translationMap.get("Agency");
		String agencyCode=translationMap.get("Agency Station Code");
		
		if(station!=""){
			utility.enterTextAuto(locatorTypeObj.id, "station", station);
		}else if (station!=""){
			utility.enterTextAuto(locatorTypeObj.id, "station", station);
		}
		
		if(agency!=""){
			utility.enterTextAuto(locatorTypeObj.id, "mediaCompany", agency );
		}
		
		if(agencyCode!=""){
			utility.enterText(locatorTypeObj.id, "translation", agencyCode +Property.stationCode );
		}
		
		utility.clickElement(locatorTypeObj.classtype, "cta_button");
		
	}
}
