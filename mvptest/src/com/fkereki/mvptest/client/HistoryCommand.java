package com.fkereki.mvptest.client;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.History;

public class HistoryCommand implements Command {
	String historyToken;


	public HistoryCommand(final String newToken) {
		historyToken = newToken;
	}


	public void execute() {
		History.newItem(historyToken, true);
	}
}
