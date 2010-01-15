package com.kereki.apisdemo.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.visualization.client.AbstractDataTable;
import com.google.gwt.visualization.client.DataTable;
import com.google.gwt.visualization.client.Selection;
import com.google.gwt.visualization.client.VisualizationUtils;
import com.google.gwt.visualization.client.AbstractDataTable.ColumnType;
import com.google.gwt.visualization.client.events.SelectHandler;
import com.google.gwt.visualization.client.visualizations.PieChart;
import com.google.gwt.visualization.client.visualizations.PieChart.Options;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Apisdemo
    implements EntryPoint {

  private Options createOptions() {
    final Options options = Options.create();
    options.setWidth(400);
    options.setHeight(240);
    options.set3D(true);
    options.setTitle("My Daily Activities");
    return options;
  }

  private SelectHandler createSelectHandler(final PieChart chart) {
    return new SelectHandler() {
      @Override
      public void onSelect(final SelectEvent event) {
        String message = "";

        // May be multiple selections.
        final JsArray<Selection> selections = chart.getSelections();

        for (int i = 0; i < selections.length(); i++) {
          // add a new line for each selection
          message += i == 0 ? "" : "\n";

          final Selection selection = selections.get(i);

          if (selection.isCell()) {
            // isCell() returns true if a cell has been selected.

            // getRow() returns the row number of the selected cell.
            final int row = selection.getRow();
            // getColumn() returns the column number of the selected cell.
            final int column = selection.getColumn();
            message += "cell " + row + ":" + column + " selected";
          } else if (selection.isRow()) {
            // isRow() returns true if an entire row has been selected.

            // getRow() returns the row number of the selected row.
            final int row = selection.getRow();
            message += "row " + row + " selected";
          } else {
            // unreachable
            message += "Pie chart selections should be either row selections or cell selections.";
            message += "  Other visualizations support column selections as well.";
          }
        }

        Window.alert(message);
      }
    };
  }

  private AbstractDataTable createTable() {
    final DataTable data = DataTable.create();
    data.addColumn(ColumnType.STRING, "Task");
    data.addColumn(ColumnType.NUMBER, "Hours per Day");
    data.addRow();
    data.setValue(data.getNumberOfRows() - 1, 0, "Work");
    data.setValue(data.getNumberOfRows() - 1, 1, 14);
    data.addRow();
    data.setValue(data.getNumberOfRows() - 1, 0, "Sleep1");
    data.setValue(data.getNumberOfRows() - 1, 1, 10);
    data.addRow();
    data.setValue(data.getNumberOfRows() - 1, 0, "Sleep2");
    data.setValue(data.getNumberOfRows() - 1, 1, 15);
    data.addRow();
    data.setValue(data.getNumberOfRows() - 1, 0, "Sleep3");
    data.setValue(data.getNumberOfRows() - 1, 1, 30);
    data.addRow();
    data.setValue(data.getNumberOfRows() - 1, 0, "Sleep4");
    data.setValue(data.getNumberOfRows() - 1, 1, 6);
    data.addRow();
    data.setValue(data.getNumberOfRows() - 1, 0, "Sleep5");
    data.setValue(data.getNumberOfRows() - 1, 1, 60);
    return data;
  }

  private native void getFeed() /*-{
    var myself = this;
    // Montevideo, UY=468052
    // Los Angeles, USA= 2442047

    var feed = new $wnd.google.feeds.Feed("http://weather.yahooapis.com/forecastrss?w=2442047&u=c");
    feed.load(function(result) {
    if (!result.error) {
    myself.@com.kereki.apisdemo.client.Apisdemo::processWeather(Lcom/kereki/apisdemo/client/WeatherFeed;)(result);
    }});
  }-*/;

  @Override
  public void onModuleLoad() {
    // AjaxLoader.init();
    // final AjaxLoaderOptions options = AjaxLoaderOptions.newInstance();
    // AjaxLoader.loadApi("feeds", "1", new Runnable() {
    // public void run() {
    // getFeed();
    // }
    // }, options);

    final Runnable onLoadCallback = new Runnable() {
      public void run() {
        final Panel panel = RootPanel.get();

        // Create a pie chart visualization.
        final PieChart pie = new PieChart(createTable(),
            createOptions());

        pie.addSelectHandler(createSelectHandler(pie));
        panel.add(pie);
      }
    };
    // Load the visualization api, passing the onLoadCallback to be called
    // when loading is done.
    VisualizationUtils.loadVisualizationApi(onLoadCallback,
        PieChart.PACKAGE);

  }

  void processWeather(final WeatherFeed ww) {
    Window.alert("feed title " + ww.getFeedTitle());
    Window.alert("number of items " + ww.getNumberOfEntries());
  }

}
