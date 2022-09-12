import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;

// 3 вариант
public class Main {
    public static void main(String[] args){
        draw_1a();
//        draw_1b();
//        draw_1v();
//        drawPolyharmonic();
//        draw_1bh();
    }

    public static void draw_1a(){
        First first_A = new First(512);
        first_A.setA(8);
        first_A.setF(4);

        XYSeries series1 = new XYSeries("pi/6");
        XYSeries series2 = new XYSeries("pi/3");
        XYSeries series3 = new XYSeries("2pi/3");
        XYSeries series4 = new XYSeries("pi/4");
        XYSeries series5 = new XYSeries("0");

        for(int i = 0; i < first_A.getN(); i++){
            series1.add(i, first_A.calculate_Afi(Math.PI/6, i));
            series2.add(i, first_A.calculate_Afi(Math.PI/3, i));
            series3.add(i, first_A.calculate_Afi(2*Math.PI/3, i));
            series4.add(i, first_A.calculate_Afi(Math.PI/4, i));
            series5.add(i, first_A.calculate_Afi(0, i));
        }

        createFrame(series1, series2, series3, series4, series5, "1a");
    }

    public static void draw_1b(){
        First first_A = new First(512);
        first_A.setA(8);
        first_A.setFi(0);

        XYSeries series1 = new XYSeries("8");
        XYSeries series2 = new XYSeries("1");
        XYSeries series3 = new XYSeries("5");
        XYSeries series4 = new XYSeries("4");
        XYSeries series5 = new XYSeries("9");

        for(int i = 0; i < first_A.getN(); i++){
            series1.add(i, first_A.calculate_Af(8, i));
            series2.add(i, first_A.calculate_Af(1, i));
            series3.add(i, first_A.calculate_Af(5, i));
            series4.add(i, first_A.calculate_Af(4, i));
            series5.add(i, first_A.calculate_Af(9, i));
        }

        createFrame(series1, series2, series3, series4, series5, "1b");
    }

    public static void draw_1bh(){
        First first_A = new First(100);
        first_A.setA(8);
        first_A.setFi(0);

        XYSeries series1 = new XYSeries("8");
        XYSeries series2 = new XYSeries("1");
        XYSeries series3 = new XYSeries("5");
        XYSeries series4 = new XYSeries("4");
        XYSeries series5 = new XYSeries("9");

        for(int i = 0; i < first_A.getN(); i++){
            series1.add(i, Math.sin(i));
            series2.add(i, Math.sin(i+Math.PI));
            series3.add(i, Math.sin(i+Math.PI/2));
            series4.add(i, Math.sin(i));
            series5.add(i, Math.sin(i));
        }

        createFrame(series1, series2, series3, series4, series5, "1b");
    }

    public static void draw_1v(){
        First first_A = new First(512);
        first_A.setF(2);
        first_A.setFi(0);

        XYSeries series1 = new XYSeries("8");
        XYSeries series2 = new XYSeries("3");
        XYSeries series3 = new XYSeries("2");
        XYSeries series4 = new XYSeries("1");
        XYSeries series5 = new XYSeries("4");

        for(int i = 0; i < first_A.getN(); i++){
            series1.add(i, first_A.calculate_ffi(8, i));
            series2.add(i, first_A.calculate_ffi(3, i));
            series3.add(i, first_A.calculate_ffi(2, i));
            series4.add(i, first_A.calculate_ffi(1, i));
            series5.add(i, first_A.calculate_ffi(4, i));
        }

        createFrame(series1, series2, series3, series4, series5, "1v");
    }

    public static void drawPolyharmonic(){
        First first_A = new First(512);

        XYSeries series1 = new XYSeries("polyharmonic");

        for(int i = 0; i < first_A.getN(); i++){
            series1.add(i, first_A.calculatePolyharmonic(i));
        }
        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        JFreeChart chart = ChartFactory
                .createXYLineChart("name", "n", "x(n)",
                        dataset,
                        PlotOrientation.VERTICAL,
                        true,
                        true,
                        true);
        JFrame frame = new JFrame("DSP_1");
        frame.getContentPane().add(new ChartPanel(chart));
        frame.setSize(500,400);
        frame.show();
    }

    private static void createFrame(XYSeries series1, XYSeries series2, XYSeries series3, XYSeries series4, XYSeries series5, String name) {
        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        dataset.addSeries(series3);
        dataset.addSeries(series4);
        dataset.addSeries(series5);

        JFreeChart chart = ChartFactory
                .createXYLineChart(name, "n", "x(n)",
                        dataset,
                        PlotOrientation.VERTICAL,
                        true,
                        true,
                        true);

        JFrame frame = new JFrame("DSP_1");
        frame.getContentPane().add(new ChartPanel(chart));
        frame.setSize(500,400);
        frame.show();
    }

}
