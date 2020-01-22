package com.PigeonHole.pageFactoryInitilization;

import org.openqa.selenium.support.PageFactory;

import com.PigeonHole.FunctionalLibrary.GenericMethods;
import com.PigeonHole.Pages.PigeonHole_AdminPanelPage;
import com.PigeonHole.Pages.PigeonHole_AgendaPage;
import com.PigeonHole.Pages.PigeonHole_AudienceWebAppPage;
import com.PigeonHole.Pages.PigeonHole_DashboardPage;
import com.PigeonHole.Pages.PigeonHole_ProjectorPanelPage;
import com.PigeonHole.Pages.PigeonHole_RunEventsPage;

public class PageElementsInitialization extends GenericMethods {
	
	// Dashboard page elements initialization
	public void dashBoardPageObjectory() {

		PageFactory.initElements(driver, PigeonHole_DashboardPage.class);
	}
	
	// AdminPannel page elements initialization
	public void adminPannelPageObjectory() {

		PageFactory.initElements(driver, PigeonHole_AdminPanelPage.class);
	}
	
	// AWA page elements initialization
	public void AWAPageObjectory() {

		PageFactory.initElements(driver, PigeonHole_AudienceWebAppPage.class);
	}
	
	// Projectorpannel page elements initialization
	public void projecterPageObjectory() {

		PageFactory.initElements(driver, PigeonHole_ProjectorPanelPage.class);
	}
	
	// Run events page elements initialization
	public void runEventsPageObjectory() {

		PageFactory.initElements(driver, PigeonHole_RunEventsPage.class);
	}
	
	// Agenda page elements initialization
	public void agendaPageObjectory() {

		PageFactory.initElements(driver, PigeonHole_AgendaPage.class);
	}
}
