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
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys as Keys
import java.util.Random




// Calls the URL test cases
WebUI.callTestCase(findTestCase('Test Cases/APAC_Universities/SEO_PAGES/MBS_University/Resuable_Testcases/Navigate_URL'), [:], FailureHandling.STOP_ON_FAILURE)

// Hovers the cursor on the short course button
TestObject buttonObject = findTestObject('Object Repository/APAC_University/MBS_University/Degree Program/List_DegreePrograms')
WebUI.mouseOver(buttonObject)

// Step 4: Identify the lists elements

TestObject list1 = findTestObject('Object Repository/APAC_University/MBS_University/Degree Program/DegreePrograms_ListOne')
TestObject list2 = findTestObject('Object Repository/APAC_University/MBS_University/Degree Program/DegreePrograms_Listtwo')
TestObject list3 = findTestObject('Object Repository/APAC_University/MBS_University/Degree Program/DegreePrograms_Listthree')
TestObject list4 = findTestObject('Object Repository/APAC_University/MBS_University/Degree Program/DegreePrograms_Listfour')

List<TestObject> lists = [list1, list2, list3, list4]

// Step 5: Generate a random index to select one of the lists
Random rand = new Random()
int randomListIndex = rand.nextInt(lists.size())

// Step 6: Get the randomly selected list
TestObject selectedList = lists.get(randomListIndex)

// Step 7: Wait for the selected list to be visible (if needed)
WebUI.waitForElementVisible(selectedList, 10)

// Step 8: Get all items in the selected list
List<WebElement> listItems = WebUI.findWebElements(selectedList, 30)

// Step 9: Generate a random index to select one of the items in the selected list
if (listItems.size()> 0) {
	int randomItemIndex = rand.nextInt(listItems.size())
	WebElement randomItem = listItems.get(randomItemIndex)
	// Step 10: Click the randomly selected item
	randomItem.click()
	}
	

// Use the custom keyword to generate a random FirstName and LastName
String FirstName = CustomKeywords.'keyPathPackage.customKeywords.generateRandomFirstName'()
WebUI.setText(findTestObject('Object Repository/APAC_University/MBS_University/Degree Program/Field_Firstname'), FirstName)

String LastName = CustomKeywords.'keyPathPackage.customKeywords.generateRandomLastName'()
WebUI.setText(findTestObject('Object Repository/APAC_University/MBS_University/Degree Program/Field_Lastname'), LastName)

//Move to Next Step
WebUI.click(findTestObject('Object Repository/APAC_University/MBS_University/Degree Program/Button_NextStep2'))


/*logic added: when the systems selects YES for 2+ year experience then it will continue to
/. next step or else if the system selects NO then new drop down will be displayed and the system selects a value from 
   the new drop down and continues with next step.
 * 
 */
TestObject dropdown = findTestObject('Object Repository/APAC_University/MBS_University/Degree Program/Dropdown_Bachelor_Experience')
// Generate a random selection between Yes and No
String[] options = ['yes', 'no']
String randomOption = options[new Random().nextInt(options.length)]
WebUI.selectOptionByValue(dropdown, randomOption, true)

if (randomOption.equals("no")) {
	WebUI.delay(3)
	TestObject WorkExperience = findTestObject('Object Repository/APAC_University/MBS_University/Degree Program/Dropdown_Workexperience')
	WebUI.selectOptionByIndex(WorkExperience,1)
	
}
	    TestObject startdate = findTestObject('Object Repository/APAC_University/MBS_University/Degree Program/Dropdown_Startdate')
		WebUI.selectOptionByIndex(startdate,CustomKeywords.'keyPathPackage.customKeywords.selectRandomOptionFromDropdown'())
		TestObject Enquiryreason = findTestObject('Object Repository/APAC_University/MBS_University/Degree Program/Dropdown_Enquiry')
		WebUI.selectOptionByIndex(Enquiryreason, CustomKeywords.'keyPathPackage.customKeywords.selectRandomOptionFromDropdown'())
		WebUI.delay(2)
		WebUI.scrollToElement(findTestObject('Object Repository/APAC_University/MBS_University/Degree Program/Button_NextStep3'), 3)
		WebUI.click(findTestObject('Object Repository/APAC_University/MBS_University/Degree Program/Button_NextStep3'))
		
		// Use the custom keyword to generate a random email
		String Email = CustomKeywords.'keyPathPackage.customKeywords.generateRandomEmail'()
		WebUI.setText(findTestObject('Object Repository/APAC_University/MBS_University/Degree Program/Field_Email'), Email)
		
		// Use the custom keyword to generate a random Phone number
		String Phonenumber = CustomKeywords.'keyPathPackage.customKeywords.generateRandomAustralianPhoneNumber'()
		WebUI.setText(findTestObject('Object Repository/APAC_University/MBS_University/Degree Program/Field_Phonenumber'), Phonenumber)
		
		// Use the custom keyword to generate a post number
		String Postcode = CustomKeywords.'keyPathPackage.customKeywords.selectRandomPostCode'()
		WebUI.setText(findTestObject('Object Repository/APAC_University/MBS_University/Degree Program/Field_Postcode'), Postcode)
		WebUI.setText(findTestObject('Object Repository/APAC_University/MBS_University/Degree Program/Field_Postcode'), Postcode)
		WebUI.click(findTestObject('Object Repository/APAC_University/MBS_University/Degree Program/Button_Downloadbrochure'))


//Close browser
//WebUI.closeBrowser()



