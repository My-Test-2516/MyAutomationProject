package keyPathPackage
import java.awt.Robot
import java.awt.event.KeyEvent
import java.nio.file.*
import java.text.SimpleDateFormat;
import org.openqa.selenium.*
import org.openqa.selenium.support.ui.Select;
import com.github.javafaker.Faker
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import java.util.Date;
import java.util.TimeZone;
import org.apache.commons.lang3.StringUtils;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class customKeywords {

	@Keyword
	public static String generateRandomAddressLine1() {
		Faker faker = new Faker();
		String streetName = faker.address().streetName();
		String streetNumber = faker.address().buildingNumber();
		return streetNumber + " " + streetName;
	}
	@Keyword
	public static String generateRandomSuburb() {
		Faker faker = new Faker();
		Random random = new Random();

		List<String> suburbs = Arrays.asList(
				"Sydney", "Melbourne", "Brisbane", "Perth", "Adelaide",
				"Gold Coast", "Canberra", "Newcastle", "Wollongong", "Geelong",
				"Hobart", "Townsville", "Cairns", "Toowoomba", "Darwin",
				"Ballarat", "Bendigo", "Albury", "Launceston", "Mackay",
				"Rockhampton", "Bunbury", "Coffs Harbour", "Bundaberg", "Wagga Wagga"
				);

		// Generate a random suburb
		String randomSuburb = suburbs.get(random.nextInt(suburbs.size()));
		return randomSuburb
	}
	@Keyword
	public static String generateRandomFirstName() {
		Faker faker = new Faker();
		String firstName = faker.name().firstName();
		return firstName;
	}

	@Keyword
	public static String generateRandomLastName() {
		Faker faker = new Faker();
		String LastName = faker.name().lastName();
		// Define your word
		String word = "Testing";

		// Randomly add last name to the word
		String lastName = word + " " + LastName;
		return lastName;
	}

	@Keyword
	public static String generateRandomEmail() {
		Faker faker = new Faker()
		String email = faker.internet().emailAddress()
		return email
	}
	@Keyword
	public static String generateRandomAustralianPhoneNumber() {
		Faker faker = new Faker()
		String phoneNumber = faker.numerify("04########")
		return phoneNumber
	}

	@Keyword
	public static String generateRandomMalaysianPhoneNumber() {
		Faker faker = new Faker()
		String MalaysianphoneNumber = faker.numerify("12#######")
		return MalaysianphoneNumber
	}

	@Keyword
	public static String selectRandomOptionFromDropdown() {
		int optionListLength = 3
		Random rand = new Random()
		int index = rand.nextInt(optionListLength-1)+1
		return index
	}

	@Keyword
	public static String selectRandomPostCode() {
		Faker faker = new Faker()
		Random random = new Random();

		// Define the range for Australian postcodes
		int minPostcode = 200;
		int maxPostcode = 9999;

		// Generate a random postcode within the range
		int randomPostcode = random.nextInt((maxPostcode - minPostcode) + 1) + minPostcode;

		// Format the postcode to ensure it is a 4-digit number
		String formattedPostcode = String.format("%04d", randomPostcode);
		return formattedPostcode
	}

	@Keyword
	public static String selectRandomPostCodes() {
		Faker faker = new Faker()
		Random random = new Random();

		// Define the range for postcodes
		int minPostcode = 10000;
		int maxPostcode = 99999;

		// Generate a random postcode within the range
		int randomPostcode = random.nextInt((maxPostcode - minPostcode) + 1) + minPostcode;

		// Format the postcode to ensure it is a 5-digit number
		String formattedPostcode = String.format("%04d", randomPostcode);
		return formattedPostcode
	}

	@Keyword
	public static String selectRandomSingaporePostCode() {
		Faker faker = new Faker()
		Random random = new Random();

		// Define the range for Australian postcodes
		int minPostcode = 100000;
		int maxPostcode = 999999;

		// Generate a random postcode within the range
		int randomPostcode = random.nextInt((maxPostcode - minPostcode) + 1) + minPostcode;

		// Format the postcode to ensure it is a 5-digit number
		String formattedPostcode = String.format("%04d", randomPostcode);
		return formattedPostcode
	}

	@Keyword
	public static String selectRandomCompany() {
		Faker faker = new Faker()
		String randomCompany = faker.company().name()
		return randomCompany
	}

	@Keyword
	public static String selectRandomRole() {
		Faker faker = new Faker()
		String randomRole = faker.company().profession()
		return randomRole
	}

	@Keyword
	public static String generateVisaCardNumber() {
		Faker faker = new Faker()
		String randomVisacard= faker.finance().creditCard()
		return randomVisacard
	}

	@Keyword
	public static String generateExpiryDate() {
		Faker faker = new Faker()
		LocalDate futureDate = LocalDate.now().plusMonths(faker.number().numberBetween(1, 48));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
		String expiryDate = futureDate.format(formatter);
		return expiryDate
	}
}
