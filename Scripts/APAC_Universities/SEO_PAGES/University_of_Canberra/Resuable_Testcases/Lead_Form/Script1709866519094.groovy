import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.github.javafaker.Faker


//Randomly selects the program from the drop-down
TestObject program = findTestObject('Object Repository/APAC_University/University_of_Canberra/Dropdown_Enquiry_Program')
WebUI.selectOptionByIndex(program,CustomKeywords.'keyPathPackage.customKeywords.selectRandomOptionFromDropdown'())

/*WebUI.delay(2)

TestObject dropdown = findTestObject('Object Repository/APAC_University/University_of_Canberra/Dropdown_Citizenship')
// Generate a random selection between Yes and No
String[] options = ['yes', 'no']
String randomOption = options[new Random().nextInt(options.length)]
WebUI.selectOptionByValue(dropdown, randomOption, true)*/

//if (randomOption.equals("yes")) {
	//WebUI.delay(2)
	
	// Use the custom keyword to generate a random FirstName and LastName
	String FirstName = CustomKeywords.'keyPathPackage.customKeywords.generateRandomFirstName'()
	WebUI.setText(findTestObject('Object Repository/APAC_University/University_of_Canberra/Field_FirstName'), FirstName)
	
	String LastName = CustomKeywords.'keyPathPackage.customKeywords.generateRandomLastName'()
	WebUI.setText(findTestObject('Object Repository/APAC_University/University_of_Canberra/Field_SecondName'), LastName)
	
	//Clicks the next step
	WebUI.waitForElementClickable(findTestObject('Object Repository/APAC_University/University_of_Canberra/Button_Nextstep2'), 10)
	WebUI.click(findTestObject('Object Repository/APAC_University/University_of_Canberra/Button_Nextstep2'))
	
	// Use the custom keyword to select a random startdate
	TestObject startdate = findTestObject('Object Repository/APAC_University/University_of_Canberra/Dropdown_Enquiry_StartDate')
	WebUI.selectOptionByIndex(startdate,CustomKeywords.'keyPathPackage.customKeywords.selectRandomOptionFromDropdown'())
	
	//Selects random EnquiryReason
	TestObject Enquiryreason = findTestObject('Object Repository/APAC_University/University_of_Canberra/Dropdown_EnquiryReason')
	WebUI.selectOptionByIndex(Enquiryreason, CustomKeywords.'keyPathPackage.customKeywords.selectRandomOptionFromDropdown'())
	
	WebUI.selectOptionByValue(findTestObject('Object Repository/APAC_University/University_of_Canberra/Dropdown_Enquiry_Leveleducation'),GlobalVariable.Education_Level, false)
	
	//Selects random work experience
	TestObject Workexperience = findTestObject('Object Repository/APAC_University/University_of_Canberra/Field_Enquiry_Workexperience')
	WebUI.selectOptionByIndex(Workexperience,CustomKeywords.'keyPathPackage.customKeywords.selectRandomOptionFromDropdown'())
	
	//Clicks the nextstep Now button
	WebUI.waitForElementClickable(findTestObject('Object Repository/APAC_University/University_of_Canberra/Button_Nextstep3'), 10)
	WebUI.click(findTestObject('Object Repository/APAC_University/University_of_Canberra/Button_Nextstep3'))
	
	// Use the custom keyword to generate a random Phone number
	String Phonenumber = CustomKeywords.'keyPathPackage.customKeywords.generateRandomAustralianPhoneNumber'()
	WebUI.setText(findTestObject('Object Repository/APAC_University/University_of_Canberra/Field_Phonenumber'), Phonenumber)
	
	// Use the custom keyword to generate a random email
	String Email = CustomKeywords.'keyPathPackage.customKeywords.generateRandomEmail'()
	WebUI.setText(findTestObject('Object Repository/APAC_University/University_of_Canberra/Field_Email'), Email)
	
	// Use the custom keyword to generate a post number
	String Postcode = CustomKeywords.'keyPathPackage.customKeywords.selectRandomPostCode'()
	WebUI.setText(findTestObject('Object Repository/APAC_University/University_of_Canberra/Field_Postcode'), Postcode)
	
	
	//Clicks the Submit buttono
	WebUI.waitForElementClickable(findTestObject('Object Repository/APAC_University/University_of_Canberra/Button_Submit'), 10)
	WebUI.click(findTestObject('Object Repository/APAC_University/University_of_Canberra/Button_Submit'))
	
	//Verify if the Thank you for enquiry content is displayed
	WebUI.delay(5)
	WebUI.verifyElementText(findTestObject('Object Repository/APAC_University/University_of_Canberra/Verify_Content'), 'Thank you for your enquiry!')
//}
//else {
	//WebUI.closeBrowser()
//}

//*/


