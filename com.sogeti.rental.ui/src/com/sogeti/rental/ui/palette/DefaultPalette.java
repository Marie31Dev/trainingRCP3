package com.sogeti.rental.ui.palette;

import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

import com.opcoach.training.rental.Customer;
import com.opcoach.training.rental.Rental;
import com.opcoach.training.rental.RentalAgency;
import com.opcoach.training.rental.RentalObject;
import com.sogeti.rental.ui.RentalUIActivator;
import com.sogeti.rental.ui.RentalUIConstants;

public class DefaultPalette implements IColorProvider, RentalUIConstants {

	public DefaultPalette() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Color getForeground(Object element) {
		// Personnalisation de la couleur de la fonte

		// Noeud courant = AGENCE (racine)
		if (element instanceof RentalAgency)
			return Display.getCurrent().getSystemColor(SWT.COLOR_GREEN);

		// Noeud courant = CUSTOMER
		else if (element instanceof Customer)
			// Exo 40
			// return
			// Display.getCurrent().getSystemColor(SWT.COLOR_DARK_YELLOW);
			// Exo 80 : utilisation de la couleur de préférence
			return getAColor(RentalUIActivator.getDefault().getPreferenceStore().getString(PREF_CLRCUSTOMER));

		// Noeud courant = OBJETS LOUES
		else if (element instanceof RentalObject)
			// Exo 40
			// return Display.getCurrent().getSystemColor(SWT.COLOR_BLUE);
			// Exo 80 : utilisation de la couleur de préférence
			return getAColor(RentalUIActivator.getDefault().getPreferenceStore().getString(PREF_CLROBJECT));

		// Noeud courant = LOCATIONS
		else if (element instanceof Rental)
			// Exo 40
			// return
			// Display.getCurrent().getSystemColor(SWT.COLOR_DARK_MAGENTA);
			// Exo 80 : utilisation de la couleur de préférence
			return getAColor(RentalUIActivator.getDefault().getPreferenceStore().getString(PREF_CLRRENTAL));
		return null;
	}

	@Override
	public Color getBackground(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	// Conversion d'une chaine en couleur
	private Color getAColor(String rgbKey) {
		ColorRegistry colorRegistry = JFaceResources.getColorRegistry();

		Color col = colorRegistry.get(rgbKey);
		if (col == null) {
			colorRegistry.put(rgbKey, StringConverter.asRGB(rgbKey));
			col = colorRegistry.get(rgbKey);
		}
		return col;
	}

}
