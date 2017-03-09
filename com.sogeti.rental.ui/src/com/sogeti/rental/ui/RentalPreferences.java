package com.sogeti.rental.ui;

import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class RentalPreferences extends FieldEditorPreferencePage implements IWorkbenchPreferencePage,RentalUIConstants {

	// CONSTRUCTOR
	public RentalPreferences() {
		super(GRID);
		setPreferenceStore(RentalUIActivator.getDefault().getPreferenceStore());
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(IWorkbench workbench) {
		// INITIALISATION

	}

	@Override
	protected void createFieldEditors() {
		
		// Ajout des widgets des preferences
		
		// Ajout du widget couleur du customer
        addField(new ColorFieldEditor(PREF_CLRCUSTOMER, "Customer :", getFieldEditorParent()));
		// Ajout du widget couleur de la location
        addField(new ColorFieldEditor(PREF_CLRRENTAL, "Rental :", getFieldEditorParent()));
		// Ajout du widget couleur de l'objet loué
        addField(new ColorFieldEditor(PREF_CLROBJECT, "Objets :", getFieldEditorParent()));
        
	}

}
