package com.sogeti.rental.ui.views;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;

import com.opcoach.training.rental.RentalAgency;
import com.sogeti.rental.core.RentalCoreActivator;
import com.sogeti.rental.ui.RentalUIActivator;

public class AgencyView extends ViewPart implements IPropertyChangeListener {
	private TreeViewer tv; 

	public AgencyView() {
		// TODO Auto-generated constructor stub
	}

	// On s'abonne aux événements du store des Preferences
	@Override
	public void init(IViewSite site) throws PartInitException {
		// TODO Auto-generated method stub
		super.init(site);
		RentalUIActivator.getDefault().getPreferenceStore().addPropertyChangeListener(this);
	}
	
	// On se désabonne aux événements du store des Preferences
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		RentalUIActivator.getDefault().getPreferenceStore().removePropertyChangeListener(this);
		super.dispose();
	}

	@Override
	public void createPartControl(Composite parent) {
		// Creation de l'arbre et de son provider
		// Exo 40
		// TreeViewer tv = new TreeViewer(parent);
		// Exo 80
		tv = new TreeViewer(parent);
		RentalProvider provider = new RentalProvider();

		tv.setContentProvider(provider);
		tv.setLabelProvider(provider);

		// Récupération des agences qu'on donne à l'arbre
		Collection<RentalAgency> agencies = new ArrayList<>();
		agencies.add(RentalCoreActivator.getAgency());
		tv.setInput(agencies);

		tv.expandAll();

		// Branchement de l'émetteur de sélection
		getSite().setSelectionProvider(tv);
		
		// Mise en place d'un menu dans la vue
		MenuManager menuManager = new MenuManager();
		Menu menu = menuManager.createContextMenu(tv.getControl());
		tv.getControl().setMenu(menu);
		getSite().registerContextMenu(menuManager, tv);
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
	}

	// Actions lors que l'événement de rafraichissement des preferences arrive
	@Override
	public void propertyChange(PropertyChangeEvent event) {
		tv.refresh();
	}
}
