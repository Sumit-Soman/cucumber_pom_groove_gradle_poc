package steps.sanity

import static cucumber.api.groovy.EN.*
import pages.*
import cucumber.api.DataTable

def utility = new SeleniumUtility()
def loc = new LocatorType();

Given(~/^user is on Swaps Page$/) { ->
   utility.openPage("//*[@id='megamenu']/li[2]/h2","Swaps") 
}

Given(~/^user searches Textbox on Swaps Page$/) { ->
   utility.clickElement(loc.xpath,"//*[contains(@class,'form-input')]/div[2]/input");
}