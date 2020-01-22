package com.PigeonHole.RegressionScripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.PigeonHole.DataHelper.TestDataGenerator;
import com.PigeonHole.FunctionalLibrary.GenericMethods;
import com.PigeonHole.Pages.PigeonHole_AdminPanelPage;
import com.PigeonHole.Pages.PigeonHole_AgendaPage;
import com.PigeonHole.Pages.PigeonHole_AudienceWebAppPage;
import com.PigeonHole.Pages.PigeonHole_DashboardPage;
import com.PigeonHole.Pages.PigeonHole_ProjectorPanelPage;
import com.PigeonHole.Pages.PigeonHole_RunEventsPage;
import com.PigeonHole.pageFactoryInitilization.PageElementsInitialization;

public class PigeonHole_CreateQuizSessions_Test {

	//Objects Declaration Section
	public PigeonHole_DashboardPage dashboardPage;
	public PigeonHole_RunEventsPage runEventsPage;
	public PigeonHole_AudienceWebAppPage audienceWebAppPage;
	public PigeonHole_AdminPanelPage adminPanelPage;
	public PigeonHole_ProjectorPanelPage projectorPanelPage;
	public PigeonHole_AgendaPage agendaPage;
	public PageElementsInitialization elementsInitialization;

	//Test Input Data Section
	public String question = "Among all these fruits, which is the fruit that your doctor would recommend you to eat once every day for the rest of your life?”";
	public String answerOne = "orange";
	public String answerTwo = "Guava";
	public String answerThree = "apple";
	public String questionSecond = "which has the most vitamin c?";
	public String time = "15s";
	public String randomEventName = TestDataGenerator.randomEventName;
	public String sessionName = TestDataGenerator.randomSessionName;
	public String actualSessionName;
	public String expectedPollQuizColor = "#f07424";
	public int actualParticipentCount;
	public int expectedParticipentCount = 1;
	public int actualParticipentCount_ProjectorPannel;
	public int expectedParticipentCount_ProjecterPannel = 1;
	public String actualLeaderboardQuestion;
	public String expectedLeaderboardQuestion = "Question 1 of 2";
	public String actualAdminPannelScore;
	public String expectedAdminPannelScore = "1/1";
	public String actualProjectorPannelScore;
	public String expectedProjectorPannelScore = "1/1";
	public String actualFinalScore;
	public String expectedFinalScore = "1/2";
	public String DashbordWindow = "dashboard";
	public String AudiencePageWindow = "audiencepage";
	public String AdminPannelWindow ="adminPannel";
	public String ProjectorPannelWindow ="projectorPannel";
	public String url = "QuizUrl";

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
		elementsInitialization.agendaPageObjectory();
	}

	// click Add Pigeonhole , Select “Basic Pigeonhole” and Set an Event
	@Test(priority = 1)
	public void setUpEventModel() throws Throwable {
		dashboardPage.clickBasicPigeonhole();
		GenericMethods.waitForElementClickable(PigeonHole_DashboardPage.eventNameInput);
		dashboardPage.setUpEvent(randomEventName);
	}

	// click add session, select “poll: Quiz” and fill in any session name, Add
	// question and options with images
	@Test(priority = 2)
	public void createSessionWithPollQuestions() throws Throwable {
		GenericMethods.waitForElementClickable(PigeonHole_DashboardPage.addSessionButton);
		dashboardPage.addNewSession(sessionName);
		GenericMethods.sychronizationinterval();
		dashboardPage.addPollQuestion(question, answerOne, answerTwo);
		GenericMethods.sychronizationinterval();
		dashboardPage.addAnswerOptionsWithImages(questionSecond, answerOne, answerTwo, answerThree, time);
		GenericMethods.sychronizationinterval();
		GenericMethods.sychronizationinterval(); // additional time required specifically.
		actualSessionName = PigeonHole_DashboardPage.sessionNameField.getText();
		assertEquals(actualSessionName, sessionName);
	}

	// Click Edit Next Arrow, and start the session, click on the “Run links” button
	// select AWA.
	@Test(priority =3)
	public void ValidateSessionInAWSPage() throws Throwable
	{
		GenericMethods.sychronizationinterval();
		dashboardPage.startSession();
		GenericMethods.sychronizationinterval();
		dashboardPage.clickOnRunsLink();
		GenericMethods.sychronizationinterval();
		dashboardPage.clickOnAwa();
		GenericMethods.sychronizationinterval();
		GenericMethods.switchToWindow(AudiencePageWindow);
		GenericMethods.sychronizationinterval();
		assertTrue(audienceWebAppPage.validateSession(sessionName));
	}

	// Return to workspace. Click on the “Run links” button select Admin Panel.
	// A new tab will open check if the session name shows up and if the icon is in orange.
	@Test(priority =4)
	public void ValidateSessionInAdminPannel() throws Throwable
	{
		GenericMethods.switchToWindow(DashbordWindow);
		GenericMethods.sychronizationinterval();
		dashboardPage.clickOnRunsLink();
		GenericMethods.sychronizationinterval();
		dashboardPage.clickOnAdminPannel();
		GenericMethods.sychronizationinterval();
		GenericMethods.switchToWindow(AdminPannelWindow);
		GenericMethods.sychronizationinterval();
		assertTrue(adminPanelPage.validateSession(sessionName));
		GenericMethods.sychronizationinterval();
		Assert.assertEquals(expectedPollQuizColor, GenericMethods.getColourOfElement(PigeonHole_AdminPanelPage.pollQuizIcon));	
	}

	// Return to workspace. Click on the “Run links” button select Projector Panel.
	// A new window will be open, check if the session name shows up and if the icon
	// is in orange.
	@Test(priority =5)
	public void ValidateSessionInProjectorPannel() throws Throwable
	{
		GenericMethods.sychronizationinterval();
		GenericMethods.switchToWindow(DashbordWindow);
		GenericMethods.sychronizationinterval();
		dashboardPage.clickOnRunsLink();
		GenericMethods.sychronizationinterval();
		dashboardPage.clickOnProjectorPannel();
		GenericMethods.sychronizationinterval();
		GenericMethods.switchToWindow(ProjectorPannelWindow);
		System.out.println(sessionName);
		GenericMethods.sychronizationinterval();
		assertTrue(projectorPanelPage.validateSession(sessionName));
		GenericMethods.sychronizationinterval();
		Assert.assertEquals(expectedPollQuizColor, GenericMethods.getColourOfElement(PigeonHole_ProjectorPanelPage.pollQuizIcon));
	}

	// Switch tab to awa, click “cast your vote”, Switch tab to Admin panel, You
	// should see 1 participant.
	@Test(priority =6)
	public void ValidateParticipantsInAdminpanel() throws Throwable
	{
		GenericMethods.sychronizationinterval();
		GenericMethods.switchToWindow(AudiencePageWindow);
		GenericMethods.sychronizationinterval();
		audienceWebAppPage.clickCasteYourVote();
		GenericMethods.sychronizationinterval();
		GenericMethods.switchToWindow(AdminPannelWindow);
		GenericMethods.sychronizationinterval();
		adminPanelPage.clickOnSession();
		Thread.sleep(4000); // wait required to appear participant count in application
		actualParticipentCount = adminPanelPage.getParticipentCount();
		assertEquals(actualParticipentCount, expectedParticipentCount);	
	}
	// Switch tab to Projector panel, You should see 1 participant
	@Test(priority =7)
	public void ValidateParticipantsInProjectorpanel() throws Throwable
	{
		GenericMethods.sychronizationinterval();
		GenericMethods.switchToWindow(ProjectorPannelWindow);
		GenericMethods.sychronizationinterval();
		projectorPanelPage.clickOnSession();
		Thread.sleep(4000); // wait required to appear participant count in application
		actualParticipentCount_ProjectorPannel = projectorPanelPage.getParticipentCount();
		assertEquals(actualParticipentCount_ProjectorPannel, expectedParticipentCount_ProjecterPannel);
	}

	// Switch to admin panel, click start quiz, Should see a countdown
	@Test(priority =8)
	public void StartQuizAndSeeCountdownInAdminpanel() throws Throwable
	{
		GenericMethods.sychronizationinterval();
		GenericMethods.switchToWindow(AdminPannelWindow);
		GenericMethods.sychronizationinterval();
		adminPanelPage.clickOnStartQuiz();
		GenericMethods.sychronizationinterval();
		assertTrue(PigeonHole_AdminPanelPage.startQuizeTimer.isDisplayed());	
	}

	// Switch to awa, wait for the countdown to finish then click on answer option 1.
	// click on the uploaded image to enlarge it. Click cross to close the image.
	@Test(priority =9)
	public void AnswerTheFirstQuestion() throws Throwable
	{
		GenericMethods.sychronizationinterval();
		GenericMethods.switchToWindow(AudiencePageWindow);
		Thread.sleep(5000); // need to wait to finish count down
		audienceWebAppPage.clickOnEnlargeIcon();
		GenericMethods.sychronizationinterval();
		audienceWebAppPage.clickOnFirstQuestionAswer();
	}

	// Switch to admin panel, check if the voted option is the same as your
	// selection. Wait for the answer to be revealed.
	// wait till you see the leaderboard screen for question 1 of 2 then click
	// pause, you should see the resume button.
	// In the admin panel, check the score, is it 1/1
	@Test(priority =10)
	public void ValidateAdminpanelScore() throws Throwable
	{
		GenericMethods.switchToWindow(AdminPannelWindow);
		Thread.sleep(22000); // need to wait to reveal the answer
		adminPanelPage.clickOnPause();
		GenericMethods.sychronizationinterval();
		assertTrue(PigeonHole_AdminPanelPage.resumeButton.isDisplayed());
		GenericMethods.sychronizationinterval();
		actualLeaderboardQuestion = adminPanelPage.getLeaderboardScreenQuestionCount();
		System.out.println(actualLeaderboardQuestion);
		assertEquals(actualLeaderboardQuestion, expectedLeaderboardQuestion);
		GenericMethods.sychronizationinterval();
		actualAdminPannelScore = adminPanelPage.getAdminPannelScore();
		assertEquals(actualAdminPannelScore, expectedAdminPannelScore);
	}

	// Switch to projector panel, you should also see the leaderboard screen.
	// In the projector panel, check the score, is it 1/1.
	// Switch to AWA, you should see “Quiz paused!”.
	@Test(priority =11)
	public void ValidateProjectorpanelScore() throws Throwable
	{
		GenericMethods.switchToWindow(ProjectorPannelWindow);
		GenericMethods.sychronizationinterval();
		actualProjectorPannelScore = projectorPanelPage.getProjectorPannelScore();
		assertEquals(actualProjectorPannelScore, expectedProjectorPannelScore);
		GenericMethods.sychronizationinterval();
		GenericMethods.switchToWindow(AudiencePageWindow);
		GenericMethods.sychronizationinterval();
		assertTrue(PigeonHole_AudienceWebAppPage.quizPauseTextField.isDisplayed());
	}
	
	// Switch to Admin Panel, click the Resume button.
	// Switch to AWA, select the last option apple.
	// wait for the answer to reveal. The next screen, check to see if you have a score ½.
	@Test(priority =12)
	public void AnswerSecondQuestionAndValidateFinalScoreInAWAPage() throws Throwable
	{
		GenericMethods.sychronizationinterval();
		GenericMethods.switchToWindow(AdminPannelWindow);
		GenericMethods.sychronizationinterval();
		adminPanelPage.clickOnResume();
		GenericMethods.sychronizationinterval();
		GenericMethods.switchToWindow(AudiencePageWindow);
		Thread.sleep(13000); // need to wait to reveal the answer
		audienceWebAppPage.clickOnApple();
		Thread.sleep(50000); // wait required to appear score in page
		assertTrue(PigeonHole_AudienceWebAppPage.finalScoreField.isDisplayed());	
	}

	// Switch to admin panel, you should see score ½
	@Test(priority =13)
	public void ValidateFinalScoreInAdminpanel() throws Throwable
	{
		GenericMethods.sychronizationinterval();
		GenericMethods.switchToWindow(AdminPannelWindow);
		Thread.sleep(7000);  // wait required to appear score in page
		actualFinalScore = adminPanelPage.getAdminPannelResult();
		assertEquals(actualFinalScore, expectedFinalScore);
	}

	// Switch to projector panel, you should see score ½.
	@Test(priority =14)
	public void ValidateFinalScoreInProjectorpanel() throws Throwable
	{
		GenericMethods.sychronizationinterval();
		GenericMethods.switchToWindow(ProjectorPannelWindow);
		Thread.sleep(7000); // wait required to appear score in page
		actualFinalScore = projectorPanelPage.getprojectorPannelResult();
		assertEquals(actualFinalScore, expectedFinalScore);
	}

	/*Method for quit driver session */
	@AfterClass
	public void quitDriversession() {
		GenericMethods.CloseDriverSession();
	}

}
