package com.PigeonHole.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.PigeonHole.FunctionalLibrary.GenericMethods;

public class PigeonHole_ProjectorPanelPage extends GenericMethods {

	@FindBy(how = How.XPATH, using = "(//span[contains(text(),'Technology and Corporate Communications')])[2]")
	public static WebElement eventName;

	@FindBy(how = How.CSS, using = ".qna-content")
	public static WebElement questionName;

	@FindBy(how = How.XPATH, using = "(//div[@class=\"qna-content\"])[2]")
	public static WebElement secondQuestion;

	@FindBy(how = How.XPATH, using = "//div[@class=\"active-question-text\"]")
	public static WebElement activeQuestion;

	@FindBy(how = How.XPATH, using = "(//div[@class=\"sl-name\"])[2]/span")
	public static WebElement verifySessionName;

	@FindBy(how = How.XPATH, using = "(//span[contains(@class,\"icon-poll\")])[3]")
	public static WebElement verifySessionColor;

	@FindBy(how = How.XPATH, using = "(//div[@class='chart-label'])[1]")
	public static WebElement firstVoteOption;

	@FindBy(how = How.XPATH, using = "(//span[@class=\"percentage\"])[1]")
	public static WebElement firstVotePercentage;

	@FindBy(how = How.CSS, using = ".average-value")
	public static WebElement verifyAverageValue;

	@FindBy(how = How.CSS, using = ".average-score-value")
	public static WebElement verifyAverageScoreValue;

	@FindBy(how = How.CSS, using = ".total-participant")
	public static WebElement verifyTotalParticipants;

	@FindBy(how = How.XPATH, using = "(//div[@class=\"insight-data-count\"])[1]")
	public static WebElement verifyQuestionsPolled;

	@FindBy(how = How.XPATH, using = "(//div[@class=\"insight-data-count\"])[2]")
	public static WebElement verifyTotalVotes;

	@FindBy(how = How.XPATH, using = "//div[@class='sl-screen-type on-going']//span[@class='icon icon-poll-quiz']")
	public static WebElement pollQuizIcon;

	@FindBy(how = How.XPATH, using = "//div[@class='session-list-collection-container']//div[@class='sl-item-wrap']")
	public static WebElement sessionField;

	@FindBy(how = How.XPATH, using = "//div[@class='text-wrapper']//span[@class='participant-count']")
	public static WebElement participentCountField;

	@FindBy(how = How.XPATH, using = "//div[@class='score']//span[@class='value']")
	public static WebElement projectorPannelScoreValueField;

	@FindBy(how = How.XPATH, using = "//div[@class='score']//span[@class='total']")
	public static WebElement projectorPannelTotalScoreField;

	@FindBy(how = How.XPATH, using = "//div[@class='first-rank-bottom']//span[@class='value']")
	public static WebElement projectorFinalScoreField;

	@FindBy(how = How.XPATH, using = "//div[@class='first-rank-bottom']//span[@class='total']")
	public static WebElement projectorFinalTotalScoreField;

	public boolean validateSession(String sessionName) throws Throwable {
		GenericMethods.sychronizationinterval();
		return driver.findElement(By.xpath("//div[@class='sl-item-wrap']//span[text() ='" + sessionName + "']"))
				.isDisplayed();
	}

	public void clickOnSession() {
		sessionField.click();
	}

	public int getParticipentCount() {
		String participent = participentCountField.getText();
		int participentCount = Integer.parseInt(participent);
		return participentCount;
	}

	public String getProjectorPannelScore() {
		String value = projectorPannelScoreValueField.getText();
		String totaleScore = projectorPannelTotalScoreField.getText();
		String score = value + totaleScore;
		return score;
	}

	public String getprojectorPannelResult() throws Throwable {
		Thread.sleep(2000);
		String value = projectorFinalScoreField.getText();
		Thread.sleep(2000);
		String totaleScore = projectorFinalTotalScoreField.getText();
		String score = value + totaleScore;
		return score;
	}

	public void clickEvent() {
		eventName.click();
	}

	public void clickSession() {
		verifySessionName.click();
	}
}
