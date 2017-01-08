/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import modell.FuzzySet;
import modell.MembershipValue;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYAreaRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.Range;

/**
 *
 * @author adrian
 */
public class FuzzySetView extends ChartPanel {

    private final double TICK_UNIT;
    private Color[] colors;    
    private XYPlot plot;

    public FuzzySetView(FuzzySet fuzzySet, double tickUnit) {
        super(ChartFactory.createXYLineChart(fuzzySet.getName(), fuzzySet.getVariableName(), "u(" + fuzzySet.getVariableName() + ")",
                fuzzySet, PlotOrientation.VERTICAL, true, true, false));
        
        TICK_UNIT = tickUnit;
        
        setPreferredSize(new Dimension(450, 200));
        
        initColors();
        setupRenderer();
    }

    private void initColors() {
        colors = new Color[]{Color.BLUE, Color.RED, Color.GREEN, Color.ORANGE, Color.MAGENTA};
    }

    private void setupRenderer() {
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setShapesVisible(false);

        plot = getChart().getXYPlot();
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

        xAxis.setTickUnit(new NumberTickUnit(TICK_UNIT));
        yAxis.setTickUnit(new NumberTickUnit(0.2));

        Range fuzzySetRange = getFuzzySet().range;
        xAxis.setRange(fuzzySetRange);
        yAxis.setRange(0, 1.2);
    }

    public void showSingleton(double value) {
        plot.clearDomainMarkers();
        
        BasicStroke stroke = new BasicStroke(2f);
        ValueMarker marker = new ValueMarker(value, Color.BLACK, stroke);
        plot.addDomainMarker(marker);
        
        fillView();
    }
    
    private void fillView() {
        XYAreaRenderer renderer = new XYAreaRenderer();
        renderer.setSeriesPaint(0, Color.CYAN);
        renderer.setSeriesOutlinePaint(0, Color.BLACK);
        renderer.setSeriesOutlineStroke(0, new BasicStroke(2f));
        renderer.setOutline(true);
        plot.setRenderer(renderer);
    }

    public void refreshRenderer() {
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

        BasicStroke dashedStroke = new BasicStroke(1.7f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 6f, new float[]{6f}, 0);
        double crispValue = 0;
        FuzzySet fuzzySet = getFuzzySet();
        for (int i = 0; i < fuzzySet.getMembershipValuesLength(); i++) {
            MembershipValue value = fuzzySet.getMembershipValueAt(i);
            if (value != null) {
                ValueMarker marker = new ValueMarker(value.getValue(), colors[i], dashedStroke);
                plot.addRangeMarker(marker);

                crispValue = value.getCrispValue();
            }
        }
        plot.addDomainMarker(new ValueMarker(crispValue, Color.BLACK, dashedStroke));
    }

    private void clearMarkers() {
        plot.clearDomainMarkers();
        plot.clearRangeMarkers();
    }
        
    private FuzzySet getFuzzySet() {
        return (FuzzySet) plot.getDataset();
    }
}
