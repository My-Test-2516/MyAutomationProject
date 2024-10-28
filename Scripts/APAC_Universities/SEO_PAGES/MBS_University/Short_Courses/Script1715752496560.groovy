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
//WebUI.callTestCase(findTestCase('Test Cases/APAC_Universities/SEO_PAGES/MBS_University/Resuable_Testcases/Navigate_URL'), [:], FailureHandling.STOP_ON_FAILURE)

// Hovers the cursor on the short course button
TestObject buttonObject = findTestObject('Object Repository/APAC_University/MBS_University/Short_Courses/List_ShortCourses')
WebUI.mouseOver(buttonObject)

// Step 4: Identify the lists elements
TestObject list1 = findTestObject('Object Repository/APAC_University/MBS_University/Short_Courses/Shortcourse_Listone')
TestObject list2 = findTestObject('Object Repository/APAC_University/MBS_University/Short_Courses/Shortcourse_Listtwo')
TestObject list3 = findTestObject('Object Repository/APAC_University/MBS_University/Short_Courses/Shortcourse_Listthree')
//TestObject list4 = findTestObject('Object Repository/APAC_University/MBS_University/Short_Courses/Shortcourse_Listfour')

List<TestObject> lists = [list1, list2, list3]

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
WebUI.setText(findTestObject('Object Repository/APAC_University/MBS_University/Short_Courses/Field_Firstname'), FirstName)
	
String LastName = CustomKeywords.'keyPathPackage.customKeywords.generateRandomLastName'()
WebUI.setText(findTestObject('Object Repository/APAC_University/MBS_University/Short_Courses/Field_Lastname'), LastName)

// Use the custom keyword to generate a random email
String Email = CustomKeywords.'keyPathPackage.customKeywords.generateRandomEmail'()
WebUI.setText(findTestObject('Object Repository/APAC_University/MBS_University/Short_Courses/Field_Email'), Email)

// Use the custom keyword to generate a random Phone number
String Phonenumber = CustomKeywords.'keyPathPackage.customKeywords.generateRandomAustralianPhoneNumber'()
WebUI.setText(findTestObject('Object Repository/APAC_University/MBS_University/Short_Courses/Field_Phonenumber'), Phonenumber)

// Use the custom keyword to generate a random Company name
String Company = CustomKeywords.'keyPathPackage.customKeywords.selectRandomCompany'()
WebUI.setText(findTestObject('Object Repository/APAC_University/MBS_University/Short_Courses/Field_Company'), Company)

// Use the custom keyword to generate a random role
String Role = CustomKeywords.'keyPathPackage.customKeywords.selectRandomRole'()
WebUI.setText(findTestObject('Object Repository/APAC_University/MBS_University/Short_Courses/Field_Role'), Role)

//CLicks the Button Download
WebUI.click(findTestObject('Object Repository/APAC_University/MBS_University/Short_Courses/Button_Download'))


//Verify if the Thank you for enquiry content is displayed
WebUI.delay(5)
WebUI.verifyElementText(findTestObject('Object Repository/APAC_University/MBS_University/Verify_Message'), 'Thanks for your request')

//Close Browser
//WebUI.closeBrowser()
