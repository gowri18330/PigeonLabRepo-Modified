package com.PigeonHole.RegressionScripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

import com.PigeonHole.FunctionalLibrary.GenericMethods;
import com.PigeonHole.Pages.PigeonHole_AdminPanelPage;
import com.PigeonHole.Pages.PigeonHole_AgendaPage;
import com.PigeonHole.Pages.PigeonHole_AudienceWebAppPage;
import com.PigeonHole.Pages.PigeonHole_DashboardPage;
import com.PigeonHole.Pages.PigeonHole_ProjectorPanelPage;
import com.PigeonHole.Pages.PigeonHole_RunEventsPage;
import com.PigeonHole.pageFactoryInitilization.PageElementsInitialization;
import com.github.javafaker.Faker;

public class PigeonHole_MultipleChoicePoll_Test extends GenericMethods {

	public PigeonHole_DashboardPage dashboardPage;
	public PigeonHole_RunEventsPage runEventsPage;
	public PigeonHole_AudienceWebAppPage audienceWebAppPage;
	public PigeonHole_AdminPanelPage adminPanelPage;
	public PigeonHole_ProjectorPanelPage projectorPanelPage;
	public PigeonHole_AgendaPage agendaPage;
	public PageElementsInitialization elementsInitialization;

	Faker faker = new Faker();
	// TestData
	String sessionName = faker.name().name();
	String firstPollQuestion = faker.name().name();
	String firstPollOptionOne = faker.name().name();
	String firstPollOptionTwo = faker.name().name();
	String firstPollOptionThree = faker.name().name();
	String firstPollOptionFour = faker.name().name();

	String obtainedVotePercentageForFirstPOll;
	String url = "multiplechoice_poll_URL";
	String expectedPollQuizColor = "#f07424";
	int draggableScore = 55;
	int iconRating = 7;
	int pollsCount = 4;
	int participantsCount = 1;
	int voteAverage = 4;
	int draggable_x_cordinate = 25;
	int draggable_y_cordinate = 0;

	int agenda_Page = 1;
	int audienceWebApp_Page = 2;
	int adminPanel_Page = 3;
	int projectorPanel_Page = 4;

	@BeforeClass
	public void appLaunch() {
		GenericMethods.openBrowser();
		GenericMethods.navigateAppUrl(url);

		dashboardPage = new PigeonHole_DashboardPage();
		runEventsPage = new PigeonHole_RunEventsPage();
		audienceWebAppPage = new PigeonHole_AudienceWebAppPage();
		adminPanelPage = new PigeonHole_AdminPanelPage();
		projectorPanelPage = new PigeonHole_ProjectorPanelPage();
		agendaPage = new PigeonHole_AgendaPage();
		elementsInitialization = new PageElementsInitialization();

		elementsInitialization.dashBoardPageObjectory();
		elementsInitialization.adminPannelPageObjectory();
		elementsInitialization.AWAPageObjectory();
		elementsInitialization.projecterPageObjectory();
		elementsInitialization.runEventsPageObjectory();
		elementsInitialization.agendaPageObjectory();
	}

	// click Add Pigeonhole and select “Basic Pigeonhole”.
	@Test(priority = 1)
	public void Add_Pigeonhole() throws Exception {

		GenericMethods.checkIfButtonExistsAndClick(dashboardPage.gotItButton);

		dashboardPage.clickOnAddPigeonHole();

		GenericMethods.waitForElement(dashboardPage.basicPigeonHoleButton);

		dashboardPage.clickOnBasicPigeonHole();
	}

	// fill in any event name, random the passcode and set the start of the event
	// date as today.
	@Test(priority = 2)
	public void eventCreation() throws Throwable {

		GenericMethods.sychronizationinterval();

		String multipleChoicePollName = faker.name().name();

		dashboardPage.fillEventName(multipleChoicePollName);

		dashboardPage.clickOnRandomPassCode();

		GenericMethods.sychronizationinterval();

		dashboardPage.clickOnContinueButton();
	}

	// In Agenda, click add session.
	@Test(priority = 3)
	public void addSession() throws Throwable {

		GenericMethods.waitForElement(agendaPage.goToAgenda);

		agendaPage.clickGoToAgenda();

		GenericMethods.checkIfButtonExistsAndClick(agendaPage.gotItButton);

		agendaPage.clickAddSession();
	}

	// select “poll: multiple choice” and fill in any session name.
	@Test(priority = 4)
	public void multipleChoicePoll() {

		agendaPage.clickMultipleChoicePoll();

		agendaPage.fillSessionName(sessionName);

		// Add question, select “text/image” question type, add your own question
		// and options. Click Save

		agendaPage.clickAddQuestion();

		GenericMethods.waitForElement(agendaPage.pollQuestionInput);

		agendaPage.fillPollQuestion(firstPollQuestion);

		agendaPage.fillPollOptionOne(firstPollOptionOne);

		agendaPage.fillPollOptionTwo(firstPollOptionTwo);

		GenericMethods.waitForElement(agendaPage.optionThree);

		agendaPage.fillPollOptionThree(firstPollOptionThree);

		agendaPage.fillPollOptionFour(firstPollOptionFour);

		agendaPage.clickSaveButton();

	}

	// Add question, select “numeric scale” question type, change lowest
	// value to 0, add your own question. Click Save
	@Test(priority = 5)
	public void numericScale() throws Throwable {

		GenericMethods.waitForElement(agendaPage.addQuestionButton);

		agendaPage.clickAddQuestion();

		GenericMethods.sychronizationinterval();

		GenericMethods.waitForElement(agendaPage.questionTypeDropDown);

		agendaPage.clickQuestionType();

		GenericMethods.waitForElement(agendaPage.numericDropDownOption);

		agendaPage.selectNumericScale();

		agendaPage.setLowestValueToZero();

		String secondPollQuestion = faker.name().name();

		agendaPage.fillPollQuestion(secondPollQuestion);

		agendaPage.clickSaveButton();

	}

	// Add question, select “draggable scale” question type, change highest
	// value to 100, add your own question. Click Save
	@Test(priority = 6)
	public void draggableScale() throws Throwable {

		GenericMethods.sychronizationinterval();

		agendaPage.clickAddQuestion();

		GenericMethods.waitForElement(agendaPage.questionTypeDropDown);

		agendaPage.clickQuestionType();

		GenericMethods.waitForElement(agendaPage.numericDropDownOption);

		agendaPage.selectDraggable();

		agendaPage.setHighestValueToHundred();

		String thirdPollQuestion = faker.name().name();

		agendaPage.fillPollQuestion(thirdPollQuestion);

		agendaPage.clickSaveButton();
	}

	// Add question, select “ icon rating question type, change steps to 10,
	// add your own question. Click Save
	@Test(priority = 7)
	public void iconRating() {

		GenericMethods.waitForElement(agendaPage.addQuestionButton);

		agendaPage.clickAddQuestion();

		GenericMethods.waitForElement(agendaPage.questionTypeDropDown);

		agendaPage.clickQuestionType();

		GenericMethods.waitForElement(agendaPage.iconRatingOption);

		agendaPage.selectIconRating();

		agendaPage.setStepsToTen();

		String fourthPollQuestion = faker.name().name();

		agendaPage.fillPollQuestion(fourthPollQuestion);

		agendaPage.clickSaveButton();
	}

	// check “attendee see the live results on the AWA after voting”
	// click Add multiple choice.
	@Test(priority = 8)
	public void attendeeCheckBox() {

		agendaPage.clickAWAcheckBox();

		agendaPage.clickAddMultipleChoiceButton();
	}

	// check that the icon and event name is the same as your input.
	@Test(priority = 9)
	public void iconAndEventNameAssertion() {

		GenericMethods.waitForElement(agendaPage.verifySessionName);

		String obtainedSessionName = agendaPage.verifySessionName.getText();

		Assert.assertEquals(obtainedSessionName, sessionName, "Obtained sessionName did not match");

		Assert.assertTrue(agendaPage.verifySessionIcon.isDisplayed(), "session icon element not visible.");
	}

	// click the dropdown arrow next to edit button, select start the session
	@Test(priority = 10)
	public void editNextButtonClick() {

		agendaPage.clickEditNextArrowButton();

		GenericMethods.waitForElement(agendaPage.editNextArrowStartButton);

		agendaPage.clickEditNextArrowStartButton();

		GenericMethods.waitForElement(agendaPage.popUpStartButton);

		agendaPage.clickPopUpStartButton();
	}

	// Step-16 click on the “Run links” button.
	// click Audience Web App
	// A new tab will open, you should be on the new page. In awa, check if
	// the session name shows up.

	@Test(priority = 11)
	public void AudienceWebApp() throws Throwable {

		GenericMethods.sychronizationinterval();

		GenericMethods.waitForElement(agendaPage.runLinkButton);

		agendaPage.clickRunLinkButton();

		GenericMethods.waitForElement(agendaPage.AWAbutton);

		agendaPage.clickAudienceWebApp();

		GenericMethods.switchToNewWindow(audienceWebApp_Page);

		GenericMethods.sychronizationinterval();

		GenericMethods.waitForElement(audienceWebAppPage.verifySessionName);

		String obtainedSessionNameInAwa = audienceWebAppPage.verifySessionName.getText();

		Assert.assertEquals(obtainedSessionNameInAwa, sessionName, "Obtained sessionName did not match");
	}

	// Click on the “Run links” button then click Admin Panel.
	// In Admin Panel, check if the session name shows up and if the icon is in
	// orange.
	@Test(priority = 12)
	public void AdminPanel() throws Throwable {

		GenericMethods.switchToNewWindow(agenda_Page);

		GenericMethods.sychronizationinterval();

		GenericMethods.waitForElement(agendaPage.runLinkButton);

		agendaPage.clickRunLinkButton();

		GenericMethods.waitForElement(agendaPage.adminpanelButton);

		agendaPage.clickAdminPanel();

		GenericMethods.switchToNewWindow(adminPanel_Page);

		GenericMethods.sychronizationinterval();

		GenericMethods.waitForElement(adminPanelPage.verifySessionName);

		String obtainedSessionNameInAdminPanel = adminPanelPage.verifySessionName.getText();

		Assert.assertEquals(obtainedSessionNameInAdminPanel, sessionName, "Obtained sessionName did not match");

		Assert.assertEquals(expectedPollQuizColor,
				GenericMethods.getColourOfElement(adminPanelPage.verifySessionColor));
	}

	// Click on the “Run links” button then click Projector Panel.
	// check if the session name shows up and if the icon is in orange.

	@Test(priority = 13)
	public void ProjectorPanel() throws Throwable {

		GenericMethods.switchToNewWindow(agenda_Page);

		GenericMethods.sychronizationinterval();

		GenericMethods.waitForElement(agendaPage.runLinkButton);

		agendaPage.clickRunLinkButton();

		agendaPage.clickProjectorPanel();

		GenericMethods.switchToNewWindow(projectorPanel_Page);

		GenericMethods.sychronizationinterval();

		GenericMethods.waitForElement(projectorPanelPage.verifySessionName);

		String obtainedSessionNameInProjectorPanel = projectorPanelPage.verifySessionName.getText();

		Assert.assertEquals(obtainedSessionNameInProjectorPanel, sessionName, "Obtained sessionName did not match");

		Assert.assertEquals(expectedPollQuizColor,
				GenericMethods.getColourOfElement(projectorPanelPage.verifySessionColor));
	}

	// Switch tab to awa, click “cast your vote” to see question one. Click on any
	// options to vote.
	@Test(priority = 14)
	public void castYourVote() throws Throwable {

		GenericMethods.switchToNewWindow(audienceWebApp_Page);

		GenericMethods.sychronizationinterval();

		audienceWebAppPage.clickCasteYourVote();

		GenericMethods.waitForElement(audienceWebAppPage.verifyPollQuestion);

		String obtainedQuestionInAWA = audienceWebAppPage.verifyPollQuestion.getText();

		Assert.assertEquals(obtainedQuestionInAWA, firstPollQuestion, "Obtained poll question did not match");

		GenericMethods.waitForElement(audienceWebAppPage.firstVoteOptionButton);

		audienceWebAppPage.clickVoteOption();

		GenericMethods.waitForElement(audienceWebAppPage.verifyVoteOption);

		String obtainedVoteOptionForFirstPOll = audienceWebAppPage.verifyVoteOption.getText();

		GenericMethods.waitForElement(audienceWebAppPage.verifyVotePercentage);

		obtainedVotePercentageForFirstPOll = audienceWebAppPage.verifyVotePercentage.getText();
	}

	// Switch tab to Admin panel, click on the session to enter. Check that the
	// voted option and percentage is the same as you have voted.
	@Test(priority = 15)
	public void votedOptionAndPercentageInAdminPanel() throws Throwable {

		GenericMethods.sychronizationinterval();

		GenericMethods.switchToNewWindow(adminPanel_Page);

		GenericMethods.sychronizationinterval();

		adminPanelPage.clickSession();

		GenericMethods.waitForElement(adminPanelPage.firstVoteOption);

		String obtainedVoteOptionInAdminPanel = adminPanelPage.firstVoteOption.getText();

		Assert.assertEquals(obtainedVoteOptionInAdminPanel, firstPollOptionOne, "Obtained voteOption did not match");

		GenericMethods.waitForElement(adminPanelPage.firstVotePercentage);

		String obtainedVotePercentageInAdminPanel = adminPanelPage.firstVotePercentage.getText();

		obtainedVotePercentageInAdminPanel.contains(obtainedVotePercentageForFirstPOll);
	}

	// Switch tab to Projector panel, click on the session to enter. Check that the
	// voted option and percentage is the same as you have voted.
	@Test(priority = 16)
	public void votedOptionAndPercentageInProjectorPanel() throws Throwable {

		GenericMethods.switchToNewWindow(projectorPanel_Page);

		GenericMethods.sychronizationinterval();

		projectorPanelPage.clickSession();

		GenericMethods.waitForElement(projectorPanelPage.firstVoteOption);

		String obtainedVoteOptionInProjectorPanel = projectorPanelPage.firstVoteOption.getText();

		Assert.assertEquals(obtainedVoteOptionInProjectorPanel, firstPollOptionOne,
				"Obtained voteOption did not match");

		GenericMethods.waitForElement(projectorPanelPage.firstVotePercentage);

		String obtainedVotePercentageInProjectorPanel = projectorPanelPage.firstVotePercentage.getText();

		obtainedVotePercentageInProjectorPanel.contains(obtainedVotePercentageForFirstPOll);
	}

	// Until you have answered all the questions on AWA.
	// Switch tab to awa, click next, you should see “Thank you for participating”
	// and a Back button.
	@Test(priority = 17)
	public void ThankYouForParticipating() throws Throwable {

		GenericMethods.switchToNewWindow(audienceWebApp_Page);

		GenericMethods.sychronizationinterval();

		GenericMethods.waitForElement(audienceWebAppPage.nextButton);

		audienceWebAppPage.clickNext();

		GenericMethods.sychronizationinterval();

		audienceWebAppPage.clickNumericOption();

		GenericMethods.sychronizationinterval();

		GenericMethods.switchToNewWindow(adminPanel_Page);

		GenericMethods.sychronizationinterval();

		adminPanelPage.clickNext();

		GenericMethods.waitForElement(adminPanelPage.verifyAverageValue);

		String obtainedVoteAverageInAdminrPanel = adminPanelPage.verifyAverageValue.getText();

		Assert.assertEquals(Integer.parseInt(obtainedVoteAverageInAdminrPanel), voteAverage,
				"Obtained vote average did not match");

		GenericMethods.switchToNewWindow(projectorPanel_Page);

		GenericMethods.sychronizationinterval();

		GenericMethods.waitForElement(projectorPanelPage.verifyAverageValue);

		String obtainedVoteAverageInProjectorPanel = projectorPanelPage.verifyAverageValue.getText();

		Assert.assertEquals(Integer.parseInt(obtainedVoteAverageInProjectorPanel), voteAverage,
				"Obtained vote average did not match");

		GenericMethods.switchToNewWindow(audienceWebApp_Page); // switching to audienceWebAppPage window

		GenericMethods.sychronizationinterval();

		GenericMethods.waitForElement(audienceWebAppPage.nextButton);

		audienceWebAppPage.clickNext();

		WebElement slider = driver.findElement(By.cssSelector(".draggable-background"));

		Actions action = new Actions(driver);

		action.clickAndHold(slider);

		GenericMethods.sychronizationinterval();

		action.moveByOffset(draggable_x_cordinate, draggable_y_cordinate);

		GenericMethods.sychronizationinterval();

		action.release().build().perform();

		audienceWebAppPage.clickVoteButton();

		GenericMethods.sychronizationinterval();

		GenericMethods.switchToNewWindow(adminPanel_Page);

		GenericMethods.sychronizationinterval();

		adminPanelPage.clickNext();

		GenericMethods.sychronizationinterval();

		GenericMethods.waitForElement(adminPanelPage.verifyAverageValue);

		String obtainedVoteDraggableScoreInAdminrPanel = adminPanelPage.verifyAverageValue.getText();

		Assert.assertEquals(Integer.parseInt(obtainedVoteDraggableScoreInAdminrPanel), draggableScore,
				"Obtained Draggable average did not match");

		GenericMethods.switchToNewWindow(projectorPanel_Page);

		GenericMethods.sychronizationinterval();

		GenericMethods.waitForElement(projectorPanelPage.verifyAverageValue);

		String obtainedVoteDraggableScoreInProjectorPanel = projectorPanelPage.verifyAverageValue.getText();

		Assert.assertEquals(Integer.parseInt(obtainedVoteDraggableScoreInProjectorPanel), draggableScore,
				"Obtained Draggable average did not match");

		GenericMethods.switchToNewWindow(audienceWebApp_Page);

		GenericMethods.sychronizationinterval();

		GenericMethods.waitForElement(audienceWebAppPage.nextButton);

		audienceWebAppPage.clickNext();

		GenericMethods.sychronizationinterval();

		audienceWebAppPage.clickIconRating();

		String obtainedIconRatingInAWAPage = audienceWebAppPage.verifyIconRating.getText();

		GenericMethods.switchToNewWindow(adminPanel_Page);

		GenericMethods.sychronizationinterval();

		adminPanelPage.clickNext();

		GenericMethods.sychronizationinterval();

		GenericMethods.waitForElement(adminPanelPage.verifyAverageScoreValue);

		String obtainedVoteScoreInAdminrPanel = adminPanelPage.verifyAverageScoreValue.getText();

		Assert.assertEquals(Integer.parseInt(obtainedVoteScoreInAdminrPanel), iconRating,
				"Obtained Icon Rating did not match");

		GenericMethods.switchToNewWindow(projectorPanel_Page);

		GenericMethods.sychronizationinterval();

		GenericMethods.waitForElement(projectorPanelPage.verifyAverageScoreValue);

		String obtainedVoteScoreInProjectorPanel = projectorPanelPage.verifyAverageScoreValue.getText();

		Assert.assertEquals(Integer.parseInt(obtainedVoteScoreInProjectorPanel), iconRating,
				"Obtained Icon Rating average did not match");

		GenericMethods.switchToNewWindow(audienceWebApp_Page);

		GenericMethods.sychronizationinterval();

		GenericMethods.waitForElement(audienceWebAppPage.nextButton);

		audienceWebAppPage.clickNext();

		GenericMethods.sychronizationinterval();

		String obtainedThankYouText = audienceWebAppPage.thankYouText.getText();

		Assert.assertEquals(obtainedThankYouText, "Thank you for participating!",
				"Obtained ThankYou Message did not match");
	}

	// Switch to Admin Panel, click next,
	// you should see the summary of the poll: 1 Total Participants, 4 Questions
	// Polled, 4 Total Votes and a “Back to question 1” button.
	@Test(priority = 18)
	public void summaryOfThePoll() throws Throwable {

		audienceWebAppPage.clickBack();

		GenericMethods.switchToNewWindow(adminPanel_Page);

		GenericMethods.sychronizationinterval();

		adminPanelPage.clickNext();

		GenericMethods.sychronizationinterval();

		String verifyTotalParticipantsCount = adminPanelPage.verifyTotalParticipants.getText();

		Assert.assertEquals(Integer.parseInt(verifyTotalParticipantsCount), participantsCount,
				"Obtained Total Participants Count did not match");

		String verifyTotalQuestionsPollCount = adminPanelPage.verifyQuestionsPolled.getText();

		Assert.assertEquals(Integer.parseInt(verifyTotalQuestionsPollCount), pollsCount,
				"Obtained Total Questions Poll Count did not match");

		String verifyTotalVotesCount = adminPanelPage.verifyTotalVotes.getText();

		Assert.assertEquals(Integer.parseInt(verifyTotalVotesCount), pollsCount,
				"Obtained Total Votes Count did not match");
	}

	// Switch to Projector Panel, without clicking, you should see the summary of
	// the poll: 1 Total Participants, 4 Questions Polled and 4 Total Votes.
	@Test(priority = 19)
	public void verifyFinalCount() throws Throwable {

		GenericMethods.switchToNewWindow(projectorPanel_Page);

		GenericMethods.sychronizationinterval();

		String verifyTotalParticipantsCountInProjectorPanel = projectorPanelPage.verifyTotalParticipants.getText();

		Assert.assertEquals(Integer.parseInt(verifyTotalParticipantsCountInProjectorPanel), participantsCount,
				"Obtained Total Participants Count did not match");

		String verifyTotalQuestionsPollCountInProjectorPanel = projectorPanelPage.verifyQuestionsPolled.getText();

		Assert.assertEquals(Integer.parseInt(verifyTotalQuestionsPollCountInProjectorPanel), pollsCount,
				"Obtained Total Questions Poll Count did not match");

		String verifyTotalVotesCountInProjectorPanel = projectorPanelPage.verifyTotalVotes.getText();

		Assert.assertEquals(Integer.parseInt(verifyTotalVotesCountInProjectorPanel), pollsCount,
				"Obtained Total Votes Count did not match");
	}

	@AfterClass
	public void quitDriversession() {
		GenericMethods.CloseDriverSession();
	}
}
