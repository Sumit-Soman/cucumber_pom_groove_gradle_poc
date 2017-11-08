package steps

import static cucumber.api.groovy.EN.*
import static org.junit.Assert.assertTrue;
import java.beans.PropertyChangeEvent;
import junit.framework.Assert;
import pages.*
import cucumber.api.DataTable

def utility = new SeleniumUtility()
def locatorTypeObj = new LocatorType();
def createEditStationTranslations =  new CreateEditStationTranslations();


Given(~/^user is on Station Translation Page$/) {
	->	utility.openPage("//ul[@class='megamenu']/li[1]","Station Translations")
}

Then(~/^user verify the no Station Translation exist on Search Station Affiliations Page$/){
	-> def String msg = createEditStationTranslations.getStatus()
		assertTrue("Station Translation already exist.", msg.contains('No'))
}

Given(~/^user adds Station, Agency, Agency Code on Station Translations Page$/) { DataTable values
	->  createEditStationTranslations.searchStationTranslation(values)
		createEditStationTranslations.clickSearch()
		def String msg = createEditStationTranslations.getStatus()
		assertTrue("Station Translation already exist with input station and Agency.", msg.contains('No'))
}

Given(~/^user click on Create Station Translation$/) {
	->	utility.clickElement(locatorTypeObj.classtype, "customButton")
}

Given(~/^user adds Station name, Agency and Code on Create Station Translation Page$/) {DataTable values
	->	createEditStationTranslations.createTranslation(values)
}

Then(~/^user verifies newly created Station Translation$/){DataTable values
	-> createEditStationTranslations.searchStationTranslation(values)
		createEditStationTranslations.clickSearch()
		def String msg = createEditStationTranslations.getStatus()
		assertTrue("Station Tranlsation Creation failed", msg.equalsIgnoreCase('1 Station Translation(s)'))
}



