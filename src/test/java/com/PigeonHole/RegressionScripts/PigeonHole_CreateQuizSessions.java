package com.PigeonHole.RegressionScripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.PigeonHole.DataHelper.TestDataGenerator;
import com.PigeonHole.FunctionalLibrary.GenericMethods;
import com.PigeonHole.Pages.PigeonHole_AdminPanelPage;
import com.PigeonHole.Pages.PigeonHole_AgendaPage;
import com.PigeonHole.Pages.PigeonHole_AudienceWebAppPage;
import com.PigeonHole.Pages.PigeonHole_DashboardPage;
import com.PigeonHole.Pages.PigeonHole_ProjectorPanelPage;
import com.PigeonHole.Pages.PigeonHole_RunEventsPage;
import com.PigeonHole.Utilities.PropertyUtil;
import com.PigeonHole.pageFactoryInitilization.PageElementsInitialization;

public class PigeonHole_CreateQuizSessions {

	public PigeonHole_DashboardPage dashboardPage;
	public PigeonHole_RunEventsPage runEventsPage;
	public PigeonHole_AudienceWebAppPage audienceWebAppPage;
	public PigeonHole_AdminPanelPage adminPanelPage;
	public PigeonHole_ProjectorPanelPage projectorPanelPage;
	public PigeonHole_AgendaPage agendaPage;
	public PageElementsInitialization elementsInitialization;

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
	public String url = "QuizUrl";

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

	// click Add Pigeonhole , Select “Basic Pigeonhole” abd Set an Event
	@Test(priority = 1)
	public void setUpEventModel() throws Throwable {

		dashboardPage.clickBasicPigeonhole();
		GenericMethods.waitForElementClickable(dashboardPage.eventNameInput);
		dashboardPage.setUpEvent(randomEventName);
	}

	// click add session, select “poll: Quiz” and fill in any session name, Add
	// question and options with images
	@Test(priority = 2)
	public void createSessionWithPollQuestions() throws Throwable {
		GenericMethods.waitForElementClickable(dashboardPage.addSessionButton);
		dashboardPage.addNewSession(sessionName);
		GenericMethods.sychronizationinterval();
		dashboardPage.addPollQuestion(question, answerOne, answerTwo);
		GenericMethods.sychronizationinterval();
		dashboardPage.addAnswerOptionsWithImages(questionSecond, answerOne, answerTwo, answerThree, time);
		GenericMethods.sychronizationinterval();
		GenericMethods.sychronizationinterval(); // additional time required specifically.
		actualSessionName = dashboardPage.sessionNameField.getText();
		assertEquals(actualSessionName, sessionName);
	}

	// Click Edit Next Arrow, and start the session, click on the “Run links” button
	// select AWA.
	@Test(priority = 3)
	public void startSession() throws Throwable {
		GenericMethods.sychronizationinterval();
		dashboardPage.startSession();
		GenericMethods.sychronizationinterval();
		dashboardPage.clickOnRunsLink();
		GenericMethods.sychronizationinterval();
		dashboardPage.clickOnAwa();
		GenericMethods.sychronizationinterval();
		GenericMethods.switchToNewWindow(2);
		GenericMethods.sychronizationinterval();
		assertTrue(audienceWebAppPage.validateSession(sessionName), "Created Session is displaying in Awa page");
	}

	// Return to workspace. Click on the “Run links” button select Admin Panel.
	// A new tab will open check if the session name shows up and if the icon is in
	// orange.
	@Test(priority = 4)
	public void selectAdminPanel() throws Throwable {
		GenericMethods.switchToNewWindow(1);
		GenericMethods.sychronizationinterval();
		dashboardPage.clickOnRunsLink();
		GenericMethods.sychronizationinterval();
		dashboardPage.clickOnAdminPannel();
		GenericMethods.sychronizationinterval();
		GenericMethods.switchToNewWindow(3);
		GenericMethods.sychronizationinterval();
		assertTrue(adminPanelPage.validateSession(sessionName), "Created Session is displaying in Awa page");
		GenericMethods.sychronizationinterval();
		Assert.assertEquals(expectedPollQuizColor, GenericMethods.getColourOfElement(adminPanelPage.pollQuizIcon));
		GenericMethods.sychronizationinterval();
	}

	// Return to workspace. Click on the “Run links” button select Projector Panel.
	// A new window will be open, check if the session name shows up and if the icon
	// is in orange.
	@Test(priority = 5)
	public void selectProjectorPanel() throws Throwable {
		GenericMethods.switchToNewWindow(1);
		GenericMethods.sychronizationinterval();
		dashboardPage.clickOnRunsLink();
		GenericMethods.sychronizationinterval();
		dashboardPage.clickOnProjectorPannel();
		GenericMethods.sychronizationinterval();
		GenericMethods.switchToNewWindow(4);
		GenericMethods.sychronizationinterval();
		assertTrue(projectorPanelPage.validateSession(sessionName), "Created Session is displaying in Awa page");
		GenericMethods.sychronizationinterval();
		Assert.assertEquals(expectedPollQuizColor, GenericMethods.getColourOfElement(projectorPanelPage.pollQuizIcon));
	}

	// Switch tab to awa, click “cast your vote”, Switch tab to Admin panel, You
	// should see 1 participant.
	@Test(priority = 6)
	public void clickCastYourVote() throws Throwable {
		GenericMethods.sychronizationinterval();
		GenericMethods.switchToNewWindow(2);
		GenericMethods.sychronizationinterval();
		audienceWebAppPage.clickCasteYourVote();
		GenericMethods.sychronizationinterval();
		GenericMethods.switchToNewWindow(3);
		GenericMethods.sychronizationinterval();
		adminPanelPage.clickOnSession();
		Thread.sleep(4000); // wait required
		actualParticipentCount = adminPanelPage.getParticipentCount();
		assertEquals(actualParticipentCount, expectedParticipentCount);
		GenericMethods.sychronizationinterval();
	}

	// Switch tab to Projector panel, You should see 1 participant
	@Test(priority = 7)
	public void seeOneParticipant() throws Throwable {
		GenericMethods.switchToNewWindow(4);
		GenericMethods.sychronizationinterval();
		projectorPanelPage.clickOnSession();
		Thread.sleep(4000); // wait required
		actualParticipentCount_ProjectorPannel = projectorPanelPage.getParticipentCount();
		assertEquals(actualParticipentCount_ProjectorPannel, expectedParticipentCount_ProjecterPannel);
	}

	// Switch to admin panel, click start quiz, Should see a countdown
	@Test(priority = 8)
	public void shouldSeeCountdown() throws Throwable {
		GenericMethods.sychronizationinterval();
		GenericMethods.switchToNewWindow(3);
		GenericMethods.sychronizationinterval();
		adminPanelPage.clickOnStartQuiz();
		GenericMethods.sychronizationinterval();
		assertTrue(adminPanelPage.startQuizeTimer.isDisplayed());
		GenericMethods.sychronizationinterval();
	}

	// Switch to awa, wait for the countdown to finish then click on answer option
	// 1.
	// click on the uploaded image to enlarge it. Click cross to close the image.
	@Test(priority = 9)
	public void imageToEnlarge() throws Throwable {
		GenericMethods.switchToNewWindow(2);
		Thread.sleep(5000); // required
		audienceWebAppPage.clickOnEnlargeIcon();
		GenericMethods.sychronizationinterval();
		audienceWebAppPage.clickOnFirstQuestionAswer();

	}

	// Switch to admin panel, check if the voted option is the same as your
	// selection. Wait for the answer to be revealed.
	// wait till you see the leaderboard screen for question 1 of 2 then click
	// pause, you should see the resume button.
	// In the admin panel, check the score, is it 1/1

	@Test(priority = 10)
	public void leaderboardScreen() throws Throwable {
		GenericMethods.switchToNewWindow(3);
		Thread.sleep(22000); // re
		adminPanelPage.clickOnPause();
		GenericMethods.sychronizationinterval();
		assertTrue(adminPanelPage.resumeButton.isDisplayed());
		GenericMethods.sychronizationinterval();
		actualLeaderboardQuestion = adminPanelPage.getLeaderboardScreenQuestionCount();
		assertEquals(actualLeaderboardQuestion, expectedLeaderboardQuestion);
		GenericMethods.sychronizationinterval();
		actualAdminPannelScore = adminPanelPage.getAdminPannelScore();
		assertEquals(actualAdminPannelScore, expectedAdminPannelScore);
	}

	// Switch to projector panel, you should also see the leaderboard screen.
	// In the projector panel, check the score, is it 1/1.
	@Test(priority = 11)
	public void checkTheScore() throws Throwable {
		GenericMethods.switchToNewWindow(4);
		GenericMethods.sychronizationinterval();
		actualProjectorPannelScore = projectorPanelPage.getProjectorPannelScore();
		assertEquals(actualProjectorPannelScore, expectedProjectorPannelScore);
		GenericMethods.sychronizationinterval();
	}

	// Switch to AWA, you should see “Quiz paused!”.
	@Test(priority = 12)
	public void quizPaused() throws Throwable {
		GenericMethods.switchToNewWindow(2);
		GenericMethods.sychronizationinterval();
		assertTrue(audienceWebAppPage.quizPauseTextField.isDisplayed());
	}

	// Switch to Admin Panel, click the Resume button.
	@Test(priority = 13)
	public void clickResumeButton() throws Throwable {
		GenericMethods.switchToNewWindow(3);
		GenericMethods.sychronizationinterval();
		adminPanelPage.clickOnResume();
		GenericMethods.sychronizationinterval();
	}

	// Switch to AWA, wait for the answer to reveal. In the next screen, you should
	// see: “Well done! You got the correct answer.”
	// select the last option apple.
	// wait for the answer to reveal. The next screen, you should see: “Sorry! You
	// got the wrong answer!”.
	// check to see if you have a score ½.
	@Test(priority = 14)
	public void shouldSeeWellDoneAndSorryText() throws Throwable {
		GenericMethods.switchToNewWindow(2);
		Thread.sleep(13000);
		audienceWebAppPage.clickOnApple();
		Thread.sleep(50000);
		assertTrue(audienceWebAppPage.finalScoreField.isDisplayed());
		GenericMethods.sychronizationinterval();
	}

	// Switch to admin panel, you should see score ½
	@Test(priority = 15)
	public void seeScoreInAdminPanel() throws Throwable {
		GenericMethods.switchToNewWindow(3);
		Thread.sleep(7000);
		actualFinalScore = adminPanelPage.getAdminPannelResult();
		assertEquals(actualFinalScore, expectedFinalScore);
		GenericMethods.sychronizationinterval();
	}

	// Switch to projector panel, you should see score ½.
	@Test(priority = 16)
	public void seeScoreInProjectorPanel() throws Throwable {
		GenericMethods.switchToNewWindow(4);
		Thread.sleep(7000);
		actualFinalScore = projectorPanelPage.getprojectorPannelResult();
		assertEquals(actualFinalScore, expectedFinalScore);
	}

	@AfterClass
	public void quitDriversession() {
		GenericMethods.CloseDriverSession();
	}

}
