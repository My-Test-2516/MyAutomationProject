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

//  Identify the lists elements
TestObject list1 = findTestObject('Object Repository/APAC_University/MBS_University/Short_Courses/Shortcourse_Listone')
TestObject list2 = findTestObject('Object Repository/APAC_University/MBS_University/Short_Courses/Shortcourse_Listtwo')
TestObject list3 = findTestObject('Object Repository/APAC_University/MBS_University/Short_Courses/Shortcourse_Listthree')
//TestObject list4 = findTestObject('Object Repository/APAC_University/MBS_University/Short_Courses/Shortcourse_Listfour')

List<TestObject> lists = [list1, list2, list3,]

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


//Scrolls to button Enrol now
WebUI.scrollToElement(findTestObject('Object Repository/APAC_University/MBS_University/Enrol_Now/Button_Enrol_Now'), 3)
//Clicks the button Enrol_Now 
WebUI.waitForElementClickable(findTestObject('Object Repository/APAC_University/MBS_University/Enrol_Now/Button_Enrol_Now'), 20)
WebUI.click(findTestObject('Object Repository/APAC_University/MBS_University/Enrol_Now/Button_Enrol_Now'))

// Use the custom keyword to generate a random FirstName and LastName
//String FirstName = CustomKeywords.'keyPathPackage.customKeywords.generateRandomFirstName'()
WebUI.setText(findTestObject('Object Repository/APAC_University/MBS_University/Enrol_Now/Field_Firstname'), "Testkeypath")
	
//String LastName = CustomKeywords.'keyPathPackage.customKeywords.generateRandomLastName'()
WebUI.setText(findTestObject('Object Repository/APAC_University/MBS_University/Enrol_Now/Field_Secondname'), "Dummy")

// Use the custom keyword to generate a random email
String Email = CustomKeywords.'keyPathPackage.customKeywords.generateRandomEmail'()
WebUI.setText(findTestObject('Object Repository/APAC_University/MBS_University/Enrol_Now/Field_Email'), Email)

// Sets the above Random email into confirm email field
WebUI.setText(findTestObject('Object Repository/APAC_University/MBS_University/Enrol_Now/Field_ConfirmEmail'), Email)

// Use the custom keyword to generate a random Phone number
String Phonenumber = CustomKeywords.'keyPathPackage.customKeywords.generateRandomAustralianPhoneNumber'()
WebUI.setText(findTestObject('Object Repository/APAC_University/MBS_University/Enrol_Now/Field_Phonenumber'), Phonenumber)

//Clicks the checkbox for terms and conditions
WebUI.check(findTestObject('Object Repository/APAC_University/MBS_University/Enrol_Now/Check_Box'))

//verify terma and conditions is checked
WebUI.verifyElementChecked(findTestObject('Object Repository/APAC_University/MBS_University/Enrol_Now/Check_Box'), 30)


//Scrolls to payment button
WebUI.scrollToElement(findTestObject('Object Repository/APAC_University/MBS_University/Enrol_Now/Button_Payment'), 3)
 //Clicks the button payment button
WebUI.waitForElementClickable(findTestObject('Object Repository/APAC_University/MBS_University/Enrol_Now/Button_Payment'), 20)
WebUI.click(findTestObject('Object Repository/APAC_University/MBS_University/Enrol_Now/Button_Payment'))

// Wait for the iframe to be present fΩor Card NUmber and Switch to the iframe
WebUI.waitForElementPresent(findTestObject('Object Repository/APAC_University/MBS_University/Enrol_Now/Iframe_Cardnumber'), 10)
WebUI.switchToFrame(findTestObject('Object Repository/APAC_University/MBS_University/Enrol_Now/Iframe_Cardnumber'), 10)
//Enter the Card number 
WebUI.setText(findTestObject('Object Repository/APAC_University/MBS_University/Enrol_Now/Field_Cardnumber'),'4111 1111 1111 1111' )
WebUI.switchToDefaultContent()

// Wait for the iframe to be present for ExpiryDate and Switch to the iframe
WebUI.waitForElementPresent(findTestObject('Object Repository/APAC_University/MBS_University/Enrol_Now/Iframe_Expirydate'), 10)
WebUI.switchToFrame(findTestObject('Object Repository/APAC_University/MBS_University/Enrol_Now/Iframe_Expirydate'), 10)
//Enter the Expiry Date
String Expirydate = CustomKeywords.'keyPathPackage.customKeywords.generateExpiryDate'()
WebUI.setText(findTestObject('Object Repository/APAC_University/MBS_University/Enrol_Now/Field_ExpiryDate'),Expirydate)
WebUI.switchToDefaultContent()

// Wait for the iframe to be present for CVC and Switch to the iframe
WebUI.waitForElementPresent(findTestObject('Object Repository/APAC_University/MBS_University/Enrol_Now/Iframe_CVC'), 10)
WebUI.switchToFrame(findTestObject('Object Repository/APAC_University/MBS_University/Enrol_Now/Iframe_CVC'), 10)
//Enter the CVC
String CVC = CustomKeywords.'keyPathPackage.customKeywords.generateExpiryDate'()
WebUI.setText(findTestObject('Object Repository/APAC_University/MBS_University/Enrol_Now/Field_CVC'),CVC)
WebUI.switchToDefaultContent()

//Clicks the radio button for billing information and verify terms and conditions is checked
WebUI.check(findTestObject('Object Repository/APAC_University/MBS_University/Enrol_Now/Button_Radio'))
WebUI.verifyElementChecked(findTestObject('Object Repository/APAC_University/MBS_University/Enrol_Now/Button_Radio'), 30)

// Use the custom keyword to generate a random Company name
String Company = CustomKeywords.'keyPathPackage.customKeywords.selectRandomCompany'()
WebUI.setText(findTestObject('Object Repository/APAC_University/MBS_University/Enrol_Now/Field_Company'), Company)

// Use the custom keyword to generate a random FirstName and LastName
//String GivenFirstName = CustomKeywords.'keyPathPackage.customKeywords.generateRandomFirstName'()
WebUI.setText(findTestObject('Object Repository/APAC_University/MBS_University/Enrol_Now/Field_GIvenFIrstName'),'Onlyfortest')
	
//String GivenLastName = CustomKeywords.'keyPathPackage.customKeywords.generateRandomLastName'()
WebUI.setText(findTestObject('Object Repository/APAC_University/MBS_University/Enrol_Now/Field_GivenLastName'), 'onlyfortest')

String StreetAddress = CustomKeywords.'keyPathPackage.customKeywords.generateRandomAddressLine1'()
WebUI.setText(findTestObject('Object Repository/APAC_University/MBS_University/Enrol_Now/Field_Address'), StreetAddress)

String Suburb = CustomKeywords.'keyPathPackage.customKeywords.generateRandomSuburb'()
WebUI.setText(findTestObject('Object Repository/APAC_University/MBS_University/Enrol_Now/Field_Suburb'), Suburb)

//Randomly selects the program from the drop-down
TestObject State = findTestObject('Object Repository/APAC_University/MBS_University/Enrol_Now/Dropdown_State')
WebUI.selectOptionByIndex(State,CustomKeywords.'keyPathPackage.customKeywords.selectRandomOptionFromDropdown'())

// Use the custom keyword to generate a post number
String Postcode = CustomKeywords.'keyPathPackage.customKeywords.selectRandomPostCode'()
WebUI.setText(findTestObject('Object Repository/APAC_University/MBS_University/Enrol_Now/Field_Postcode'), Postcode)

// Clicks the Review Purchase button
WebUI.waitForElementClickable(findTestObject('Object Repository/APAC_University/MBS_University/Enrol_Now/Button_Review_Purchase'), 10)
WebUI.click(findTestObject('Object Repository/APAC_University/MBS_University/Enrol_Now/Button_Review_Purchase'))


//Scrolls to button complete purchase
WebUI.scrollToElement(findTestObject('Object Repository/APAC_University/MBS_University/Enrol_Now/Button_Complete_Purchase'), 3)
// Clicks the Complete Purchase button
WebUI.waitForElementClickable(findTestObject('Object Repository/APAC_University/MBS_University/Enrol_Now/Button_Complete_Purchase'), 10)
WebUI.click(findTestObject('Object Repository/APAC_University/MBS_University/Enrol_Now/Button_Complete_Purchase'))

// Verify order completed successfully
WebUI.delay(3)
WebUI.verifyElementText(findTestObject('Object Repository/APAC_University/MBS_University/Enrol_Now/Verify_Order'), 'Thank you for your order')

//Close Browser
WebUI.closeBrowser()