
package GUI;

import Companies.Company;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class Chart {

    XYSeries hpSeries = new XYSeries("Hp");
    XYSeries dellSeries = new XYSeries("Dell");
    XYSeriesCollection datosHp = new XYSeriesCollection(hpSeries);
    XYSeriesCollection datosDell = new XYSeriesCollection(dellSeries);
    XYSeriesCollection datosHpDell = new XYSeriesCollection();

    JFreeChart hpChart = ChartFactory.createXYLineChart("f(t) = Utilidad ", "Tiempo", "Utilidad", datosHp, PlotOrientation.VERTICAL, true, true, false);
    Company hp;
    JFreeChart dellChart = ChartFactory.createXYLineChart("f(t) = Utilidad ", "Tiempo", "Utilidad", datosDell, PlotOrientation.VERTICAL, true, true, false);
    Company dell;
    JFreeChart dellVsHpChart = ChartFactory.createXYLineChart("f(t) = Utilidad ", "Tiempo", "Utilidad", datosHpDell, PlotOrientation.VERTICAL, true, true, false);
    JPanel panelHp = new ChartPanel(hpChart);
    JPanel panelDell = new ChartPanel(dellChart);
    JPanel panelDellVsHp = new ChartPanel(dellVsHpChart);
    
    int myDAYS = 0;

    public Chart(Company company, int company3, Company company2) {
        JFrame frame = new JFrame();
        if (company3 == 1) {
            this.hp = company;
            Timer timer = new Timer(Math.round(Global.daysDuration), new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    float costHp = hp.getDrive().getBasePlateCost() + hp.getDrive().getRamCost() + hp.getDrive().getCpuCost() + hp.getDrive().getPowerSupplyCost() + hp.getDrive().getGraphicsCardCost() + hp.getDrive().getIntegratorCost() + hp.getDrive().getPmCost() + hp.getDrive().getDirectorCost();
                    myDAYS++;
                    hpSeries.addOrUpdate(myDAYS, Math.round(hp.getDrive().getEarnings() - costHp));
                }
            });
            frame.add(panelHp, BorderLayout.CENTER);
            timer.start();
        } 
        else if (company3 == 2) {
            this.dell = company;
            Timer timer = new Timer(Math.round(Global.daysDuration), new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    float costDell = dell.getDrive().getBasePlateCost() + dell.getDrive().getRamCost() + dell.getDrive().getCpuCost() + dell.getDrive().getPowerSupplyCost() + dell.getDrive().getGraphicsCardCost() + dell.getDrive().getIntegratorCost() + dell.getDrive().getPmCost() + dell.getDrive().getDirectorCost();
                    myDAYS++;
                    dellSeries.addOrUpdate(myDAYS, Math.round(dell.getDrive().getEarnings() - costDell));
                }
            });
            frame.add(panelDell, BorderLayout.CENTER);
            timer.start();

        } 
        else {
            this.hp = company;
            this.dell = company2;
            datosHpDell.addSeries(dellSeries);
            System.out.println("Agregue a DELL");
            datosHpDell.addSeries(hpSeries);
            System.out.println("Agregue a HP");
            Timer timer = new Timer(Math.round(Global.daysDuration), new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    myDAYS++;
                    float costHp = hp.getDrive().getBasePlateCost() + hp.getDrive().getRamCost() + hp.getDrive().getCpuCost() + hp.getDrive().getPowerSupplyCost() + hp.getDrive().getGraphicsCardCost() + hp.getDrive().getIntegratorCost() + hp.getDrive().getPmCost() + hp.getDrive().getDirectorCost();
                    hpSeries.addOrUpdate(myDAYS, Math.round(hp.getDrive().getEarnings() - costHp));
                    float costDell = dell.getDrive().getBasePlateCost() + dell.getDrive().getRamCost() + dell.getDrive().getCpuCost() + dell.getDrive().getPowerSupplyCost() + dell.getDrive().getGraphicsCardCost() + dell.getDrive().getIntegratorCost() + dell.getDrive().getPmCost() + dell.getDrive().getDirectorCost();
                    dellSeries.addOrUpdate(myDAYS, Math.round(dell.getDrive().getEarnings() - costDell));
                }
            });
            frame.add(panelDellVsHp, BorderLayout.CENTER);
            timer.start();
        }
        frame.setDefaultCloseOperation(frame.HIDE_ON_CLOSE);
        frame.setSize(900, 600);
        frame.setVisible(true);
    }
    
}
