package com.sogeti.rental.ui;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;

/**
 * The activator class controls the plug-in life cycle
 */
public class RentalUIActivator extends AbstractUIPlugin implements RentalUIConstants {

	// Implémente l'interface RentalUIConstants juste pour pouvoir récupérer les
	// constantes image de l'interface (IMG_AGENCY, etc).

	// The plug-in ID
	public static final String PLUGIN_ID = "com.sogeti.rental.ui"; //$NON-NLS-1$

	// The shared instance
	private static RentalUIActivator plugin;

	private  Map<String, Palette> paletteManager = new HashMap<>();

	/**
	 * The constructor
	 */
	public RentalUIActivator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.
	 * BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;

		readVueExtension();
		readPalette();
	}

	private void readVueExtension() {
		// Read all configurations
		IExtensionRegistry reg = Platform.getExtensionRegistry();
		for (IConfigurationElement e : reg.getConfigurationElementsFor("org.eclipse.ui.views")) {
			// On ne veut pas les element "category" et "stickyView"
			if (e.getName().equals("view"))
				// Affiche la liste de view avec leur nom et le nom du plugin
				// auquel la vue appartient
				System.out.println(e.getName() + " " + e.getAttribute("name") + " " + e.getNamespaceIdentifier());
		}
	}

	private void readPalette() {
		// Read all configurations
		IExtensionRegistry reg = Platform.getExtensionRegistry();
		// On lit chaque element du plugin "com.sogeti.rental.ui.palette" : il n'y a que des palettes. On en a 2.
		for (IConfigurationElement e : reg.getConfigurationElementsFor("com.sogeti.rental.ui.palette")) {
			// Dans la map, on stocke chaque palette créée dans les extensions
			try {
				// Création de la palette
				Palette p = new Palette();
				p.setId(e.getAttribute("id"));
				p.setName(e.getAttribute("name"));
				//Création du colorProvider 
				IColorProvider pr = (IColorProvider) e.createExecutableExtension("paletteClass");
				p.setProvider(pr);
				paletteManager.put(p.getId(), p);
			} catch (CoreException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			// Affiche la liste de view avec leur nom et le nom du plugin auquel
			// la vue appartient
			System.out.println(e.getName() + " " + e.getAttribute("name") + " " + e.getNamespaceIdentifier());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.
	 * BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static RentalUIActivator getDefault() {
		return plugin;
	}

	@Override
	protected void initializeImageRegistry(ImageRegistry reg) {
		super.initializeImageRegistry(reg);

		// Récupère le bundle de ce plugin

		// Un plugin est un bundle qui a en plus les onglets Extensions et
		// Points d'extension, spécifiques à Eclipse
		Bundle b = FrameworkUtil.getBundle(this.getClass()); // On peut mettre
																// ici n'importe
																// quelle classe
																// du plugin en
																// paramètre

		reg.put(IMG_AGENCY, ImageDescriptor.createFromURL(b.getEntry(IMG_AGENCY)));
		reg.put(IMG_RENTAL, ImageDescriptor.createFromURL(b.getEntry(IMG_RENTAL)));
		reg.put(IMG_OBJECT, ImageDescriptor.createFromURL(b.getEntry(IMG_OBJECT)));
		reg.put(IMG_CUSTOMER, ImageDescriptor.createFromURL(b.getEntry(IMG_CUSTOMER)));
	}

	public  Map<String, Palette> getPaletteManager() {
		// TODO Auto-generated method stub
		return paletteManager;
	}

}
