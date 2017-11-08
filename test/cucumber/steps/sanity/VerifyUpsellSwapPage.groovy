package steps.sanity

import static cucumber.api.groovy.EN.*
import pages.*
import cucumber.api.DataTable

def utility = new SeleniumUtility()
def loc = new LocatorType();

Given(~/^user is on UpsellSwap Page$/) { ->
    utility.openPage("//*[@id='megamenu']/li[2]/h2","Upsell Swaps") 
}

Given(~/^user searches Product Textbox on UpsellSwap Page$/) { ->
    utility.clickElement(loc.xpath,"//*[contains(@class,'form-input')]/select");
}