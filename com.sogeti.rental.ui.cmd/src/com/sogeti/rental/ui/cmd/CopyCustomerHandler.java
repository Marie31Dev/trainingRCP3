package com.sogeti.rental.ui.cmd;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.RTFTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.handlers.HandlerUtil;

import com.opcoach.training.rental.Customer;

public class CopyCustomerHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// TODO Auto-generated method stub

		ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
		if (currentSelection instanceof IStructuredSelection) {
			Object o = ((IStructuredSelection) currentSelection).getFirstElement();

			if (o instanceof Customer) {
				Clipboard clipboard = new Clipboard(Display.getCurrent());
				String textData = ((Customer) o).getDisplayName();
				String rtfData = "{\\rtf1\\b\\i " + textData + "}";

				// Le clipboard a besoin de 2 tableaux :
				// - un contenant les données : Data
				// - un contenant les mises en formes RTF
				TextTransfer textTransfer = TextTransfer.getInstance();
				RTFTransfer rtfTransfer = RTFTransfer.getInstance();
				Transfer[] transfers = new Transfer[] { textTransfer, rtfTransfer };
				Object[] data = new Object[] { textData, rtfData };
				clipboard.setContents(data, transfers);
				clipboard.dispose();
			}
		}

		return null;
	}

}
