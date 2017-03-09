package com.sogeti.rental.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

public class HandlerHelloworld extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window;
		window = HandlerUtil.getActiveWorkbenchWindow(event);
		MessageDialog.openInformation(window.getShell(), "Actions de ma commande", "Hello world");
		//Always return null (reserved for future use)
		return null;
	}

}
