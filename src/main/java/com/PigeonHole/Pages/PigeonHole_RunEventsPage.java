package com.PigeonHole.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PigeonHole_RunEventsPage {

	@FindBy(how = How.CSS, using = ".quick-run-button")
	public static WebElement runLinksButton;

	@FindBy(how = How.CSS, using = "[data-panel-type='Audience Web App']")
	public static WebElement AWA_Link;

	@FindBy(how = How.XPATH, using = "(//a[contains(text(),'Admin Panel')])[2]")
	public static WebElement adminPanelButton;

	@FindBy(how = How.XPATH, using = "(//a[contains(text(),\"Projector Panel\")])[2]")
	public static WebElement projectorPanelButton;

	@FindBy(how = How.CSS, using = "a[href$=\"agenda\"]:nth-child(1)")
	public static WebElement agendaButton;

	@FindBy(how = How.CSS, using = ".confirmation-btn")
	public static WebElement gotItButton;

	public void clickAudienceWebApp() {
		AWA_Link.click();
	}

	public void clickAdminPanel() {
		adminPanelButton.click();
	}

	public void clickProjectorPanel() {
		projectorPanelButton.click();
	}

	public void clickAgenda() {
		agendaButton.click();
	}
}
