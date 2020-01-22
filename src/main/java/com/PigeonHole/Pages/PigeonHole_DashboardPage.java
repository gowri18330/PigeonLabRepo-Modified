package com.PigeonHole.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import com.PigeonHole.FunctionalLibrary.GenericMethods;

public class PigeonHole_DashboardPage {

	// Page Elements section
	@FindBy(how = How.CSS, using = ".pigeonhole-listview__list-link-classy")
	public static WebElement eventName;

	@FindBy(how = How.CSS, using = ".workspace-tooltip__dismiss")
	public static WebElement gotItButton;

	@FindBy(how = How.CSS, using = ".pigeonhole-listview__add-btn")
	public static WebElement addPigeonHoleButton;

	@FindBy(how = How.CSS, using = ".pigeonhole-listview--addbasic-btn")
	public static WebElement basicPigeonHoleButton;

	@FindBy(how = How.CSS, using = "[placeholder=\"Your Event Name\"]")
	public static WebElement eventNameInput;

	@FindBy(how = How.CSS, using = ".random-passcode-button")
	public static WebElement randomPassCodeLink;

	@FindBy(how = How.CSS, using = ".modal-affirmative-button ")
	public static  WebElement continueButton;

	@FindBy(how = How.XPATH, using = "//div[@class=\"modal-footer\"]//button[@type=\"button\"]")
	public static WebElement goToAgendaButton;

	@FindBy(how = How.CSS, using = ".confirmation-btn")
	public static WebElement conformationButton;

	@FindBy(how = How.XPATH, using = "//div[@class='btn-group add-session-container']")
	public static WebElement addSessionButton;

	@FindBy(how = How.XPATH, using = "//label[@class='box-radio']//span[@class='box-radio-content box-poll_quiz']")
	public static WebElement pollQuizeLabel;

	@FindBy(how = How.XPATH, using = "//textarea[@name='name']")
	public static WebElement sessionNamefield;

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-secondary btn-add-poll-qn  ']")
	public static WebElement addQuestionButton;

	@FindBy(how = How.XPATH, using = "//input[@name='question']")
	public static  WebElement pullQuestionField;

	@FindBy(how = How.XPATH, using = "//div[@class='modal-poll-type-region']//div[@class='input-group__addon input-uploader-area hide-if-archived remove-image']//input")
	public static  WebElement imageIcon;

	@FindBy(how = How.XPATH, using = "//div[@class='col-md-12 validation-error-host']//input[@id='poll_option_-1']")
	public static WebElement answerOptionFirstField;

	@FindBy(how = How.XPATH, using = "//div[@class='col-md-12 validation-error-host']//input[@id='poll_option_-2']")
	public static WebElement answerOptionSecondField;

	@FindBy(how = How.XPATH, using = "//div[@data-id='-1']//span[text()='Mark as correct']")
	public static WebElement markAsCurrectFirstField;

	@FindBy(how = How.XPATH, using = "//button[text() ='Save']")
	public static WebElement saveButton;

	@FindBy(how = How.XPATH, using = "//div[@class='input-group__addon input-uploader-area hide-if-archived ']//input[@id='file-input_poll_option_-1']")
	public static WebElement firstOptionImage;

	@FindBy(how = How.XPATH, using = "//div[@class='input-group__addon input-uploader-area hide-if-archived ']//input[@id='file-input_poll_option_-2']")
	public static WebElement secondOptionImage;

	@FindBy(how = How.XPATH, using = "//div[@class='input-group__addon input-uploader-area hide-if-archived ']//input[@id='file-input_poll_option_-3']")
	public static WebElement thirdOptionImage;

	@FindBy(how = How.XPATH, using = "//div[@class='form-group validatable']//input[@id='poll-qn-option-input']")
	public static WebElement answerOptionThirdField;

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-secondary btn-add-poll-qn  ']")
	public static WebElement addQuestionSecondButton;

	@FindBy(how = How.XPATH, using = "//input[@name='question']")
	public static WebElement pullSecondQuestionField;

	@FindBy(how = How.XPATH, using = "//div[@class='col-md-12 validation-error-host']//input[@id='poll_option_-1']")
	public static WebElement optionFirstField;

	@FindBy(how = How.XPATH, using = "//div[@class='col-md-12 validation-error-host']//input[@id='poll_option_-2']")
	public static WebElement optionSecondField;

	@FindBy(how = How.XPATH, using = "//button[text() ='Save']")
	public static  WebElement saveButtonTwo;

	@FindBy(how = How.XPATH, using = "//div[@data-id='-2']//div[@class='poll-option-left ']")
	public static WebElement markSecondField;

	@FindBy(how = How.XPATH, using = "//div[@class=' validation-error-host']//select")
	public static WebElement timeLimitDropwon;

	@FindBy(how = How.XPATH, using = "//div[@class='checkbox-radio-wrap remove-margin-and-padding-if-archived  poll-leaderboard']//input")
	public static WebElement leaderboardCheckBox;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	public static WebElement addQuiz;

	@FindBy(how = How.CSS, using = ".session-name")
	public static WebElement sessionNameField;

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-secondary dropdown-toggle']")
	public static WebElement sessionDropDown;

	@FindBy(how = How.XPATH, using = "//button[text() ='Start']")
	public static WebElement startSessionButton;

	@FindBy(how = How.XPATH, using = "//div[@class='modal-footer form-btn-set']//button[text() ='Start']")
	public static WebElement startButton;

	@FindBy(how = How.XPATH, using = "//div[@class='btn btn-secondary quick-run-button dropdown-toggle']")
	public static WebElement runsLink;

	@FindBy(how = How.XPATH, using = "//a[text() ='Audience Web App']")
	public static WebElement awalink;

	@FindBy(how = How.XPATH, using = "//a[text() ='Admin Panel']")
	public static WebElement adminPannelLink;

	@FindBy(how = How.XPATH, using = "//a[text() ='Projector Panel']")
	public static WebElement projectorPannelLink;

	// Page Commands section
	public void clickOnGotItButton() {
		gotItButton.click();
	}

	public void clickBasicPigeonhole() {
		clickOnGotItButton();
		clickOnAddPigeonHole();
		basicPigeonHoleButton.click();
	}

	public void setUpEvent(String eventName) throws Throwable {
		eventNameInput.sendKeys(eventName);
		randomPassCodeLink.click();
		GenericMethods.sychronizationinterval();
		continueButton.click();
		GenericMethods.sychronizationinterval();
		Thread.sleep(2000);
		goToAgendaButton.click();
		GenericMethods.sychronizationinterval();
		GenericMethods.waitForElementClickable(conformationButton);
		conformationButton.click();
	}

	public void addNewSession(String sessionName) throws Throwable {
		addSessionButton.click();
		GenericMethods.sychronizationinterval();
		pollQuizeLabel.click();
		sessionNamefield.sendKeys(sessionName);
	}

	public void addPollQuestion(String question, String firstAnswer, String secondAnswer) throws Throwable {
		addQuestionButton.click();
		GenericMethods.sychronizationinterval();
		pullQuestionField.sendKeys(question);
		GenericMethods.sychronizationinterval();
		Thread.sleep(3000);
		imageIcon.sendKeys(System.getProperty("user.dir") + "/FruitesImages/fruits.jpg");
		GenericMethods.sychronizationinterval();
		answerOptionFirstField.sendKeys(firstAnswer);
		GenericMethods.sychronizationinterval();
		answerOptionSecondField.sendKeys(secondAnswer);
		GenericMethods.sychronizationinterval();
		markAsCurrectFirstField.click();
		GenericMethods.sychronizationinterval();
		saveButton.click();
	}

	public void addAnswerOptionsWithImages(String question, String firstAnswer, String secondAnswer, String thirdAnswer,
			String timeValue) throws Throwable {
		addQuestionSecondButton.click();
		GenericMethods.sychronizationinterval();
		pullSecondQuestionField.sendKeys(question);
		GenericMethods.sychronizationinterval();
		optionFirstField.sendKeys(firstAnswer);
		GenericMethods.sychronizationinterval();
		firstOptionImage.sendKeys(System.getProperty("user.dir") + "/FruitesImages/animated-orange.gif");
		GenericMethods.sychronizationinterval();
		optionSecondField.sendKeys(secondAnswer);
		GenericMethods.sychronizationinterval();
		secondOptionImage.sendKeys(System.getProperty("user.dir") + "/FruitesImages/guava.jpg");
		Thread.sleep(8000);// wait required for uploading the image icon
		markSecondField.click();
		GenericMethods.sychronizationinterval();
		answerOptionThirdField.sendKeys(thirdAnswer);
		Thread.sleep(6000);
		thirdOptionImage.sendKeys(System.getProperty("user.dir") + "/FruitesImages/apple.png");
		Thread.sleep(8000);// wait required for uploading the image icon
		saveButtonTwo.click();
		GenericMethods.sychronizationinterval();
		Select time = new Select(timeLimitDropwon);
		GenericMethods.sychronizationinterval();
		time.selectByVisibleText(timeValue);
		GenericMethods.sychronizationinterval();
		selectLeaderboardCheckBox();
		GenericMethods.sychronizationinterval();
		addQuiz.click();
	}

	public void selectLeaderboardCheckBox() {
		if (!(leaderboardCheckBox.isSelected())) {
			leaderboardCheckBox.click();
		}
	}

	public void startSession() throws Throwable {
		sessionDropDown.click();
		GenericMethods.sychronizationinterval();
		startSessionButton.click();
		GenericMethods.sychronizationinterval();
		startButton.click();
	}

	public void clickOnRunsLink() throws Throwable {
		GenericMethods.sychronizationinterval();
		runsLink.click();
	}

	public void clickOnAwa() {
		awalink.click();
	}

	public void clickOnAdminPannel() {
		adminPannelLink.click();
	}

	public void clickOnProjectorPannel() {
		projectorPannelLink.click();
	}

	public void clickOnEvent() {
		eventName.click();
	}

	public void clickOnAddPigeonHole() {
		addPigeonHoleButton.click();
	}

	public void clickOnBasicPigeonHole() {
		basicPigeonHoleButton.click();
	}

	public void fillEventName(String name) {
		eventNameInput.sendKeys(name);
	}

	public void clickOnRandomPassCode() {
		randomPassCodeLink.click();
	}

	public void clickOnContinueButton() {
		continueButton.click();
	}
}
