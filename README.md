# Pioneer_bdd
Pioneer Automation

Steps for starting the exeucions

1. Open CMD

2. Move to the Pioneer source folder. cd Pioneer_bdd

3. Run test from one of the following options:-
	
	
	grails test-app functional: -Dtest.env=QA -Dtest.app=ext_agency -Dtest.type=regression

	Parameter details:-

	Parameter name - test.env
	Values
	
		1 QA - run test on qa env
	
		2 PROD - run test on prod/uat env
	
		3 If this paramet not given then test will run on dev env


	Parameter name - test.app
	Values
	
		1 ext_agency - run test on external application as agency user
	
		2 ext_callcenter - run test on external application as callcenter user
	
		3 If this paramet not given then test will run on internal application as media admin user


	Parameter name - test.type
	Values
	
		1 regression - run regression test cases
	
		2 If this paramet not given then sanaity test cases will run

