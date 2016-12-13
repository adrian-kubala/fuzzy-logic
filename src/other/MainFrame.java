/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.axis.NumberAxis;

/**
 *
 * @author adrian
 */
public class MainFrame extends javax.swing.JFrame {
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        
        createChart("temperatura otoczenia", createAmbientTempDataset(), -30, 35, toPanel, 5);
        createChart("temperatura bojlera", createBoilerTempDataset(), 7, 75, tbPanel, 5);
        createChart("siła ogrzewania", createOutputDataset(), 0, 4, soPanel, 4);
    }
    
    private void createChart(String title, XYDataset dataset, int from, int to, JPanel panel, int termCount) {
        JFreeChart xylineChart = ChartFactory.createXYLineChart(title, title, "u(" + title + ")",
                dataset, PlotOrientation.VERTICAL, true, true, false);
        
        ChartPanel chartPanel = new ChartPanel(xylineChart);
//        chartPanel.setPreferredSize(new Dimension(80, 40));
        
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setShapesVisible(false);

        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesPaint(1, Color.GREEN);
        renderer.setSeriesPaint(2, Color.YELLOW);
        renderer.setSeriesPaint(3, Color.CYAN);
        if (termCount == 5) {
            renderer.setSeriesPaint(4, Color.BLUE);
        }
        

                
        for (int i = 0; i < termCount; i++) {
            renderer.setSeriesStroke(i, new BasicStroke(3.0f));
        }

        XYPlot plot = xylineChart.getXYPlot();
        plot.setRenderer( renderer );

        NumberAxis xAxis = (NumberAxis) plot.getDomainAxis();
        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();

        xAxis.setTickUnit(new NumberTickUnit(10));
        yAxis.setTickUnit(new NumberTickUnit(0.2));

        xAxis.setRange(from, to);
        yAxis.setRange(0, 1.2);
        
        panel.setLayout(new FlowLayout());
        panel.setPreferredSize(new Dimension(400, 200));
        chartPanel.setPreferredSize(new Dimension(panel.getSize().width - 20, panel.getSize().height - 20));
        panel.add(chartPanel);
    }
        
    private XYDataset createAmbientTempDataset() {
        TrapezeTerm aTerm = new TrapezeTerm("bardzo niska", -30, -30, -10, 0);
        aTerm.createShape();

        TrapezeTerm bTerm = new TrapezeTerm("niska", -10, -2.5, 2.5, 10);
        bTerm.createShape();

        TrapezeTerm cTerm = new TrapezeTerm("średnia", 8, 11, 17, 20);
        cTerm.createShape();

        TriangularTerm dTerm = new TriangularTerm("wysoka", 15, 25, 30);
        dTerm.createShape();
        
        TrapezeTerm eTerm = new TrapezeTerm("bardzo wysoka", 25, 30, 35, 35);
        eTerm.createShape();

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(aTerm);
        dataset.addSeries(bTerm);
        dataset.addSeries(cTerm);
        dataset.addSeries(dTerm);
        dataset.addSeries(eTerm);
        return dataset;
    }
    
    private XYDataset createBoilerTempDataset() {
        TrapezeTerm aTerm = new TrapezeTerm("bardzo niska", 7, 7, 11, 15);
        aTerm.createShape();

        TriangularTerm bTerm = new TriangularTerm("niska", 10, 15, 20);
        bTerm.createShape();

        TriangularTerm cTerm = new TriangularTerm("średnia", 18, 26, 33);
        cTerm.createShape();

        TriangularTerm dTerm = new TriangularTerm("wysoka", 30, 45, 60);
        dTerm.createShape();
        
        TrapezeTerm eTerm = new TrapezeTerm("bardzo wysoka", 50, 62.5, 75, 75);
        eTerm.createShape();

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(aTerm);
        dataset.addSeries(bTerm);
        dataset.addSeries(cTerm);
        dataset.addSeries(dTerm);
        dataset.addSeries(eTerm);
        return dataset;
    }
    
    private XYDataset createOutputDataset() {
        TriangularTerm aTerm = new TriangularTerm("brak ogrzewania", 0, 0, 1);
        aTerm.createShape();

        TriangularTerm bTerm = new TriangularTerm("nieco ogrzewaj", 0, 1, 2);
        bTerm.createShape();

        TriangularTerm cTerm = new TriangularTerm("ogrzewaj", 1, 2, 3);
        cTerm.createShape();

        TriangularTerm dTerm = new TriangularTerm("bardzo ogrzewaj", 2, 3, 4);
        dTerm.createShape();
        
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(aTerm);
        dataset.addSeries(bTerm);
        dataset.addSeries(cTerm);
        dataset.addSeries(dTerm);
        return dataset;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toPanel = new javax.swing.JPanel();
        tbPanel = new javax.swing.JPanel();
        soPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout toPanelLayout = new javax.swing.GroupLayout(toPanel);
        toPanel.setLayout(toPanelLayout);
        toPanelLayout.setHorizontalGroup(
            toPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 306, Short.MAX_VALUE)
        );
        toPanelLayout.setVerticalGroup(
            toPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 198, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout tbPanelLayout = new javax.swing.GroupLayout(tbPanel);
        tbPanel.setLayout(tbPanelLayout);
        tbPanelLayout.setHorizontalGroup(
            tbPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        tbPanelLayout.setVerticalGroup(
            tbPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 197, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout soPanelLayout = new javax.swing.GroupLayout(soPanel);
        soPanel.setLayout(soPanelLayout);
        soPanelLayout.setHorizontalGroup(
            soPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        soPanelLayout.setVerticalGroup(
            soPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 189, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(toPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tbPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(soPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(395, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(toPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(tbPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(soPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel soPanel;
    private javax.swing.JPanel tbPanel;
    private javax.swing.JPanel toPanel;
    // End of variables declaration//GEN-END:variables
}
