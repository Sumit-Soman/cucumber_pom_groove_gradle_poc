package steps.regression

import static cucumber.api.groovy.EN.*
import pages.*
import driver.DriverFactory

def login=new LoginPage()

Given(~/^user logs in$/) {
	-> login.login()
}
