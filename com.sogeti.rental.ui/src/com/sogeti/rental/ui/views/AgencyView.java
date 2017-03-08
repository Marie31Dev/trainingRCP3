package com.sogeti.rental.ui.views;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import com.opcoach.training.rental.RentalAgency;
import com.sogeti.rental.core.RentalCoreActivator;

public class AgencyView extends ViewPart {

	public AgencyView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		// Creation de l'arbre et de son provider
		TreeViewer tv = new TreeViewer(parent);
		RentalProvider provider = new RentalProvider();
		
				
		tv.setContentProvider(provider);
		tv.setLabelProvider(provider);
		
		//R�cup�ration des agences qu'on donne � l'arbre
		Collection<RentalAgency> agencies = new ArrayList<>();
		agencies.add(RentalCoreActivator.getAgency());
		tv.setInput(agencies);
		
		tv.expandAll();
		
		// Branchement de l'�metteur de s�lection
		getSite().setSelectionProvider(tv);
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
