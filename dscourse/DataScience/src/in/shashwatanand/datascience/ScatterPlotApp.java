package in.shashwatanand.datascience;

import java.util.List;
import java.util.stream.Collectors;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
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
		
		Series olderCarSeries = new Series();
		Series newerCarSeries = new Series();
		
		List<CarRecord> olderCars = cars.stream()
				.filter((car) -> car.year <= 76)
				.collect(Collectors.toList());

		List<CarRecord> newerCars = cars.stream()
				.filter((car) -> car.year > 76)
				.collect(Collectors.toList());
		
		olderCars.forEach((car) -> {
			olderCarSeries.getData().add(new Data(car.weight, car.mpg));
		});
		
		newerCars.forEach((car) -> {
			newerCarSeries.getData().add(new Data(car.weight, car.mpg));
		});
		
		NumberAxis xAxis = new NumberAxis();
		NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel("Weight");
		yAxis.setLabel("MPG");
		
		ScatterChart<Number, Number> scatterChart = new ScatterChart<>(xAxis, yAxis);
		scatterChart.getData().add(olderCarSeries);
		scatterChart.getData().add(newerCarSeries);
		
		scatterChart.setTitle("Weight vs Mileage");
		scatterChart.setHorizontalGridLinesVisible(false);
		scatterChart.setVerticalGridLinesVisible(false);
		scatterChart.setHorizontalZeroLineVisible(false);
		
		Scene scene = new Scene(scatterChart, 600, 700);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
