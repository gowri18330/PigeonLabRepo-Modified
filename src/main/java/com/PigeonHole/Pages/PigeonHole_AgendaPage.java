package com.PigeonHole.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.PigeonHole.FunctionalLibrary.GenericMethods;

public class PigeonHole_AgendaPage extends GenericMethods {

	@FindBy(how = How.XPATH, using = "//strong[contains(text(),\"Technology and Corporate Communications\")]/../../..//a")
	public static WebElement eventEditButton;

	@FindBy(how = How.XPATH, using = "(//input[@name=\"moderate\"])[1]/../span[1]")
	public static WebElement questionFilteringCheckbox;

	@FindBy(how = How.CSS, using = ".btn-save-session")
	public static WebElement saveQAbutton;

	@FindBy(how = How.CSS, using = ".close-modal-button")
	public static WebElement goToAgenda;

	@FindBy(how = How.CSS, using = ".confirmation-btn")
	public static WebElement gotItButton;

	@FindBy(how = How.CSS, using = ".add-session-btn")
	public static WebElement addSessionButton;

	@FindBy(how = How.CSS, using = ".box-poll_poll")
	public static WebElement multipleChoicePollButton;

	@FindBy(how = How.CSS, using = "[name=\"name\"]")
	public static WebElement sessionNameInput;

	@FindBy(how = How.CSS, using = ".btn-add-poll-qn")
	public static WebElement addQuestionButton;

	@FindBy(how = How.CSS, using = ".poll-qn-field")
	public static WebElement pollQuestionInput;

	@FindBy(how = How.CSS, using = "#poll_option_-1")
	public static WebElement optionOne;

	@FindBy(how = How.CSS, using = "#poll_option_-2")
	public static WebElement optionTwo;

	@FindBy(how = How.CSS, using = ".poll-qn-option-input")
	public static WebElement optionThree;

	@FindBy(how = How.CSS, using = ".btn-save-poll-qn")
	public static WebElement saveButton;

	@FindBy(how = How.XPATH, using = "(//div[@data-type=\"text\"])[1]")
	public static WebElement questionTypeDropDown;

	@FindBy(how = How.XPATH, using = "(//div[@data-type=\"numeric_scale\"])[2]")
	public static WebElement numericDropDownOption;

	@FindBy(how = How.XPATH, using = "//select[@name=\"lowValue\"]/option[@value=\"0\"]")
	public static WebElement lowestValueToZero;

	@FindBy(how = How.XPATH, using = "(//div[@data-type=\"draggable_scale\"])[2]")
	public static WebElement draggableDropDownOption;

	@FindBy(how = How.XPATH, using = "//select[@name=\"highValue\"]/option[@value=\"100\"]")
	public static WebElement highestValueToHundred;

	@FindBy(how = How.XPATH, using = "(//div[@data-type=\"rating\"])[2]")
	public static WebElement iconRatingOption;

	@FindBy(how = How.XPATH, using = "//select[@name=\"highValue\"]/option[@value=\"10\"]")
	public static WebElement stepsToTen;

	@FindBy(how = How.CSS, using = ".poll-show-results")
	public static WebElement checkAWAcheckBox;

	@FindBy(how = How.CSS, using = ".btn-save-session")
	public static WebElement clickAddMultipleChoiceButton;

	@FindBy(how = How.CSS, using = ".session-name strong")
	public static WebElement verifySessionName;

	@FindBy(how = How.CSS, using = "[data-original-title=\"Poll: Multiple choice\"]")
	public static WebElement verifySessionIcon;

	@FindBy(how = How.CSS, using = "[aria-expanded=\"false\"]")
	public static WebElement editNextArrowButton;

	@FindBy(how = How.CSS, using = ".start-session-button")
	public static WebElement editNextArrowStartButton;

	@FindBy(how = How.CSS, using = ".modal-affirmative-button")
	public static WebElement popUpStartButton;

	@FindBy(how = How.CSS, using = ".quick-run-button")
	public static WebElement runLinkButton;

	@FindBy(how = How.XPATH, using = "//a[text()=\"Audience Web App\"]")
	public static WebElement AWAbutton;

	@FindBy(how = How.XPATH, using = "//a[text()=\"Admin Panel\"]")
	public static WebElement adminpanelButton;

	@FindBy(how = How.XPATH, using = "//a[text()=\"Projector Panel\"]")
	public static WebElement projectorPanelButton;

	public void clickEventEdit() {
		eventEditButton.click();
	}

	public void clickQuestionFiltering() {
		questionFilteringCheckbox.click();
	}

	public void clickSaveQA() {
		saveQAbutton.click();
	}

	public void clickGoToAgenda() {
		goToAgenda.click();
	}

	public void clickAddSession() {
		addSessionButton.click();
	}

	public void clickMultipleChoicePoll() {
		multipleChoicePollButton.click();
	}

	public void fillSessionName(String session) {
		sessionNameInput.sendKeys(session);
	}

	public void clickAddQuestion() {
		addQuestionButton.click();
	}

	public void fillPollQuestion(String question) {
		pollQuestionInput.sendKeys(question);
	}

	public void fillPollOptionOne(String option) {
		optionOne.sendKeys(option);
	}

	public void fillPollOptionTwo(String option) {
		optionTwo.sendKeys(option);
	}

	public void fillPollOptionThree(String option) {
		optionThree.sendKeys(option);
	}

	public void fillPollOptionFour(String option) {
		optionThree.sendKeys(option);
	}

	public void clickSaveButton() {
		saveButton.click();
	}

	public void clickQuestionType() {
		Actions action = new Actions(driver);
		action.moveToElement(questionTypeDropDown).click().build().perform();
	}

	public void selectNumericScale() {
		numericDropDownOption.click();
	}

	public void setLowestValueToZero() {
		lowestValueToZero.click();
	}

	public void selectDraggable() {
		draggableDropDownOption.click();
	}

	public void setHighestValueToHundred() {
		highestValueToHundred.click();
	}

	public void selectIconRating() {
		iconRatingOption.click();
	}

	public void setStepsToTen() {
		stepsToTen.click();
	}

	public void clickAWAcheckBox() {
		checkAWAcheckBox.click();
	}

	public void clickAddMultipleChoiceButton() {
		clickAddMultipleChoiceButton.click();
	}

	public void clickEditNextArrowButton() {
		editNextArrowButton.click();
	}

	public void clickEditNextArrowStartButton() {
		editNextArrowStartButton.click();
	}

	public void clickPopUpStartButton() {
		popUpStartButton.click();
	}

	public void clickRunLinkButton() {
		runLinkButton.click();
	}

	public void clickAudienceWebApp() {
		AWAbutton.click();
	}

	public void clickAdminPanel() {
		adminpanelButton.click();
	}

	public void clickProjectorPanel() {
		projectorPanelButton.click();
	}
}
