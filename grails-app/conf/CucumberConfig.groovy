cucumber {
	
    if (System.getProperty("test.type") == "regression"){
       features = ["test/cucumber/features/regression", "test/cucumber/steps/regression", "test/cucumber/support"]
       glue = features
    }else{
       features = ["test/cucumber/features/sanity", "test/cucumber/steps/sanity", "test/cucumber/support"]    
       glue = features
    }
    
    tags = ["~@notImplemented", "~@ignored"]
    
	
	// If test.env is empty then default is dev environment
    if (System.getProperty("test.env") == "PROD"){
        tags.add("@prod")
    }else if(System.getProperty("test.env") == "QA_4.1"){
        tags.add("@qa")        
    }else if(System.getProperty("test.env") == "QA_4.0"){
        tags.add("@qa")        
    }else if(System.getProperty("test.env") == "UAT"){
        tags.add("@qa")        
    }else if(System.getProperty("test.env") == "DEV"){
        tags.add("@dev")        
    }else{
        tags.add("@dev")
    }
	
	// If test.type is not provided then @int tag is added by default
    if (System.getProperty("test.app") == "external_agency") {
        tags.add("@ext_agency")
    }else if(System.getProperty("test.app") == "external_callcenter") {
        tags.add("@ext_callcenter")        
    }else if(System.getProperty("test.app") == "internal") {
        tags.add("@int")
    }else{
    	tags.add("@int")
	}
	//tags.add("@new")
}