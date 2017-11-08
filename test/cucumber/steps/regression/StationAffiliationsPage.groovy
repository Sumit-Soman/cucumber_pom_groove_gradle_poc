package steps.regression

import driver.DriverFactory
import static cucumber.api.groovy.EN.*
import pages.*
import cucumber.api.DataTable
import junit.framework.Assert;
import static org.junit.Assert.assertTrue;

def stationaffiliation = new StationAffiliations()
def utility = new SeleniumUtility()
def locatorTypeObj = new LocatorType();


Given(~/^user is on Station Affiliations Page$/) { ->
	utility.openPage("//ul[@class=\"megamenu\"]/li[1]","Station Affiliations")
}


Then(~/^user verify the added Affiliation on Station Affiliations Page$/) { 
	 ->	stationaffiliation.verifyAffiliation()
}

Given(~/^user adds Affiliation on Station Affiliations Page$/) { DataTable enterValues
	->	stationaffiliation.enterStationAffiliation(enterValues)
}