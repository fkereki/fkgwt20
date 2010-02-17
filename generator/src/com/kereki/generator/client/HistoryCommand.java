package com.kereki.generator.client;

import com.google.gwt.user.client.Command;

class HistoryCommand
    implements Command {
  String historyToken;

  public HistoryCommand(final String newToken) {
    historyToken = newToken;
  }

  public void execute() {
    // launch(historyToken);
  }
}