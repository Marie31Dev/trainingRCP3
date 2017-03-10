package com.sogeti.rental.rcp;

import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

import com.sogeti.rental.ui.AgencyPerspective;

public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {

	// A supprimer pour utiliser l'ID de la perspective AgencyPerspective cr��e pr�c�demment dans rental.ui
	//private static final String PERSPECTIVE_ID = "com.sogeti.rental.rcp.perspective"; //$NON-NLS-1$

	@Override
    public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        return new ApplicationWorkbenchWindowAdvisor(configurer);
    }
    
    @Override
	public String getInitialWindowPerspectiveId() {
    	// Ajout de la perspective qui s'ouvre par d�faut : celle qu'on a cr��e dans rental.ui.
    	// Ajouter la classe de la perspective dans les packages export�s par le plugin rental.ui (plugin.xml, onglet "Runtime", ajouter 
		return AgencyPerspective.PERSPECTIVE_ID;
	}
}
