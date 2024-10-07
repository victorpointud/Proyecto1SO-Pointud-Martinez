package GUI;

import Companies.Company;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import main.Global;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/*
* made by: victorpointud
*/

/**
 * Represents a graphical chart used for displaying company profits over time.
 */
public class Chart {

    private final XYSeries hpProfitSeries = new XYSeries("HP Profit");
    private final XYSeries dellProfitSeries = new XYSeries("DELL Profit");
    private final XYSeriesCollection hpDataCollection = new XYSeriesCollection(hpProfitSeries);
    private final XYSeriesCollection dellDataCollection = new XYSeriesCollection(dellProfitSeries);
    private final XYSeriesCollection combinedDataCollection = new XYSeriesCollection();
    private final JFreeChart hpChart = ChartFactory.createXYLineChart("HP Profit Over Time", "Time", "Profit", hpDataCollection, PlotOrientation.VERTICAL, true, true, false);
    private final JFreeChart dellChart = ChartFactory.createXYLineChart("DELL Profit Over Time", "Time", "Profit", dellDataCollection, PlotOrientation.VERTICAL, true, true, false);
    private final JFreeChart combinedChart = ChartFactory.createXYLineChart("HP vs DELL Profit", "Time", "Profit", combinedDataCollection, PlotOrientation.VERTICAL, true, true, false);
    private final JPanel hpChartPanel = new ChartPanel(hpChart);
    private final JPanel dellChartPanel = new ChartPanel(dellChart);
    private final JPanel combinedChartPanel = new ChartPanel(combinedChart);
    private Company hpCompany;
    private Company dellCompany;

    private int dayCounter = 0;

    /**
     * Constructs a Chart instance for visualizing company profit over time.
     */
    public Chart(Company company1, int comparisonType, Company company2) {
        JFrame frame = new JFrame();
        Timer timer = createTimer();

        switch (comparisonType) {
            case 1 -> {
                this.hpCompany = company1;
                configureHpChart(frame, timer);
            }
            case 2 -> {
                this.dellCompany = company1;
                configureDellChart(frame, timer);
            }
            default -> {
                this.hpCompany = company1;
                this.dellCompany = company2;
                configureCombinedChart(frame, timer);
            }
        }
        
        setupFrame(frame);
    }

    /**
     * Configures the HP chart with data series and starts the timer for updates.
     */
    private void configureHpChart(JFrame frame, Timer timer) {
        frame.add(hpChartPanel, BorderLayout.CENTER);
        timer.addActionListener(e -> {
            float totalCost = calculateTotalCost(hpCompany);
            dayCounter++;
            hpProfitSeries.addOrUpdate(dayCounter, Math.round(hpCompany.getCompanyDrive().getEarnings() - totalCost));
        });
        timer.start();
    }

    /**
     * Configures the DELL chart with data series and starts the timer for updates.
     */
    private void configureDellChart(JFrame frame, Timer timer) {
        frame.add(dellChartPanel, BorderLayout.CENTER);
        timer.addActionListener(e -> {
            float totalCost = calculateTotalCost(dellCompany);
            dayCounter++;
            dellProfitSeries.addOrUpdate(dayCounter, Math.round(dellCompany.getCompanyDrive().getEarnings() - totalCost));
        });
        timer.start();
    }

    /**
     * Configures the combined HP vs DELL chart and starts the timer for updates.
     */
    private void configureCombinedChart(JFrame frame, Timer timer) {
        combinedDataCollection.addSeries(hpProfitSeries);
        combinedDataCollection.addSeries(dellProfitSeries);

        frame.add(combinedChartPanel, BorderLayout.CENTER);
        timer.addActionListener(e -> {
            dayCounter++;
            float hpCost = calculateTotalCost(hpCompany);
            float dellCost = calculateTotalCost(dellCompany);

            hpProfitSeries.addOrUpdate(dayCounter, Math.round(hpCompany.getCompanyDrive().getEarnings() - hpCost));
            dellProfitSeries.addOrUpdate(dayCounter, Math.round(dellCompany.getCompanyDrive().getEarnings() - dellCost));
        });
        timer.start();
    }

    /**
     * Sets up the JFrame to display the chart.
     */
    private void setupFrame(JFrame frame) {
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(900, 600);
        frame.setVisible(true);
    }

    /**
     * Creates a timer for updating the charts.
     */
    private Timer createTimer() {
        return new Timer(Math.round(Global.daysDuration), null);
    }

    /**
     * Calculates the total cost for a company based on worker expenses.
     */
    private float calculateTotalCost(Company company) {
        return company.getCompanyDrive().getBasePlateCost() +
               company.getCompanyDrive().getRamCost() +
               company.getCompanyDrive().getCpuCost() +
               company.getCompanyDrive().getPowerSupplyCost() +
               company.getCompanyDrive().getGraphicsCardCost() +
               company.getCompanyDrive().getIntegratorCost() +
               company.getCompanyDrive().getPmCost() +
               company.getCompanyDrive().getDirectorCost();
    }
}
