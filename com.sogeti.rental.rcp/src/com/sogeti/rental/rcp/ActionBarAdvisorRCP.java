package com.sogeti.rental.rcp;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.jface.action.Action;

public class ActionBarAdvisorRCP extends ActionBarAdvisor {
	private IAction quitAction;
	private IAction newEditorAction;
	private Action action;
	private IAction preferencesAction;
	private IAction resetPerspectiveAction;
	private IAction preferencesAction_1;

	public ActionBarAdvisorRCP(IActionBarConfigurer configurer) {
		super(configurer);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void fillMenuBar(IMenuManager menuBar) {
		// TODO Auto-generated method stub
		super.fillMenuBar(menuBar);

		MenuManager menuManager = new MenuManager("New MenuManager");
		menuManager.setMenuText("File");
		menuBar.add(menuManager);
		menuManager.add(quitAction);
		
		MenuManager menuManager_1 = new MenuManager("New MenuManager");
		menuManager_1.setMenuText("Window");
		menuBar.add(menuManager_1);
		menuManager_1.add(preferencesAction_1);
	}

	@Override
	protected void fillCoolBar(ICoolBarManager coolBar) {
		// TODO Auto-generated method stub
		super.fillCoolBar(coolBar);
	}

	@Override
	protected void makeActions(IWorkbenchWindow window) {
		// TODO Auto-generated method stub
		super.makeActions(window);
		{
			quitAction = ActionFactory.QUIT.create(window);
			register(quitAction);
		}

		{
			newEditorAction = ActionFactory.NEW_EDITOR.create(window);
			register(newEditorAction);
		}
		
		{
			preferencesAction = ActionFactory.PREFERENCES.create(window);
			register(preferencesAction);
		}
		{
			resetPerspectiveAction = ActionFactory.RESET_PERSPECTIVE.create(window);
			register(resetPerspectiveAction);
		}
		{
			preferencesAction_1 = ActionFactory.PREFERENCES.create(window);
			register(preferencesAction_1);
		}
	}
}
