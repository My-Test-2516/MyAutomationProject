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
TestObject program = findTestObject('Object Repository/APAC_University/Victoria_University/Dropdown_Program')
WebUI.selectOptionByIndex(program,CustomKeywords.'keyPathPackage.customKeywords.selectRandomOptionFromDropdown'())

// Use the custom keyword to generate a random FirstName and LastName
String FirstName = CustomKeywords.'keyPathPackage.customKeywords.generateRandomFirstName'()
WebUI.setText(findTestObject('Object Repository/APAC_University/Victoria_University/Field_Firstname'), FirstName)

String LastName = CustomKeywords.'keyPathPackage.customKeywords.generateRandomLastName'()
WebUI.setText(findTestObject('Object Repository/APAC_University/Victoria_University/Field_Lastname'), LastName)

//Selects the Citizen qualification
TestObject dropdown = findTestObject('Object Repository/APAC_University/Victoria_University/Dropdown_Citizen_Qualify')

// Logic added: If the system selects the value "no" then it will verify the Pop up message and it will close the browser
//in this case the system will automatically selects the option randomly
//If the System  selects "yes" then it will continue with next steps
String[] options = ['yes', 'no']
String randomOption = options[new Random().nextInt(options.length)]
WebUI.selectOptionByValue(dropdown, randomOption, true)

if (randomOption.equals("no")) {
	WebUI.delay(3)
	WebUI.verifyElementText(findTestObject('Object Repository/APAC_University/Victoria_University/Verify_Popup_Message'), 'This course is available to Australian citizens and permanent residents only.')
	//Close browser
	WebUI.closeBrowser()
	}
else {
//Clicks the next step
WebUI.waitForElementClickable(findTestObject('Object Repository/APAC_University/Victoria_University/Button_NextStep2'), 10)
WebUI.click(findTestObject('Object Repository/APAC_University/Victoria_University/Button_NextStep2'))

// Use the custom keyword to select a random startdate
TestObject startdate = findTestObject('Object Repository/APAC_University/Victoria_University/Dropdown_Startdate')
WebUI.selectOptionByIndex(startdate,CustomKeywords.'keyPathPackage.customKeywords.selectRandomOptionFromDropdown'())

//Selects random EnquiryReason
TestObject Enquiryreason = findTestObject('Object Repository/APAC_University/Victoria_University/Dropdown_Enquiry')
WebUI.selectOptionByIndex(Enquiryreason, CustomKeywords.'keyPathPackage.customKeywords.selectRandomOptionFromDropdown'())

WebUI.selectOptionByValue(findTestObject('Object Repository/APAC_University/Victoria_University/Dropdown_Highereducation'),GlobalVariable.Education_Level, false)

//Selects random work experience
TestObject Workexperience = findTestObject('Object Repository/APAC_University/Victoria_University/Dropdown_Workexperience')
WebUI.selectOptionByIndex(Workexperience,CustomKeywords.'keyPathPackage.customKeywords.selectRandomOptionFromDropdown'())

//Clicks the nextstep Now button
WebUI.waitForElementClickable(findTestObject('Object Repository/APAC_University/Victoria_University/Button_Nextstep3'), 10)
WebUI.click(findTestObject('Object Repository/APAC_University/Victoria_University/Button_Nextstep3'))

// Use the custom keyword to generate a random email
String Email = CustomKeywords.'keyPathPackage.customKeywords.generateRandomEmail'()
WebUI.setText(findTestObject('Object Repository/APAC_University/Victoria_University/Field_Email'), Email)

WebUI.selectOptionByLabel(findTestObject('Object Repository/APAC_University/Victoria_University/Dropdown_Country'),'Australia', false)

// Use the custom keyword to generate a post number
String Postcode = CustomKeywords.'keyPathPackage.customKeywords.selectRandomPostCode'()
WebUI.setText(findTestObject('Object Repository/APAC_University/Victoria_University/Field_Postcode'), Postcode)

// Use the custom keyword to generate a random Phone number
String Phonenumber = CustomKeywords.'keyPathPackage.customKeywords.generateRandomAustralianPhoneNumber'()
WebUI.setText(findTestObject('Object Repository/APAC_University/Victoria_University/Field_Phonenumber'), Phonenumber)

//Clicks the Submit buttono
WebUI.waitForElementClickable(findTestObject('Object Repository/APAC_University/Victoria_University/Button_Submit'), 10)
WebUI.click(findTestObject('Object Repository/APAC_University/Victoria_University/Button_Submit'))

//Verify if the Thank you for enquiry content is displayed
WebUI.delay(5)
WebUI.verifyElementText(findTestObject('Object Repository/APAC_University/Victoria_University/Verify_Content'), 'THANKS FOR YOUR ENQUIRY')
}