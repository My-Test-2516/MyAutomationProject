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
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.WebElement
import java.util.List
import java.util.Random


// Use the custom keyword to generate a random FirstName and LastName
WebUI.delay(3)
String FirstName = CustomKeywords.'keyPathPackage.customKeywords.generateRandomFirstName'()
WebUI.setText(findTestObject('Object Repository/APAC_University/SIM_University/Field_Firstname'), FirstName)

String LastName = CustomKeywords.'keyPathPackage.customKeywords.generateRandomLastName'()
WebUI.setText(findTestObject('Object Repository/APAC_University/SIM_University/Field_Lastname'), LastName)

//Clicks the next step button
WebUI.waitForElementClickable(findTestObject('Object Repository/APAC_University/SIM_University/Button_Nextstep1'), 10)
WebUI.click(findTestObject('Object Repository/APAC_University/SIM_University/Button_Nextstep1'))


TestObject startdate = findTestObject('Object Repository/APAC_University/SIM_University/Dropdown_Startdate')
WebUI.selectOptionByIndex(startdate,CustomKeywords.'keyPathPackage.customKeywords.selectRandomOptionFromDropdown'())

TestObject Enquiry = findTestObject('Object Repository/APAC_University/SIM_University/Dropdown_Enquiry')
WebUI.selectOptionByIndex(Enquiry,CustomKeywords.'keyPathPackage.customKeywords.selectRandomOptionFromDropdown'())

//Selects the highes level Educatio
TestObject dropdown = findTestObject('Object Repository/APAC_University/SIM_University/Dropdown_Education')

// Logic added: If the system selects the value diploma then new Dropdown called "do you have APEL" appears with yes, no and unsure options,
//in this case the system will automatically selects the option randomly
//If the System  selects other option other than dipoloma then it will skip to select start date field.
String[] options = ['High school', 'Diploma', 'Bachelors degree', 'Postgraduate diploma', 'Masters Degree']
String randomOption = options[new Random().nextInt(options.length)]
WebUI.selectOptionByValue(dropdown, randomOption, true)

TestObject Workexperience = findTestObject('Object Repository/APAC_University/SIM_University/Dropdown_Experience')
WebUI.selectOptionByIndex(Workexperience,CustomKeywords.'keyPathPackage.customKeywords.selectRandomOptionFromDropdown'())

TestObject Englishlevel = findTestObject('Object Repository/APAC_University/SIM_University/Dropdown_English')
WebUI.selectOptionByIndex(Englishlevel,CustomKeywords.'keyPathPackage.customKeywords.selectRandomOptionFromDropdown'())


// Define the Test Object for the radio button group
TestObject radioButtonGroup = findTestObject('Object Repository/APAC_University/SIM_University/Radiobutton_Years')

// Find all radio buttons in the group (assumes there are exactly two)
List<WebElement> radioButtons = WebUI.findWebElements(radioButtonGroup, 30)

// Ensure that exactly two radio buttons are found
if (radioButtons.size() == 2) {
	// Generate a random index (0 or 1)
	Random random = new Random()
	int randomIndex = random.nextInt(2)

	// Select the random radio button
	WebElement randomRadioButton = radioButtons.get(randomIndex)
	randomRadioButton.click()
}
//Clicks the next step button
WebUI.waitForElementClickable(findTestObject('Object Repository/APAC_University/SIM_University/Button_Nextstep2'), 10)
WebUI.click(findTestObject('Object Repository/APAC_University/SIM_University/Button_Nextstep2'))

// Use the custom keyword to generate a random Phone number
String Phonenumber = CustomKeywords.'keyPathPackage.customKeywords.generateRandomMalaysianPhoneNumber'()
WebUI.setText(findTestObject('Object Repository/APAC_University/SIM_University/Field_Phonenumber'), Phonenumber)

// Use the custom keyword to generate a random email
String Email = CustomKeywords.'keyPathPackage.customKeywords.generateRandomEmail'()
WebUI.setText(findTestObject('Object Repository/APAC_University/SIM_University/Field_Email'), Email)

// Use the custom keyword to generate a Malaysian post number
String Postcode = CustomKeywords.'keyPathPackage.customKeywords.selectRandomSingaporePostCode'()
WebUI.setText(findTestObject('Object Repository/APAC_University/SIM_University/Field_Postcode'), Postcode)

//Clicks the submit button
WebUI.waitForElementClickable(findTestObject('Object Repository/APAC_University/SIM_University/Button_Submit'), 10)
WebUI.click(findTestObject('Object Repository/APAC_University/SIM_University/Button_Submit'))
