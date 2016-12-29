/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import modell.FuzzySet;
import modell.MembershipValue;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

/**
 *
 * @author adrian
 */
public class FuzzySetView extends JPanel {

    private final FuzzySet fuzzySet;
    private final double tickUnit;
    private Color[] colors;
    private JFreeChart chart;
    private ChartPanel chartPanel;
    private XYPlot plot;

    public FuzzySetView(FuzzySet fuzzySet, double tickUnit) {
        this.fuzzySet = fuzzySet;
        this.tickUnit = tickUnit;

        createChart();
        initColors();
        setupRenderer();

        add(chartPanel);
    }

    private void createChart() {
        String name = fuzzySet.getName();
        chart = ChartFactory.createXYLineChart(name, name, "u(" + name + ")",
                fuzzySet, PlotOrientation.VERTICAL, true, true, false);
        chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(450, 200));
    }

    private void initColors() {
        colors = new Color[]{Color.BLUE, Color.RED, Color.GREEN, Color.ORANGE, Color.MAGENTA};
    }

    private void setupRenderer() {
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setShapesVisible(false);

        plot = chart.getXYPlot();
        int termCount = plot.getSeriesCount();

        for (int i = 0; i < termCount; i++) {
            renderer.setSeriesPaint(i, colors[i]);
        }

        BasicStroke stroke = new BasicStroke(3f);
        for (int i = 0; i < termCount; i++) {
            renderer.setSeriesStroke(i, stroke);
        }

        plot.setRenderer(renderer);

        setupPlotAxes();
    }

    private void setupPlotAxes() {
        NumberAxis xAxis = (NumberAxis) plot.getDomainAxis();
        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();

        xAxis.setTickUnit(new NumberTickUnit(tickUnit));
        yAxis.setTickUnit(new NumberTickUnit(0.2));

        xAxis.setRange(fuzzySet.range);
        yAxis.setRange(0, 1.2);
    }

    public void deleteLegend() {
        chart.removeLegend();
    }

    public void showSingleton(double value) {
        BasicStroke stroke = new BasicStroke(3f);
        ValueMarker marker = new ValueMarker(value, Color.BLACK, stroke);
        plot.addDomainMarker(marker);
    }

    public void refresh() {
        refreshRenderer();
        plot.clearDomainMarkers();
    }

    private void refreshRenderer() {
        XYItemRenderer renderer = plot.getRenderer();
        int termCount = plot.getSeriesCount();

        for (int i = 0; i < termCount; i++) {
            renderer.setSeriesPaint(i, colors[i]);
        }

        BasicStroke stroke = new BasicStroke(3f);
        for (int i = 0; i < termCount; i++) {
            renderer.setSeriesStroke(i, stroke);
        }
    }

    public void showFuzzyValues() {
        clearMarkers();

        BasicStroke dashedStroke = new BasicStroke(3f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 0, new float[]{9}, 0);
        double crispValue = 0;
        for (int i = 0; i < fuzzySet.getMembershipValuesLength(); i++) {
            MembershipValue value = fuzzySet.getMembershipValueAt(i);
            if (value != null) {
                ValueMarker marker = new ValueMarker(value.getValue(), Color.BLACK, dashedStroke);
                plot.addRangeMarker(marker);

                crispValue = value.getCrispValue();
                System.out.println(crispValue);
            }
        }
        System.out.println(crispValue);
        plot.addDomainMarker(new ValueMarker(crispValue, Color.BLACK, dashedStroke));
    }

    private void clearMarkers() {
        plot.clearDomainMarkers();
        plot.clearRangeMarkers();
    }
}
