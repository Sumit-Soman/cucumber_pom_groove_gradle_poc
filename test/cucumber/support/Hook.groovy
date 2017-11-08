package support

import driver.DriverFactory
import pages.*
import static cucumber.api.groovy.Hooks.*
import cucumber.api.Scenario;
import util.Property


Before('@start') {

    def configData
    def user = ""
    File file = new File(Property.screenShotPath)
	if (!file.exists()){
		file.mkdir()
	}

    if (System.getProperty("test.env") == "QA_4.1") {
        configData = config.qa41Data
    }else if(System.getProperty("test.env") == "QA_4.0") {
	 	configData = config.qa40Data
    }else if(System.getProperty("test.env") == "UAT") {
	 	configData = config.uatData
    }else if(System.getProperty("test.env") == "DEV") {
	 	configData = config.devData
    }else if (System.getProperty("test.env") == "PROD") {
        configData = config.prodData
    } else {
        configData = config.devData
    }

    if (System.getProperty("test.app") == "external_callcenter") {
        user = "callcenter_user"
        SeleniumUtility.Internal= false
    } else if (System.getProperty("test.app") == "external_agency") {
        user = "agency_user"
        SeleniumUtility.Internal = false
    }else if(System.getProperty("test.app") == "internal") {
		user = "media_admin"
		SeleniumUtility.Internal= true
    }else {
        user = "media_admin"
        SeleniumUtility.Internal= true
    }
	
	def internal = SeleniumUtility.Internal
	
    SeleniumUtility.setXpath(internal)
    DriverFactory.createDriver(configData.toProperties(), internal)

    def login = new LoginPage()
    login.login(configData.toProperties(), user)
}

After(){scenario ->
	try{
		if(scenario.failed){
         DriverFactory.saveScreen(scenario)
		}
	}catch(Exception e){
		println e
	}
}





