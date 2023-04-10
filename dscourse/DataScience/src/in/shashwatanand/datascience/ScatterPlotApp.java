package in.shashwatanand.datascience;

import java.util.List;
import java.util.stream.Collectors;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.stage.Stage;

public class ScatterPlotApp extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		List<String> lines = TextLoader.getLines("auto-mpg.data");
		List<CarRecord> cars = lines.stream()
				.map((line) -> CarRecordUtil.parseCar(line))
				.collect(Collectors.toList());
		
		List<Float> xValues = cars.stream()
				.map((car) -> car.weight)
				.collect(Collectors.toList());
		
		List<Float> yValues = cars.stream()
				.map((car) -> car.mpg)
				.collect(Collectors.toList());
		
		NumberAxis xAxis = new NumberAxis();
		NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel("Weight");
		yAxis.setLabel("MPG");
		
		ScatterChart<Number, Number> scatterChart = new ScatterChart<>(xAxis, yAxis);
		Series dataPointSeries = new Series();
		for (int i = 0; i < cars.size(); i++) {
			Data newDataPoint = new Data(xValues.get(i), yValues.get(i));
			dataPointSeries.getData().add(newDataPoint);
		}
		
		scatterChart.getData().add(dataPointSeries);
		scatterChart.setTitle("Weight vs Mileage");
		scatterChart.setHorizontalGridLinesVisible(false);
		scatterChart.setVerticalGridLinesVisible(false);
		scatterChart.setHorizontalZeroLineVisible(false);
		
		Scene scene = new Scene(scatterChart, 400, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
