package com.client;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Widget;

public class UsefulHorizontalPanel extends HorizontalPanel {

	public void replace(int index, Widget child) {
		this.remove(index);
		this.add(child);
	}

}
