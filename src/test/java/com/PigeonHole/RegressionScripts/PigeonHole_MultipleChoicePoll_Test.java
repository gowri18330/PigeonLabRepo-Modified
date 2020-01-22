package com.PigeonHole.RegressionScripts;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


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

	//Objects Declaration Section
	public PigeonHole_DashboardPage dashboardPage;
	public PigeonHole_RunEventsPage runEventsPage;
	public PigeonHole_AudienceWebAppPage audienceWebAppPage;
	public PigeonHole_AdminPanelPage adminPanelPage;
	public PigeonHole_ProjectorPanelPage projectorPanelPage;
	public PigeonHole_AgendaPage agendaPage;
	public PageElementsInitialization elementsInitialization;
	Faker faker = new Faker();
	
	//Test Input Data Section
	String sessionName = faker.name().name();
	String firstPollQuestion = faker.name().name();
	String firstPollOptionOne = faker.name().name();
	String firstPollOptionTwo = faker.name().name();
	String firstPollOptionThree = faker.name().name();
	String firstPollOptionFour = faker.name().name();
	String obtainedVotePercentageForFirstPOll;
	String obtainedVoteOptionForFirstPOll;
	String obtainedIconRatingInAWAPage;
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

	/* Launch the browser and navigate the Application */
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
	public void addPigeonhole() throws Throwable {

		GenericMethods.checkIfButtonExistsAndClick(PigeonHole_DashboardPage.gotItButton);

		dashboardPage.clickOnAddPigeonHole();

		GenericMethods.waitForElement(PigeonHole_DashboardPage.basicPigeonHoleButton);

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

		GenericMethods.waitForElement(PigeonHole_AgendaPage.goToAgenda);

		agendaPage.clickGoToAgenda();

		GenericMethods.checkIfButtonExistsAndClick(PigeonHole_AgendaPage.gotItButton);

		agendaPage.clickAddSession();
	}

	// select “poll: multiple choice” and fill in any session name.
	// Add question, select “text/image” question type, add your own question and options. Click Save
	@Test(priority = 4)
	public void addTextOrImagePollQuestion() {

		agendaPage.clickMultipleChoicePoll();

		agendaPage.fillSessionName(sessionName);

		agendaPage.clickAddQuestion();

		GenericMethods.waitForElement(PigeonHole_AgendaPage.pollQuestionInput);

		agendaPage.fillPollQuestion(firstPollQuestion);

		agendaPage.fillPollOptionOne(firstPollOptionOne);

		agendaPage.fillPollOptionTwo(firstPollOptionTwo);

		GenericMethods.waitForElement(PigeonHole_AgendaPage.optionThree);

		agendaPage.fillPollOptionThree(firstPollOptionThree);

		agendaPage.fillPollOptionFour(firstPollOptionFour);

		agendaPage.clickSaveButton();

	}

	// Add question, select “numeric scale” question type, change lowest
	// value to 0, add your own question. Click Save
	@Test(priority = 5)
	public void addNumericScalePollQuestion() throws Throwable {

		GenericMethods.waitForElement(PigeonHole_AgendaPage.addQuestionButton);

		agendaPage.clickAddQuestion();

		GenericMethods.sychronizationinterval();

		GenericMethods.waitForElement(PigeonHole_AgendaPage.questionTypeDropDown);

		agendaPage.clickQuestionType();

		GenericMethods.waitForElement(PigeonHole_AgendaPage.numericDropDownOption);

		agendaPage.selectNumericScale();

		agendaPage.setLowestValueToZero();

		String secondPollQuestion = faker.name().name();

		agendaPage.fillPollQuestion(secondPollQuestion);

		agendaPage.clickSaveButton();

	}

	// Add question, select “draggable scale” question type, change highest
	// value to 100, add your own question. Click Save
	@Test(priority = 6)
	public void addDraggableScalePollQuestion() throws Throwable {

		GenericMethods.sychronizationinterval();

		agendaPage.clickAddQuestion();

		GenericMethods.waitForElement(PigeonHole_AgendaPage.questionTypeDropDown);

		agendaPage.clickQuestionType();

		GenericMethods.waitForElement(PigeonHole_AgendaPage.numericDropDownOption);

		agendaPage.selectDraggable();

		agendaPage.setHighestValueToHundred();

		String thirdPollQuestion = faker.name().name();

		agendaPage.fillPollQuestion(thirdPollQuestion);

		agendaPage.clickSaveButton();
	}

	// Add question, select “ icon rating question type, change steps to 10,
	// add your own question. Click Save
	@Test(priority = 7)
	public void addIconRatingPollQuestion() {

		GenericMethods.waitForElement(PigeonHole_AgendaPage.addQuestionButton);

		agendaPage.clickAddQuestion();

		GenericMethods.waitForElement(PigeonHole_AgendaPage.questionTypeDropDown);

		agendaPage.clickQuestionType();

		GenericMethods.waitForElement(PigeonHole_AgendaPage.iconRatingOption);

		agendaPage.selectIconRating();

		agendaPage.setStepsToTen();

		String fourthPollQuestion = faker.name().name();

		agendaPage.fillPollQuestion(fourthPollQuestion);

		agendaPage.clickSaveButton();
	}

	// check “attendee see the live results on the AWA after voting”
	// click Add multiple choice.
	@Test(priority = 8)
	public void selectAttendeeCheckBox() throws Throwable {
		GenericMethods.sychronizationinterval();
		agendaPage.clickAWAcheckBox();
		agendaPage.clickAddMultipleChoiceButton();
	}

	// check that the icon and event name is the same as your input.
	@Test(priority = 9)
	public void iconAndEventNameAssertion() {
		GenericMethods.waitForElement(PigeonHole_AgendaPage.verifySessionName);
		String obtainedSessionName = PigeonHole_AgendaPage.verifySessionName.getText();
		Assert.assertEquals(obtainedSessionName, sessionName, "Obtained sessionName did not match");
		Assert.assertTrue(PigeonHole_AgendaPage.verifySessionIcon.isDisplayed(), "session icon element not visible.");
	}

	// click the dropdown arrow next to edit button, select start the session
	@Test(priority = 10)
	public void startSession() {
		agendaPage.clickEditNextArrowButton();
		GenericMethods.waitForElement(PigeonHole_AgendaPage.editNextArrowStartButton);
		agendaPage.clickEditNextArrowStartButton();
		GenericMethods.waitForElement(PigeonHole_AgendaPage.popUpStartButton);
		agendaPage.clickPopUpStartButton();
	}

	// Step-16 click on the “Run links” button.
	// click Audience Web App
	// A new tab will open, you should be on the new page. In awa, check if
	// the session name shows up.

	@Test(priority = 11)
	public void validateSessionInAudienceWebApp() throws Throwable {

		GenericMethods.sychronizationinterval();

		GenericMethods.waitForElement(PigeonHole_AgendaPage.runLinkButton);

		agendaPage.clickRunLinkButton();

		GenericMethods.waitForElement(PigeonHole_AgendaPage.AWAbutton);

		agendaPage.clickAudienceWebApp();

		GenericMethods.switchToNewWindow(audienceWebApp_Page);

		GenericMethods.sychronizationinterval();

		GenericMethods.waitForElement(PigeonHole_AudienceWebAppPage.verifySessionName);

		String obtainedSessionNameInAwa = PigeonHole_AudienceWebAppPage.verifySessionName.getText();

		Assert.assertEquals(obtainedSessionNameInAwa, sessionName, "Obtained sessionName did not match");
	}

	// Click on the “Run links” button then click Admin Panel.
	// In Admin Panel, check if the session name shows up and if the icon is in
	// orange.
	@Test(priority = 12)
	public void validateSessionInAdminPanel() throws Throwable {

		GenericMethods.switchToNewWindow(agenda_Page);
		GenericMethods.sychronizationinterval();
		GenericMethods.waitForElement(PigeonHole_AgendaPage.runLinkButton);
		agendaPage.clickRunLinkButton();
		GenericMethods.waitForElement(PigeonHole_AgendaPage.adminpanelButton);
		agendaPage.clickAdminPanel();
		GenericMethods.switchToNewWindow(adminPanel_Page);
		GenericMethods.sychronizationinterval();
		GenericMethods.waitForElement(PigeonHole_AdminPanelPage.verifySessionName);
		String obtainedSessionNameInAdminPanel = PigeonHole_AdminPanelPage.verifySessionName.getText();
		Assert.assertEquals(obtainedSessionNameInAdminPanel, sessionName, "Obtained sessionName did not match");
		Assert.assertEquals(expectedPollQuizColor,
				GenericMethods.getColourOfElement(PigeonHole_AdminPanelPage.verifySessionColor));
	}

	// Click on the “Run links” button then click Projector Panel.
	// check if the session name shows up and if the icon is in orange.

	@Test(priority = 13)
	public void validateSessionInProjectorPanel() throws Throwable {

		GenericMethods.switchToNewWindow(agenda_Page);
		GenericMethods.sychronizationinterval();
		GenericMethods.waitForElement(PigeonHole_AgendaPage.runLinkButton);
		agendaPage.clickRunLinkButton();
		agendaPage.clickProjectorPanel();
		GenericMethods.switchToNewWindow(projectorPanel_Page);
		GenericMethods.sychronizationinterval();
		GenericMethods.waitForElement(PigeonHole_ProjectorPanelPage.verifySessionName);
		String obtainedSessionNameInProjectorPanel = PigeonHole_ProjectorPanelPage.verifySessionName.getText();
		Assert.assertEquals(obtainedSessionNameInProjectorPanel, sessionName, "Obtained sessionName did not match");
		Assert.assertEquals(expectedPollQuizColor,
				GenericMethods.getColourOfElement(PigeonHole_ProjectorPanelPage.verifySessionColor));
	}

	// Switch tab to awa, click “cast your vote” to see question one. Click on any
	// options to vote.
	@Test(priority = 14)
	public void castYourVote() throws Throwable {

		GenericMethods.switchToNewWindow(audienceWebApp_Page);
		GenericMethods.sychronizationinterval();
		audienceWebAppPage.clickCasteYourVote();
		GenericMethods.waitForElement(PigeonHole_AudienceWebAppPage.verifyPollQuestion);
		String obtainedQuestionInAWA = PigeonHole_AudienceWebAppPage.verifyPollQuestion.getText();
		Assert.assertEquals(obtainedQuestionInAWA, firstPollQuestion, "Obtained poll question did not match");
		GenericMethods.waitForElement(PigeonHole_AudienceWebAppPage.firstVoteOptionButton);
		audienceWebAppPage.clickVoteOption();
		GenericMethods.waitForElement(PigeonHole_AudienceWebAppPage.verifyVoteOption);
		obtainedVoteOptionForFirstPOll = PigeonHole_AudienceWebAppPage.verifyVoteOption.getText();
		GenericMethods.waitForElement(PigeonHole_AudienceWebAppPage.verifyVotePercentage);
		obtainedVotePercentageForFirstPOll = PigeonHole_AudienceWebAppPage.verifyVotePercentage.getText();
	}

	// Switch tab to Admin panel, click on the session to enter. Check that the
	// voted option and percentage is the same as you have voted.
	@Test(priority = 15)
	public void VerifyVotedOptionAndPercentageInAdminPanel() throws Throwable {

		GenericMethods.sychronizationinterval();
		GenericMethods.switchToNewWindow(adminPanel_Page);
		GenericMethods.sychronizationinterval();
		adminPanelPage.clickSession();
		GenericMethods.waitForElement(PigeonHole_AdminPanelPage.firstVoteOption);
		String obtainedVoteOptionInAdminPanel = PigeonHole_AdminPanelPage.firstVoteOption.getText();
		Assert.assertEquals(obtainedVoteOptionInAdminPanel, firstPollOptionOne, "Obtained voteOption did not match");
		GenericMethods.waitForElement(PigeonHole_AdminPanelPage.firstVotePercentage);
		Thread.sleep(3000);
		String obtainedVotePercentageInAdminPanel = PigeonHole_AdminPanelPage.firstVotePercentage.getText();
		obtainedVotePercentageInAdminPanel.contains(obtainedVotePercentageForFirstPOll);
	}

	// Switch tab to Projector panel, click on the session to enter. Check that the
	// voted option and percentage is the same as you have voted.
	@Test(priority = 16)
	public void veifyVotedOptionAndPercentageInProjectorPanel() throws Throwable {

		GenericMethods.switchToNewWindow(projectorPanel_Page);
		GenericMethods.sychronizationinterval();
		projectorPanelPage.clickSession();
		GenericMethods.waitForElement(PigeonHole_ProjectorPanelPage.firstVoteOption);
		String obtainedVoteOptionInProjectorPanel = PigeonHole_ProjectorPanelPage.firstVoteOption.getText();
		Assert.assertEquals(obtainedVoteOptionInProjectorPanel, firstPollOptionOne,
			"Obtained voteOption did not match");
		GenericMethods.waitForElement(PigeonHole_ProjectorPanelPage.firstVotePercentage);
		Thread.sleep(3000);
		String obtainedVotePercentageInProjectorPanel = PigeonHole_ProjectorPanelPage.firstVotePercentage.getText();
		obtainedVotePercentageInProjectorPanel.contains(obtainedVotePercentageForFirstPOll);
	}

	// Switch to AWA page , click numerical option
	//verify Numerical scale poll question vote average in Admin panel and  Projector panel
	@Test(priority = 17)
	public void verifyNumericalPollQuestionVoteAverage() throws Throwable {

		GenericMethods.switchToNewWindow(audienceWebApp_Page);
		GenericMethods.sychronizationinterval();
		audienceWebAppPage.clickNumericOption();
		GenericMethods.sychronizationinterval();
		GenericMethods.switchToNewWindow(adminPanel_Page);
		GenericMethods.sychronizationinterval();
		adminPanelPage.clickNext();
		GenericMethods.waitForElement(PigeonHole_AdminPanelPage.verifyAverageValue);
		String obtainedVoteAverageInAdminrPanel = PigeonHole_AdminPanelPage.verifyAverageValue.getText();
		Assert.assertEquals(Integer.parseInt(obtainedVoteAverageInAdminrPanel), voteAverage,
				"Obtained vote average did not match");
		GenericMethods.switchToNewWindow(projectorPanel_Page);
		GenericMethods.sychronizationinterval();
		//GenericMethods.waitForElement(PigeonHole_ProjectorPanelPage.verifyAverageValue);
		String obtainedVoteAverageInProjectorPanel = PigeonHole_ProjectorPanelPage.verifyAverageValue.getText();
		Assert.assertEquals(Integer.parseInt(obtainedVoteAverageInProjectorPanel), voteAverage,
				"Obtained vote average did not match");
		
	}
	
	// Switch to AWA page , drag to coordinates
	//verify Draggable  poll question vote average in Admin panel and  Projector panel
	@Test(priority = 18)
	public void verifyDragagablePollQuestionVoteAverage() throws Throwable {

		GenericMethods.switchToNewWindow(audienceWebApp_Page); // switching to audienceWebAppPage window
		GenericMethods.sychronizationinterval();
		audienceWebAppPage.clickVoteButton(draggable_x_cordinate,draggable_y_cordinate);
		GenericMethods.sychronizationinterval();
		GenericMethods.switchToNewWindow(adminPanel_Page);
		GenericMethods.sychronizationinterval();
		adminPanelPage.clickNext();
		GenericMethods.sychronizationinterval();
		GenericMethods.waitForElement(PigeonHole_AdminPanelPage.verifyAverageValue);
		String obtainedVoteDraggableScoreInAdminrPanel = PigeonHole_AdminPanelPage.verifyAverageValue.getText();
		Assert.assertEquals(Integer.parseInt(obtainedVoteDraggableScoreInAdminrPanel), draggableScore,
				"Obtained Draggable average did not match");
		GenericMethods.switchToNewWindow(projectorPanel_Page);
		GenericMethods.sychronizationinterval();
		GenericMethods.waitForElement(PigeonHole_ProjectorPanelPage.verifyAverageValue);
		String obtainedVoteDraggableScoreInProjectorPanel = PigeonHole_ProjectorPanelPage.verifyAverageValue.getText();
		Assert.assertEquals(Integer.parseInt(obtainedVoteDraggableScoreInProjectorPanel), draggableScore,
				"Obtained Draggable average did not match");
	}
	
	// Switch to AWA page click icon rating
	//verify Icon Rating poll question vote average in Admin panel and  Projector panel
	@Test(priority = 19)
	public void verifyIconRattingPollQuestionVoteAverage() throws Throwable {

		GenericMethods.switchToNewWindow(audienceWebApp_Page);
		GenericMethods.sychronizationinterval();
		GenericMethods.waitForElement(PigeonHole_AudienceWebAppPage.nextButton);
		audienceWebAppPage.clickNext();
		GenericMethods.sychronizationinterval();
		audienceWebAppPage.clickIconRating();
		 obtainedIconRatingInAWAPage = PigeonHole_AudienceWebAppPage.verifyIconRating.getText();
		GenericMethods.switchToNewWindow(adminPanel_Page);
		GenericMethods.sychronizationinterval();
		adminPanelPage.clickNext();
		GenericMethods.sychronizationinterval();
		GenericMethods.waitForElement(PigeonHole_AdminPanelPage.verifyAverageScoreValue);
		String obtainedVoteScoreInAdminrPanel = PigeonHole_AdminPanelPage.verifyAverageScoreValue.getText();
		Assert.assertEquals(Integer.parseInt(obtainedVoteScoreInAdminrPanel), iconRating,
				"Obtained Icon Rating did not match");
		GenericMethods.switchToNewWindow(projectorPanel_Page);
		GenericMethods.sychronizationinterval();
		GenericMethods.waitForElement(PigeonHole_ProjectorPanelPage.verifyAverageScoreValue);
		String obtainedVoteScoreInProjectorPanel = PigeonHole_ProjectorPanelPage.verifyAverageScoreValue.getText();
		Assert.assertEquals(Integer.parseInt(obtainedVoteScoreInProjectorPanel), iconRating,
				"Obtained Icon Rating average did not match");
		
	}
	
	// Until you have answered all the questions on AWA.
	// Switch tab to awa, click next, you should see “Thank you for participating”
	// and a Back button.
	@Test(priority = 20)
	public void verifyThankYouForParticipating() throws Throwable {
		GenericMethods.switchToNewWindow(audienceWebApp_Page);
		GenericMethods.sychronizationinterval();
		GenericMethods.waitForElement(PigeonHole_AudienceWebAppPage.nextButton);
		audienceWebAppPage.clickNext();
		GenericMethods.sychronizationinterval();
		String obtainedThankYouText = PigeonHole_AudienceWebAppPage.thankYouText.getText();
		Assert.assertEquals(obtainedThankYouText, "Thank you for participating!",
				"Obtained ThankYou Message did not match");
	}

	// Switch to Admin Panel, click next,
	// you should see the summary of the poll: 1 Total Participants, 4 Questions
	// Polled, 4 Total Votes and a “Back to question 1” button.
	@Test(priority = 21)
	public void checkSummaryOfThePoll() throws Throwable {

		audienceWebAppPage.clickBack();
		GenericMethods.switchToNewWindow(adminPanel_Page);
		GenericMethods.sychronizationinterval();
		adminPanelPage.clickNext();
		GenericMethods.sychronizationinterval();
		String verifyTotalParticipantsCount = PigeonHole_AdminPanelPage.verifyTotalParticipants.getText();
		Assert.assertEquals(Integer.parseInt(verifyTotalParticipantsCount), participantsCount,
				"Obtained Total Participants Count did not match");
		String verifyTotalQuestionsPollCount = PigeonHole_AdminPanelPage.verifyQuestionsPolled.getText();
		Assert.assertEquals(Integer.parseInt(verifyTotalQuestionsPollCount), pollsCount,
			"Obtained Total Questions Poll Count did not match");
		String verifyTotalVotesCount = PigeonHole_AdminPanelPage.verifyTotalVotes.getText();
		Assert.assertEquals(Integer.parseInt(verifyTotalVotesCount), pollsCount,
				"Obtained Total Votes Count did not match");
	}

	// Switch to Projector Panel, without clicking, you should see the summary of
	// the poll: 1 Total Participants, 4 Questions Polled and 4 Total Votes.
	@Test(priority = 22)
	public void verifyFinalCount() throws Throwable {

		GenericMethods.switchToNewWindow(projectorPanel_Page);
		GenericMethods.sychronizationinterval();
		String verifyTotalParticipantsCountInProjectorPanel = PigeonHole_ProjectorPanelPage.verifyTotalParticipants.getText();
		Assert.assertEquals(Integer.parseInt(verifyTotalParticipantsCountInProjectorPanel), participantsCount,
				"Obtained Total Participants Count did not match");
		String verifyTotalQuestionsPollCountInProjectorPanel = PigeonHole_ProjectorPanelPage.verifyQuestionsPolled.getText();
		Assert.assertEquals(Integer.parseInt(verifyTotalQuestionsPollCountInProjectorPanel), pollsCount,
				"Obtained Total Questions Poll Count did not match");
		String verifyTotalVotesCountInProjectorPanel = PigeonHole_ProjectorPanelPage.verifyTotalVotes.getText();
		Assert.assertEquals(Integer.parseInt(verifyTotalVotesCountInProjectorPanel), pollsCount,
				"Obtained Total Votes Count did not match");
	}

	/*Method for quit driver session */
	@AfterClass
	public void quitDriversession() {
		GenericMethods.CloseDriverSession();
	}
}
