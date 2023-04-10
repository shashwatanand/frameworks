package in.shashwatanand.datascience;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.List;
import java.util.stream.Collectors;

public class BarGraph extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        List<String> lines = TextLoader.getLines("auto-mpg.data");
        List<CarRecord> cars = lines.stream()
                .map((line) -> CarRecordUtil.parseCar(line))
                .collect(Collectors.toList());

        List<CarRecord> fourCylindersCars = cars.stream()
                .filter((car) -> car.numberOfCylinders == 4)
                .collect(Collectors.toList());

        List<CarRecord> sixCylindersCars = cars.stream()
                .filter((car) -> car.numberOfCylinders == 6)
                .collect(Collectors.toList());

        List<CarRecord> eightCylindersCars = cars.stream()
                .filter((car) -> car.numberOfCylinders == 8)
                .collect(Collectors.toList());

        XYChart.Series series = new XYChart.Series();
        series.getData().add(new XYChart.Data("4", CarRecordUtil.getAvergeMpg(fourCylindersCars)));
        series.getData().add(new XYChart.Data("6", CarRecordUtil.getAvergeMpg(sixCylindersCars)));
        series.getData().add(new XYChart.Data("8", CarRecordUtil.getAvergeMpg(eightCylindersCars)));

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Number of cylinders");
        yAxis.setLabel("Average mpg");

        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setAnimated(false);
        barChart.getData().add(series);
        barChart.setTitle("Average mpg of different engine types");
        barChart.setHorizontalGridLinesVisible(false);
        barChart.setVerticalGridLinesVisible(false);
        barChart.setHorizontalZeroLineVisible(false);

        Scene scene = new Scene(barChart, 600, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
