/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.JFrame;
import java.awt.Color;

public class UtilityGraph extends JFrame {
    private DefaultCategoryDataset dataset;

    public UtilityGraph(String title) {
        super(title);
        // Create dataset
        dataset = createDataset();
        // Create chart
        JFreeChart chart = ChartFactory.createStackedBarChart(
                "Number of Instructions Executed per PCPU",
                "PCPU",
                "Number of Instructions",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);
        
        // Customize the chart
        CategoryPlot plot = chart.getCategoryPlot();
        StackedBarRenderer renderer = new StackedBarRenderer();
        renderer.setSeriesPaint(0, Color.BLUE); // User instructions
        renderer.setSeriesPaint(1, Color.RED); // OS instructions
        plot.setRenderer(renderer);
        
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        dataset.addValue(50, "User", "PCPU 1");
        dataset.addValue(100, "OS", "PCPU 1");

        dataset.addValue(70, "User", "PCPU 2");
        dataset.addValue(80, "OS", "PCPU 2");

        dataset.addValue(60, "User", "PCPU 3");
        dataset.addValue(140, "OS", "PCPU 3");

        dataset.addValue(90, "User", "PCPU 4");
        dataset.addValue(160, "OS", "PCPU 4");
        
        return dataset;
    }

    public void updateDataset(String pcpu, int userInstructions, int osInstructions) {
        dataset.addValue(userInstructions, "User", pcpu);
        dataset.addValue(osInstructions, "OS", pcpu);
    }

    
}