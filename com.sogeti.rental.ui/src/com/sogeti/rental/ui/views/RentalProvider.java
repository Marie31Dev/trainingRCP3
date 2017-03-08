package com.sogeti.rental.ui.views;

import java.util.Collection;

import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

import com.opcoach.training.rental.Customer;
import com.opcoach.training.rental.Rental;
import com.opcoach.training.rental.RentalAgency;
import com.opcoach.training.rental.RentalObject;
import com.sogeti.rental.ui.RentalUIActivator;
import com.sogeti.rental.ui.RentalUIConstants;

public class RentalProvider extends LabelProvider implements ITreeContentProvider, IColorProvider, RentalUIConstants {

	// -------------------------------------------------------------
	// METHODES de l'interface ITreeContentProvider qu'on implémente
	// -------------------------------------------------------------
	// Appelé pour le premier niveau uniquement
	@Override
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof Collection<?>)
			return ((Collection<?>) inputElement).toArray();

		return null;
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof RentalAgency) {
			// Exo 1
			// return ((RentalAgency) parentElement).getCustomers().toArray();

			// Exo 2: création de 3 noeuds.
			//
			return new Node[] { new Node(Node.CUSTOMERS, (RentalAgency) parentElement),
					new Node(Node.RENTALS, (RentalAgency) parentElement),
					new Node(Node.OBJECTS, (RentalAgency) parentElement) };
		} else if (parentElement instanceof Node) {
			// Exo 2
			return ((Node) parentElement).getChildren();
		}

		return null;
	}

	@Override
	public Object getParent(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		// TODO Auto-generated method stub
		return true;
	}

	// ---------------------------------------
	// METHODE DU LabelProvider dont on hérite
	// ---------------------------------------
	@Override
	public String getText(Object element) {

		// Noeud courant = Racine : AGENCE
		if (element instanceof RentalAgency)
			return ((RentalAgency) element).getName();

		// Noeud courant = CUSTOMER
		else if (element instanceof Customer)
			return ((Customer) element).getDisplayName();

		// Noeud courant = OBJETS LOUES
		else if (element instanceof RentalObject)
			return ((RentalObject) element).getName().toString();
		
		//Pas besoin de le faire pour les objets Rental car la méthode toString est déjà surchargée dans la classe Rental 
		
		return super.getText(element);
	}
	
	// ----------------------------------------
	// METHODE DU  dont on hérite
	// ----------------------------------------
	@Override
	public Image getImage(Object element) {

		// Noeud courant = AGENCE (racine)
		if (element instanceof RentalAgency)
			return RentalUIActivator.getDefault().getImageRegistry().get(IMG_AGENCY);

		// Noeud courant = CUSTOMER
		else if (element instanceof Customer)
			return RentalUIActivator.getDefault().getImageRegistry().get(IMG_CUSTOMER);

		// Noeud courant = OBJETS LOUES
		else if (element instanceof RentalObject)		
			return RentalUIActivator.getDefault().getImageRegistry().get(IMG_OBJECT);		

		// Noeud courant = LOCATIONS
		else if (element instanceof Rental)
			return RentalUIActivator.getDefault().getImageRegistry().get(IMG_RENTAL);
			
			return super.getImage(element);
	}

	// -------------------------------------------------------
	// METHODES de l'interface IColorProvider qu'on implémente
	// -------------------------------------------------------
	@Override
	public Color getForeground(Object element) {
		
		// Noeud courant = AGENCE (racine)
		if (element instanceof RentalAgency)
			return Display.getCurrent().getSystemColor(SWT.COLOR_GREEN);
		
		// Noeud courant = CUSTOMER
		else if (element instanceof Customer)
			return Display.getCurrent().getSystemColor(SWT.COLOR_YELLOW);
		
		// Noeud courant = OBJETS LOUES
		else if (element instanceof RentalObject)
			return Display.getCurrent().getSystemColor(SWT.COLOR_BLUE);
		
		// Noeud courant = LOCATIONS
		else if (element instanceof Rental)
			return Display.getCurrent().getSystemColor(SWT.COLOR_DARK_MAGENTA);
		return null;
	}

	@Override
	public Color getBackground(Object element) {
		// TODO Auto-generated method stub
		return null;
	}
}

// Creation d'un noeud logique
class Node {

	// Constantes
	public static final String CUSTOMERS = "Customers";
	public static final String RENTALS = "Locations";
	public static final String OBJECTS = "Objets à louer";

	private String label;
	private RentalAgency agency;

	// Constructeur du noeud logique
	public Node(String label, RentalAgency agency) {
		super();
		this.label = label;
		this.agency = agency;
	}

	Object[] getChildren() {
		if (label == CUSTOMERS) {
			return agency.getCustomers().toArray();
		}

		else if (label == RENTALS) {
			return agency.getRentals().toArray();

		} else if (label == OBJECTS) {
			return agency.getObjectsToRent().toArray();
		}
		return null;
	}

	@Override
	public String toString() {
		return label;
	}

}
