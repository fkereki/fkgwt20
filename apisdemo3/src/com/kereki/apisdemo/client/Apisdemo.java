package com.kereki.apisdemo.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.visualization.client.AbstractDataTable;
import com.google.gwt.visualization.client.DataTable;
import com.google.gwt.visualization.client.LegendPosition;
import com.google.gwt.visualization.client.Selection;
import com.google.gwt.visualization.client.VisualizationUtils;
import com.google.gwt.visualization.client.AbstractDataTable.ColumnType;
import com.google.gwt.visualization.client.events.SelectHandler;
import com.google.gwt.visualization.client.visualizations.AreaChart;
import com.google.gwt.visualization.client.visualizations.Gauge;
import com.google.gwt.visualization.client.visualizations.PieChart;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Apisdemo
    implements EntryPoint {

  private void addIdentValueRow(
      final DataTable data,
      final String ident,
      final double value) {

    data.addRow();
    data.setValue(data.getNumberOfRows() - 1, 0, ident);
    data.setValue(data.getNumberOfRows() - 1, 1, value);
  }

  private PieChart.Options create2010PopOptions() {
    final PieChart.Options options = PieChart.Options.create();
    options.setWidth(400);
    options.setHeight(360);
    options.set3D(true);
    options.setTitle("World Pop (millions)");
    return options;
  }

  private AbstractDataTable create2010PopTable() {
    /*
     * 2010 Population Data taken from
     * http://www.xist.org/earth/population1.aspx
     */
    final DataTable data = DataTable.create();
    data.addColumn(ColumnType.STRING, "Country");
    data.addColumn(ColumnType.NUMBER, "Population (millions)");

    addIdentValueRow(data, "China", 1338.6);
    addIdentValueRow(data, "India", 1166.1);
    addIdentValueRow(data, "USA", 307.2);
    addIdentValueRow(data, "Indonesia", 240.2);
    addIdentValueRow(data, "Brazil", 198.7);
    addIdentValueRow(data, "Pakistan", 176.2);
    addIdentValueRow(data, "Bangladesh", 156.1);
    addIdentValueRow(data, "Nigeria", 149.2);
    addIdentValueRow(data, "Russia", 140.0);
    addIdentValueRow(data, "Japan", 127.1);
    addIdentValueRow(data, "Rest of the World", 2834.1);
    return data;
  }

  private Gauge.Options createPopGaugeOptions() {
    final Gauge.Options options = Gauge.Options.create();
    options.setWidth(300);
    options.setHeight(300);

    options.setGaugeRange(0, 10000);
    options.setGreenRange(1500, 3000);
    options.setYellowRange(3000, 5000);
    options.setRedRange(5000, 10000);

    options.setMajorTicks(new String[] { "0", "2bn", "4bn", "6bn",
        "8bn", "1bn" });
    options.setMinorTicks(10);

    return options;
  }

  private AbstractDataTable createPopGaugeTable() {
    /*
     * 2010 Population Data taken from
     * http://www.xist.org/earth/population1.aspx
     */
    final DataTable data = DataTable.create();
    data.addColumn(ColumnType.STRING, "Population");
    data.addColumn(ColumnType.NUMBER, "Millions");
    addIdentValueRow(data, "World", 6833.5);
    return data;
  }

  private AreaChart.Options createPopGrowthOptions() {
    final AreaChart.Options options = AreaChart.Options.create();
    options.setWidth(400);
    options.setHeight(360);
    options.setTitle("Population (millions) Growth");
    options.setLegend(LegendPosition.NONE);
    options.setMin(0);
    options.setEnableTooltip(true);
    return options;
  }

  private AbstractDataTable createPopGrowthTable() {
    /*
     * World (actual and projected) Population Data from
     * http://www.xist.org/earth/his_proj.aspx
     */
    final DataTable data = DataTable.create();
    data.addColumn(ColumnType.STRING, "Decade");
    data.addColumn(ColumnType.NUMBER, "Pop (millions)");

    addIdentValueRow(data, "1950", 2255.9);
    addIdentValueRow(data, "1960", 3041.6);
    addIdentValueRow(data, "1970", 3711.8);
    addIdentValueRow(data, "1980", 4452.8);
    addIdentValueRow(data, "1990", 5282.4);
    addIdentValueRow(data, "2000", 6084.9);
    addIdentValueRow(data, "2010", 6866.9);
    addIdentValueRow(data, "2020", 7659.3);
    addIdentValueRow(data, "2030", 8373.1);
    addIdentValueRow(data, "2040", 9003.2);
    addIdentValueRow(data, "2050", 9539.0);
    return data;
  }

  @Override
  public void onModuleLoad() {
    final HorizontalPanel hp = new HorizontalPanel();
    RootPanel.get().add(hp);

    final Runnable onVisualizationsLoadCallback = new Runnable() {
      public void run() {
        final PieChart worldPopPie = new PieChart(create2010PopTable(),
            create2010PopOptions());

        worldPopPie.addSelectHandler(new SelectHandler() {
          @Override
          public void onSelect(final SelectEvent event) {
            final JsArray<Selection> selections = worldPopPie
                .getSelections();
            final int chosenRow = selections.get(0).getRow();
            Window.alert("you clicked on country #" + (chosenRow + 1));
          }
        });

        hp.add(worldPopPie);

        final AreaChart popGrowthChart = new AreaChart(
            createPopGrowthTable(), createPopGrowthOptions());
        hp.add(popGrowthChart);

        final Gauge popGauge = new Gauge(createPopGaugeTable(),
            createPopGaugeOptions());
        hp.add(popGauge);
      }
    };

    // Load the Visualizations API, including the desired packages, and call our
    // callback when done
    VisualizationUtils.loadVisualizationApi(
        onVisualizationsLoadCallback, PieChart.PACKAGE,
        AreaChart.PACKAGE, Gauge.PACKAGE);
  }
}
