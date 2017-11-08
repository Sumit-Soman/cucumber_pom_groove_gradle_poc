package steps.regression

import static cucumber.api.groovy.EN.*
import pages.*
import driver.DriverFactory

def utility = new SeleniumUtility()

Given(~/^Quit Session and Close$/) { 
	-> utility.logOut()
}
