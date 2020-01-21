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
	public void dashBoardPageObjectory() {

		PageFactory.initElements(driver, PigeonHole_DashboardPage.class);
	}
	
	public void adminPannelPageObjectory() {

		PageFactory.initElements(driver, PigeonHole_AdminPanelPage.class);
	}
	
	public void AWAPageObjectory() {

		PageFactory.initElements(driver, PigeonHole_AudienceWebAppPage.class);
	}
	
	public void projecterPageObjectory() {

		PageFactory.initElements(driver, PigeonHole_ProjectorPanelPage.class);
	}

	public void runEventsPageObjectory() {

		PageFactory.initElements(driver, PigeonHole_RunEventsPage.class);
	}
	
	public void agendaPageObjectory() {

		PageFactory.initElements(driver, PigeonHole_AgendaPage.class);
	}
}
