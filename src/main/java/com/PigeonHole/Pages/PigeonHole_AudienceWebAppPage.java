package com.PigeonHole.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.PigeonHole.FunctionalLibrary.GenericMethods;

public class PigeonHole_AudienceWebAppPage extends GenericMethods {

	// Page Elements section
	@FindBy(how = How.XPATH, using = "(//h2[text()=\"Technology and Corporate Communications\"]/..//a[contains(text(),\" Enter this Q&A\")])[1]")
	public static WebElement enterThisQA_Button;

	@FindBy(how = How.CSS, using = ".question-input")
	public static WebElement questionInput;

	@FindBy(how = How.CSS, using = ".question-input")
	public static WebElement questionInputTwo;

	@FindBy(how = How.CSS, using = ".question-input-btn")
	public static WebElement askButton;

	@FindBy(how = How.CSS, using = ".modal-btn-ok")
	public static WebElement confirmAskButton;

	@FindBy(how = How.CSS, using = ".question-content")
	public static WebElement verifyQuestion;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'icon-qna-vote-outline')]")
	public static WebElement voteButton;

	@FindBy(how = How.CSS, using = ".question-vote-count")
	public static WebElement verifyVoteCount;

	@FindBy(how = How.XPATH, using = "(//div[@class=\"question-content allow-user-select\"])[2]")
	public static WebElement secondQuestion;

	@FindBy(how = How.CSS, using = ".announcement-modal-text")
	public static WebElement announcementPopUPText;

	@FindBy(how = How.CSS, using = ".model-bottom-section-button")
	public static WebElement announcementPopUPCloseButton;

	@FindBy(how = How.XPATH, using = "(//span[@class=\"answered\"])[2]")
	public static WebElement verifyAnsweredText;

	@FindBy(how = How.XPATH, using = "(//h2[@class=\"allow-user-select\"])[1]")
	public static WebElement verifySessionName;

	@FindBy(how = How.XPATH, using = "(//a[contains(text(),\"Cast your vote\")])[1]")
	public static WebElement casteYourVoteButton;

	@FindBy(how = How.XPATH, using = "(//div[contains(@class,\"poll-option-item\")])[5]")
	public static WebElement firstVoteOptionButton;

	@FindBy(how = How.CSS, using = ".poll-question")
	public static WebElement verifyPollQuestion;

	@FindBy(how = How.XPATH, using = "(//div[@class='poll-option-item-text'])[1]")
	public static WebElement verifyVoteOption;

	@FindBy(how = How.XPATH, using = "(//div[@class='poll-option-item-percentage'])[1]")
	public static WebElement verifyVotePercentage;
	
	@FindBy(how = How.CSS, using = ".next-button")
	public static WebElement nextButton;

	@FindBy(how = How.CSS, using = "[value=\"4\"]")
	public static WebElement numericInputOptionFourButton;

	@FindBy(how = How.CSS, using = ".confirm-button")
	public static WebElement confirmVoteButton;

	@FindBy(how = How.XPATH, using = "(//span[@class=\"icon icon-star-solid\"])[7]")
	public static WebElement iconRatingButton;

	@FindBy(how = How.CSS, using = ".poll-option-score span:nth-child(1)")
	public static WebElement verifyIconRating;

	@FindBy(how = How.CSS, using = ".complete-text")
	public static WebElement thankYouText;

	@FindBy(how = How.XPATH, using = "(//a[text()='Back'])[1]")
	public static WebElement backButton;

	@FindBy(how = How.CSS, using = ".modal-btn-cancel")
	public static WebElement skipButton;

	@FindBy(how = How.XPATH, using = "(//div[@class=\"poll-option-region\"]//div[@class='poll-option-item-background'])[1]")
	public static WebElement answerOptionOne;

	@FindBy(how = How.XPATH, using = "//div[@class='viewer-image-wrapper show-layer']")
	public static WebElement enlargeIcon;

	@FindBy(how = How.XPATH, using = "//div[@class='viewer-image-wrapper show-layer active']//span[@class='icon icon-cross icon-cross-large']")
	public static WebElement enlargeCloseButton;

	@FindBy(how = How.XPATH, using = "//div[text()='Quiz paused!']")
	public static WebElement quizPauseTextField;

	@FindBy(how = How.XPATH, using = "(//div[@class='poll-option-item-percentage-wrap'])[3]")
	public static WebElement appleAnswerField;

	@FindBy(how = How.XPATH, using = "//div[@class='modal-box-tick']//div[text()='You got the wrong answer.']")
	public static WebElement sorryWorngAnswerPopup;

	@FindBy(how = How.XPATH, using = "//div[@class='ranking-summary']//div[text() ='1/2']")
	public static WebElement finalScoreField;

	// Page Commands section
	public boolean validateSession(String sessionName) {
		return driver
				.findElement(By.xpath("//div[@class='sessionlist-item-outer']//div//h2[text() ='" + sessionName + "']"))
				.isDisplayed();
	}

	public void clickOnFirstQuestionAswer() {
		answerOptionOne.click();
	}

	public void clickOnEnlargeIcon() throws Throwable {
		enlargeIcon.click();
		Thread.sleep(1000);
		enlargeCloseButton.click();
	}

	public void clickOnApple() {
		appleAnswerField.click();
	}

	public void clickQA() {
		enterThisQA_Button.click();
	}

	public void clickQuestionInput() {
		Actions action = new Actions(driver);
		action.moveToElement(questionInput).click().build().perform();
	}

	public void fillUpQuestion(String question) {
		questionInput.sendKeys(question);
	}

	public void clickAsk() {
		askButton.click();
	}

	public void clickConfirmAsk() {
		confirmAskButton.click();
	}

	public void clickVote() {
		voteButton.click();
	}

	public void clickAnnouncementPopUPClose() {
		announcementPopUPCloseButton.click();
	}

	public void clickCasteYourVote() {
		casteYourVoteButton.click();
	}

	public void clickVoteOption() {
		Actions action = new Actions(driver);
		action.moveToElement(firstVoteOptionButton).click().build().perform();
	}

	public void clickNext() {
		nextButton.click();
	}

	public void clickNumericOption() throws Throwable {
		GenericMethods.waitForElement(PigeonHole_AudienceWebAppPage.nextButton);
		clickNext();
		GenericMethods.sychronizationinterval();
		numericInputOptionFourButton.click();
	}

	public void clickVoteButton(int x_cordinate, int y_cordinate) throws Throwable {
		clickNext();
		WebElement slider = driver.findElement(By.cssSelector(".draggable-background"));
		Actions action = new Actions(driver);
		action.clickAndHold(slider);
		GenericMethods.sychronizationinterval();
		action.moveByOffset(x_cordinate, y_cordinate);
		GenericMethods.sychronizationinterval();
		action.release().build().perform();
		GenericMethods.sychronizationinterval();
		confirmVoteButton.click();
	}

	public void clickIconRating() {
		iconRatingButton.click();
	}

	public void clickBack() {
		backButton.click();
	}

	public void clickSkip() {
		skipButton.click();
	}
	
	
}
