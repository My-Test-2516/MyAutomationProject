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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.WebElement




// line 31 to 45 is for randomly selecting the dropdown for programs
// Locate the select element using the Test Object created
TestObject selectTestObject = findTestObject('Object Repository/APAC_University/SUN_University/Dropdown_Program')
// Get the WebElement of the select
WebElement selectElement = WebUI.findWebElement(selectTestObject, 0)
// Create a Select object
Select select = new Select(selectElement)
// Get all available options
List<WebElement> optionsrandom = select.getOptions()
// Filter out the first option if it's a placeholder or empty
List<WebElement> validOptions = optionsrandom.findAll { it.getAttribute('value') != '' }
// Randomly select one of the valid options
Random randomdropdown = new Random()
WebElement randomOptiondropdown = validOptions[randomdropdown.nextInt(validOptions.size())]
// Set the select element to the random option
select.selectByValue(randomOptiondropdown.getAttribute('value'))


// Use the custom keyword to generate a random email
String Email = CustomKeywords.'keyPathPackage.customKeywords.generateRandomEmail'()
WebUI.setText(findTestObject('Object Repository/APAC_University/SUN_University/Field_Email'), Email)

// Use the custom keyword to generate a Malaysian post number
String Postcode = CustomKeywords.'keyPathPackage.customKeywords.selectRandomPostCodes'()
WebUI.setText(findTestObject('Object Repository/APAC_University/SUN_University/Field_Postcode'), Postcode)

//Clicks the next step button
WebUI.waitForElementClickable(findTestObject('Object Repository/APAC_University/SUN_University/Button_Nextstep1'), 10)
WebUI.click(findTestObject('Object Repository/APAC_University/SUN_University/Button_Nextstep1'))

//Selects the highes level Educatio
TestObject dropdown = findTestObject('Object Repository/APAC_University/SUN_University/Dropdown_highereducation')

// Logic added: If the system selects the value diploma then new Dropdown called "do you have APEL" appears with yes, no and unsure options,
//in this case the system will automatically selects the option randomly
//If the System  selects other option other than dipoloma then it will skip to select start date field.
String[] options = ['High school', 'Diploma', 'Bachelors degree', 'Masters Degree']
String randomOption = options[new Random().nextInt(options.length)]
WebUI.selectOptionByValue(dropdown, randomOption, true)

if (randomOption.equals("Diploma")) {
	WebUI.delay(3)
	TestObject APELdropdown = findTestObject('Object Repository/APAC_University/SUN_University/Dropdown_APEL')
	String[] APELoptions = ['Yes', 'No', 'Unsure']
	String APELrandomOption = APELoptions[new Random().nextInt(APELoptions.length)]
	WebUI.selectOptionByValue(APELdropdown, APELrandomOption, true)
	
}

TestObject startdate = findTestObject('Object Repository/APAC_University/SUN_University/Dropdown_Startdate')
WebUI.selectOptionByIndex(startdate,CustomKeywords.'keyPathPackage.customKeywords.selectRandomOptionFromDropdown'())

TestObject Englishlevel = findTestObject('Object Repository/APAC_University/SUN_University/Dropdown_Englishlevel')
WebUI.selectOptionByIndex(Englishlevel,CustomKeywords.'keyPathPackage.customKeywords.selectRandomOptionFromDropdown'())

TestObject Workexperience = findTestObject('Object Repository/APAC_University/SUN_University/Dropdown_Workexperience')
WebUI.selectOptionByIndex(Workexperience,CustomKeywords.'keyPathPackage.customKeywords.selectRandomOptionFromDropdown'())

TestObject Enquiry = findTestObject('Object Repository/APAC_University/SUN_University/Dropdown_Enquiry')
WebUI.selectOptionByIndex(Enquiry,CustomKeywords.'keyPathPackage.customKeywords.selectRandomOptionFromDropdown'())

//Clicks the next step button
WebUI.waitForElementClickable(findTestObject('Object Repository/APAC_University/SUN_University/Button_Nextstep2'), 10)
WebUI.click(findTestObject('Object Repository/APAC_University/SUN_University/Button_Nextstep2'))

// Use the custom keyword to generate a random FirstName and LastName
WebUI.delay(5)
WebUI.waitForElementPresent(findTestObject('Object Repository/APAC_University/SUN_University/Field_Firstname'), 10)
String FirstName = CustomKeywords.'keyPathPackage.customKeywords.generateRandomFirstName'()
WebUI.setText(findTestObject('Object Repository/APAC_University/SUN_University/Field_Firstname'), FirstName)

String LastName = CustomKeywords.'keyPathPackage.customKeywords.generateRandomLastName'()
WebUI.setText(findTestObject('Object Repository/APAC_University/SUN_University/Field_lastname'), LastName)

// Use the custom keyword to generate a random Phone number
String Phonenumber = CustomKeywords.'keyPathPackage.customKeywords.generateRandomMalaysianPhoneNumber'()
WebUI.setText(findTestObject('Object Repository/APAC_University/SUN_University/Field_Phonenumber'), Phonenumber)

//Clicks the submit button
WebUI.waitForElementClickable(findTestObject('Object Repository/APAC_University/SUN_University/Button_Submit'), 10)
WebUI.click(findTestObject('Object Repository/APAC_University/SUN_University/Button_Submit'))

WebUI.delay(3)
