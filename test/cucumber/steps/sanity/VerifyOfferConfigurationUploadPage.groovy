package steps.sanity

import static cucumber.api.groovy.EN.*
import pages.*
import cucumber.api.DataTable

def utility = new SeleniumUtility()
def loc = new LocatorType();

Given(~/^user is on Offer Configuration Upload Page$/) { ->
    utility.openPage("//*[@id='megamenu']/li[2]/h2","Offer Configuration Upload") 
}

Given(~/^user searches Cancel button on Offer Configuration Upload Page$/) { ->
   utility.clickElement(loc.xpath,"//*[contains(@class,'prop_search')]/div/form/div/input[5]");
}