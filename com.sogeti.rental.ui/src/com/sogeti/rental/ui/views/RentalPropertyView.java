package com.sogeti.rental.ui.views;


import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;

import com.opcoach.training.rental.Rental;
import com.sogeti.rental.core.RentalCoreActivator;
import org.eclipse.swt.layout.FillLayout;

public class RentalPropertyView extends ViewPart {

	private Label rentedStartDateLabel;
	private Label rentedEndDateLabel;
	private Label rentedObjectLabel;
	private Label rentedCustomerLabel;
	private Group grpDatesDeLocation;


	public RentalPropertyView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {

		parent.setLayout(new GridLayout(1, false));
		
		// Creation du groupe "Informations"
		Group infoGroup = new Group(parent, SWT.NONE);
		GridData gd_infoGroup = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_infoGroup.widthHint = 153;
		infoGroup.setLayoutData(gd_infoGroup);
		infoGroup.setText("Informations");
		infoGroup.setLayout(new GridLayout(2, false));
		
		// Ajout du label de l'objet loué
		rentedObjectLabel = new Label(infoGroup, SWT.NONE);
		GridData gd = new GridData();
		gd.widthHint = 142;
		gd.horizontalSpan = 2;
		gd.horizontalAlignment = SWT.FILL;
		rentedObjectLabel.setLayoutData(gd);
		
		// Ajout du label du client
		rentedCustomerLabel = new Label(infoGroup, SWT.NONE);
		GridData gd2 = new GridData();
		gd2.horizontalSpan = 2;
		gd2.horizontalAlignment = SWT.FILL;
		rentedCustomerLabel.setLayoutData(gd2);
		
		// Groupe des dates de location
		grpDatesDeLocation = new Group(parent, SWT.NONE);
		grpDatesDeLocation.setLayout(null);
		GridData gd_grpDatesDeLocation = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_grpDatesDeLocation.widthHint = 164;
		gd_grpDatesDeLocation.heightHint = 63;
		grpDatesDeLocation.setLayoutData(gd_grpDatesDeLocation);
		grpDatesDeLocation.setText("Dates de location");
		
		// Label de la date de début de la location
		rentedStartDateLabel = new Label(grpDatesDeLocation, SWT.NONE);
		rentedStartDateLabel.setBounds(10, 15, 145, 15);
		rentedStartDateLabel.setText("StartDate");
		
		// Label de la date de fin de la location
		rentedEndDateLabel = new Label(grpDatesDeLocation, SWT.NONE);
		rentedEndDateLabel.setBounds(10, 38, 82, 21);
		rentedEndDateLabel.setText("EndDate");
		
		// Met à jour les attributs avec les infos de la première location
		setRental(RentalCoreActivator.getAgency().getRentals().get(0));
		
	}

	public void setRental(Rental r) {
		rentedObjectLabel.setText(r.getRentedObject().getName());
		rentedCustomerLabel.setText("Loué à :   "+r.getCustomer().getDisplayName());
		rentedStartDateLabel.setText("du: "+r.getStartDate().toString());
		rentedEndDateLabel.setText("au: "+r.getEndDate().toString());
	}
	
	
	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}
}
