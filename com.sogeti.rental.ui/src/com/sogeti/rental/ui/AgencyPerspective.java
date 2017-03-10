package com.sogeti.rental.ui;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class AgencyPerspective implements IPerspectiveFactory {
	
	// Ajout d'une constante contenant l'ID de la perspective
	public static final String PERSPECTIVE_ID = "com.sogeti.rental.ui.perspectiveAgency"; //$NON-NLS-1$

	/**
	 * Creates the initial layout for a page.
	 */
	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(false);
		String editorArea = layout.getEditorArea();
		addFastViews(layout);
		addViewShortcuts(layout);
		addPerspectiveShortcuts(layout);
		layout.addView("com.sogeti.rental.ui.viewRental", IPageLayout.BOTTOM, 0.5f, IPageLayout.ID_EDITOR_AREA);
		layout.addView("com.sogeti.rental.ui.viewAgency", IPageLayout.LEFT, 0.5f, IPageLayout.ID_EDITOR_AREA);
	}

	/**
	 * Add fast views to the perspective.
	 */
	private void addFastViews(IPageLayout layout) {
		layout.addFastView("com.sogeti.rental.ui.viewRental");
	}

	/**
	 * Add view shortcuts to the perspective.
	 */
	private void addViewShortcuts(IPageLayout layout) {
	}

	/**
	 * Add perspective shortcuts to the perspective.
	 */
	private void addPerspectiveShortcuts(IPageLayout layout) {
	}

}
