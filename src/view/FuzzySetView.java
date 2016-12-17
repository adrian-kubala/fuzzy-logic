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
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.Range;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author adrian
 */
public class FuzzySetView extends JPanel {
     
    FuzzySet fuzzySet;
    Color[] colors;
    JFreeChart chart;
    ChartPanel chartPanel;
    
    public FuzzySetView(FuzzySet fuzzySet) {
        this.fuzzySet = fuzzySet;
        
        createChart();
        initColors();
        setupRenderer(); 
        
        add(chartPanel);
    }
    
    private void createChart() {
        String name = fuzzySet.name;
        chart = ChartFactory.createXYLineChart(name, name, "u(" + name + ")",
                fuzzySet, PlotOrientation.VERTICAL, true, true, false);
        chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(450, 200));
    }

    private void initColors() {
        colors = new Color[] {Color.BLUE, Color.RED, Color.GREEN, Color.ORANGE, Color.MAGENTA};
    }
    
    private void setupRenderer() {
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setShapesVisible(false);
        
        XYPlot plot = chart.getXYPlot();
        int termCount = plot.getSeriesCount();
           
        for(int i = 0; i < termCount; i++) {
            renderer.setSeriesPaint(i, colors[i]);
        }
               
        BasicStroke stroke = new BasicStroke(3f);
        for (int i = 0; i < termCount; i++) {
            renderer.setSeriesStroke(i, stroke);
        }

        plot.setRenderer(renderer);
        
        setupPlotAxises(plot);
    }

    private void setupPlotAxises(XYPlot plot) {
        NumberAxis xAxis = (NumberAxis) plot.getDomainAxis();
        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();

        xAxis.setTickUnit(new NumberTickUnit(10));
        yAxis.setTickUnit(new NumberTickUnit(0.2));

        xAxis.setRange(fuzzySet.range);
        yAxis.setRange(0, 1.2);
    }

}
