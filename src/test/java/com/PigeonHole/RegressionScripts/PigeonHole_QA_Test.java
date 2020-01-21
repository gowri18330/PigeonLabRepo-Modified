package com.PigeonHole.RegressionScripts;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.PigeonHole.FunctionalLibrary.GenericMethods;
import com.PigeonHole.Pages.PigeonHole_AdminPanelPage;
import com.PigeonHole.Pages.PigeonHole_AgendaPage;
import com.PigeonHole.Pages.PigeonHole_AudienceWebAppPage;
import com.PigeonHole.Pages.PigeonHole_DashboardPage;
import com.PigeonHole.Pages.PigeonHole_ProjectorPanelPage;
import com.PigeonHole.Pages.PigeonHole_RunEventsPage;
import com.PigeonHole.pageFactoryInitilization.PageElementsInitialization;

import com.github.javafaker.Faker;
import com.PigeonHole.DataHelper.TestDataGenerator;

public class PigeonHole_QA_Test extends GenericMethods {

	public PigeonHole_DashboardPage dashboardPage;
	public PigeonHole_RunEventsPage runEventsPage;
	public PigeonHole_AudienceWebAppPage audienceWebAppPage;
	public PigeonHole_AdminPanelPage adminPanelPage;
	public PigeonHole_ProjectorPanelPage projectorPanelPage;
	public PigeonHole_AgendaPage agendaPage;
	public PageElementsInitialization elementsInitialization;

	String url = "Q&A_URL";
	Faker faker = new Faker();
	String question = faker.name().name();
	String questionTwo = faker.name().name();
	String announcementMessage = faker.name().name();

	String count = "1";

	int runEvent_page = 1;
	int audienceWebApp_Page = 2;
	int adminPanel_Page = 3;
	int projectorPanel_Page = 4;

	@BeforeClass
	public void init() {
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

// click on “2018 Asia Leadership Conference”, In Run your event page, click the
// audience web app link
	@Test(priority = 1)
	public void clickAsiaLeadershipConference() throws Throwable {

		GenericMethods.checkIfButtonExistsAndClick(dashboardPage.gotItButton);

		dashboardPage.clickOnEvent();

		GenericMethods.sychronizationinterval();

		GenericMethods.checkIfButtonExistsAndClick(runEventsPage.gotItButton);

		runEventsPage.clickAudienceWebApp();

		GenericMethods.switchToNewWindow(audienceWebApp_Page);

		GenericMethods.sychronizationinterval();
	}

// look for this Q&A name: “Technology and Corporate Communications” and click
// on “Enter this Q&A”. click Ask
// Click on vote, after clicking you should see the vote has changed from 0 to
// 1.
	@Test(priority = 2)
	public void QuestionAndAnswer() throws Throwable {

		audienceWebAppPage.clickQA();

		GenericMethods.sychronizationinterval();

		audienceWebAppPage.clickQuestionInput();

		audienceWebAppPage.fillUpQuestion(question);

		audienceWebAppPage.clickAsk();

		audienceWebAppPage.clickConfirmAsk();

		GenericMethods.waitForElement(audienceWebAppPage.verifyQuestion);

		String obtainedQuestion = audienceWebAppPage.verifyQuestion.getText();

		Assert.assertEquals(obtainedQuestion, question, "Obtained question did not match");

		GenericMethods.sychronizationinterval();

		audienceWebAppPage.clickVote();

		GenericMethods.sychronizationinterval();

		GenericMethods.waitForElement(audienceWebAppPage.verifyVoteCount);

		String obtainedVoteCount = audienceWebAppPage.verifyVoteCount.getText();

		Assert.assertEquals(obtainedVoteCount, count, "Obtained vote count did not match");
	}

// Return to workspace. Click on the Admin Panel button.
// In new Window, Admin Panel, click on “Technology and Corporate
// Communications” to enter the session.
// You should see the question you have just posted.
// On the top right, check to see if the “Question Filtering” is showing a cross
// icon.

	@Test(priority = 3)
	public void AdminPanel() throws Throwable {

		GenericMethods.switchToNewWindow(runEvent_page);

		GenericMethods.sychronizationinterval();

		runEventsPage.clickAdminPanel();

		GenericMethods.switchToNewWindow(adminPanel_Page);

		GenericMethods.sychronizationinterval();

		adminPanelPage.clickEvent();

		GenericMethods.sychronizationinterval();

		GenericMethods.waitForElement(adminPanelPage.questionName);

		String adminPanelPageQuestion = adminPanelPage.questionName.getText();

		Assert.assertEquals(adminPanelPageQuestion, question, "Obtained question did not match");

		Assert.assertTrue(adminPanelPage.crossIcon.isDisplayed(), "cross icon element not visible.");
	}

// Return to workspace. Click on the Projector Panel.
// A new tab will open, should be on the new page. In the Projector Panel, click
// on “Technology and Corporate Communications” to enter the session.
// You should see the question you have just posted.

	@Test(priority = 4)
	public void ProjectorPanel() throws Throwable {

		GenericMethods.switchToNewWindow(runEvent_page);

		GenericMethods.sychronizationinterval();

		runEventsPage.clickProjectorPanel();

		GenericMethods.switchToNewWindow(projectorPanel_Page);

		GenericMethods.sychronizationinterval();

		projectorPanelPage.clickEvent();

		GenericMethods.sychronizationinterval();

		GenericMethods.waitForElement(projectorPanelPage.questionName);

		String projectorPanelPageQuestion = projectorPanelPage.questionName.getText();

		Assert.assertEquals(projectorPanelPageQuestion, question, "Obtained question did not match");
	}

// check the option “Questions filtering” and click Save Q&A
	@Test(priority = 5)
	public void checkQuestionsFiltering() {

		GenericMethods.switchToNewWindow(runEvent_page);

		runEventsPage.clickAgenda();

		agendaPage.clickEventEdit();

		agendaPage.clickQuestionFiltering();

		agendaPage.clickSaveQA();
	}

// Switch tab to Admin Panel, check to see if the “Question Filtering” is
// showing a tick icon.
// Go to AWA, click the textfield, “Enter your question here…” and fill in any
// question and click Ask.
// You should not see the question you have just posted.

	@Test(priority = 6)
	public void QuestionFiltering() throws Throwable {

		Thread.sleep(9000);

		GenericMethods.switchToNewWindow(adminPanel_Page);

		Thread.sleep(10000);

		Assert.assertTrue(adminPanelPage.tickIcon.isDisplayed(), "tick icon element not visible.");

		GenericMethods.switchToNewWindow(audienceWebApp_Page);

		GenericMethods.sychronizationinterval();

		audienceWebAppPage.clickQuestionInput();

		audienceWebAppPage.fillUpQuestion(questionTwo);

		audienceWebAppPage.clickAsk();

		audienceWebAppPage.clickConfirmAsk();

		GenericMethods.sychronizationinterval();

		String questionTwoINawa = audienceWebAppPage.verifyQuestion.getText();

		Assert.assertFalse(questionTwoINawa.contains(questionTwo), "Text not found!");
	}

// Switch to Projector Panel, you should not see the question you have just
// posted too.
	@Test(priority = 7)
	public void shouldNotSeeTheQuestionInProjectorPanel() throws Throwable {

		GenericMethods.switchToNewWindow(projectorPanel_Page);

		GenericMethods.sychronizationinterval();

		String questionTwoINprojectorPanel = projectorPanelPage.questionName.getText();

		Assert.assertFalse(questionTwoINprojectorPanel.contains(questionTwo), "Text not found!");
	}

// Switch tab to admin panel, click on the link with a green text: 1 question
// pending approval.
// Look for the question you have just posted and click “Allow”.
// Click on the “Allowed” link on the left.
// You should see the questions you’ve just approved.

	@Test(priority = 8)
	public void questionPendingApproval_GreenText() throws Throwable {

		GenericMethods.switchToNewWindow(adminPanel_Page);

		GenericMethods.sychronizationinterval();

		adminPanelPage.clickQuestionPending();

		GenericMethods.sychronizationinterval();

		GenericMethods.waitForElement(adminPanelPage.questionName);

		String adminPanelPendingQuestion = adminPanelPage.questionName.getText();

		Assert.assertEquals(adminPanelPendingQuestion, questionTwo, "Obtained question did not match");

		GenericMethods.waitForElement(adminPanelPage.allowButton);

		adminPanelPage.clickAllow();

		adminPanelPage.clickAllowed();

		GenericMethods.sychronizationinterval();

		GenericMethods.waitForElement(adminPanelPage.secondQuestion);

		String adminPanelSecondQuestion = adminPanelPage.secondQuestion.getText();

		Assert.assertEquals(adminPanelSecondQuestion, questionTwo, "Obtained question did not match");
	}

// Switch tab to AWA, you should see the question you have just approved
	@Test(priority = 9)
	public void shouldSeeTheQuestionInAWA() throws Throwable {

		GenericMethods.switchToNewWindow(audienceWebApp_Page);

		GenericMethods.sychronizationinterval();

		String secondQuestion = audienceWebAppPage.secondQuestion.getText();

		Assert.assertEquals(secondQuestion, questionTwo, "Obtained question did not match");
	}

// Switch tab to Projector Panel, you should see the question you have just
// approved.
	@Test(priority = 10)
	public void inProjectorPanelShouldSeeTheQuestionYouHaveJustApproved() throws Throwable {

		GenericMethods.switchToNewWindow(projectorPanel_Page);

		GenericMethods.sychronizationinterval();

		String secondQuestionInProjectorPanel = projectorPanelPage.secondQuestion.getText();

		Assert.assertEquals(secondQuestionInProjectorPanel, questionTwo, "Obtained question did not match");
	}

// Switch tab to Admin Panel, click “Active” on the question you’ve just
// approved.
	@Test(priority = 11)
	public void clickActive() throws Throwable {

		GenericMethods.switchToNewWindow(adminPanel_Page);

		GenericMethods.sychronizationinterval();

		adminPanelPage.clickActive();
	}

// Switch tab to Projector Panel, you should see the question you have just
// “Active”.
	@Test(priority = 12)
	public void shouldSeeTheQuestionInProjectorPanel() throws Throwable {

		GenericMethods.switchToNewWindow(projectorPanel_Page);

		GenericMethods.sychronizationinterval();

		String activeQuestionInProjectorPanel = projectorPanelPage.activeQuestion.getText();

		Assert.assertEquals(activeQuestionInProjectorPanel, questionTwo, "Obtained question did not match");
	}

// Switch tab to Admin Panel, click “Answered” on the question you’ve just
// activated
	@Test(priority = 13)
	public void clickAnswered() throws Throwable {

		GenericMethods.switchToNewWindow(adminPanel_Page);

		GenericMethods.sychronizationinterval();

		adminPanelPage.clickAnswered();

	}

// Switch tab to AWA, you should see “Answered” on the question you’ve just
// marked as answered.
	@Test(priority = 14)
	public void seeAnswered() throws Throwable {
		GenericMethods.switchToNewWindow(audienceWebApp_Page);

		GenericMethods.sychronizationinterval();

		GenericMethods.waitForElement(audienceWebAppPage.verifyAnsweredText);

		String answeredText = audienceWebAppPage.verifyAnsweredText.getText();

		Assert.assertEquals(answeredText, "Answered", "Obtained announcementMessage did not match");
	}

// Switch tab to Projector Panel, you should not see this question anymore.
	@Test(priority = 15)
	public void shouldNotSeeThisQuestionAnymore() throws Throwable {

		GenericMethods.switchToNewWindow(projectorPanel_Page);

		GenericMethods.sychronizationinterval();

		String questionTwoInProjectorPanel = projectorPanelPage.questionName.getText();

		Assert.assertFalse(questionTwoInProjectorPanel.contains(questionTwo), "Text not found!");
	}

// Switch tab to Admin Panel, click on the loudspeaker icon on the top right.
	@Test(priority = 16)
	public void clickLoudSpeakerIcon() throws Throwable {

		GenericMethods.switchToNewWindow(adminPanel_Page);

		GenericMethods.sychronizationinterval();

		adminPanelPage.clickLoudSpeaker();
	}

// Fill in an announcement message and click “Save for later”
	@Test(priority = 17)
	public void clickSaveForLater() {

		GenericMethods.waitForElement(adminPanelPage.announcementMessageInput);

		adminPanelPage.fillAnnouncementMessage(announcementMessage);

		adminPanelPage.clickSaveLater();
	}

// see the announcement message under the Saved tab.
// Click Send and Confirm.
// You should see the announcement message under the Send tab.

	@Test(priority = 18)
	public void clickSendAndConfirm() throws Throwable {

		GenericMethods.waitForElement(adminPanelPage.verifyAnnouncementMessage);

		String announcementMessageText = adminPanelPage.verifyAnnouncementMessage.getText();

		Assert.assertEquals(announcementMessageText, announcementMessageText,
				"Obtained announcementMessage did not match");

		adminPanelPage.clickSendAnnouncement();

		GenericMethods.waitForElement(adminPanelPage.announcementConfirmButton);

		adminPanelPage.clickAnnouncementConfirm();

		GenericMethods.sychronizationinterval();

		GenericMethods.waitForElement(adminPanelPage.sentAnnouncementMessage);

		String sentAnnouncementMessageText = adminPanelPage.sentAnnouncementMessage.getText();

		Assert.assertEquals(sentAnnouncementMessageText, announcementMessage,
				"Obtained announcementMessage did not match");
	}

// Switch tab to the AWA, you should see the announcement message, Click close.
	@Test(priority = 19)
	public void clickClose() throws Throwable {

		GenericMethods.switchToNewWindow(audienceWebApp_Page);

		GenericMethods.sychronizationinterval();

		GenericMethods.waitForElement(audienceWebAppPage.announcementPopUPText);

		String AnnouncementMessagePopUPText = audienceWebAppPage.announcementPopUPText.getText();

		Assert.assertEquals(AnnouncementMessagePopUPText, announcementMessage,
				"Obtained announcementMessage did not match");

		audienceWebAppPage.clickAnnouncementPopUPClose();
	}

// Switch tab to Admin Panel, you should see “Views: 1” and “Clicks: 1”.
	@Test(priority = 20)
	public void viewsAndClickAssertion() throws Throwable {

		GenericMethods.switchToNewWindow(adminPanel_Page);

		GenericMethods.sychronizationinterval();

		GenericMethods.waitForElement(adminPanelPage.verifyViewCount);

		String obtainedViewCount = adminPanelPage.verifyViewCount.getText();

		Assert.assertEquals(obtainedViewCount, count, "Obtained view count did not match");

		GenericMethods.waitForElement(adminPanelPage.verifyClickCount);

		String obtainedClickCount = adminPanelPage.verifyClickCount.getText();

		Assert.assertEquals(obtainedClickCount, count, "Obtained click count did not match");

		GenericMethods.CloseDriverSession();

	}
}