package in.shashwatanand.datascience.nb;

import java.util.List;
import java.util.stream.Collectors;

import in.shashwatanand.datascience.TextLoader;
import in.shashwatanand.datascience.knn.FlowerRecord;
import in.shashwatanand.datascience.knn.FlowerRecordUtil;

public class NaiveBayesExample {
	public static void main(String[] args) {
		List<String> lines = TextLoader.getLines("iris.data");
		List<FlowerRecord> flowers = lines.stream().map((line) -> FlowerRecordUtil.parseFlower(line))
				.collect(Collectors.toList());

		NaiveBayesClassifier classifier = new NaiveBayesClassifier();
		flowers.forEach((flower) -> classifier.addDataItem(flower));

		System.out.println(classifier.classifyPoint(new FlowerRecord(0.1, 0.2, 0.3, 0.4, "?")));
	}
}
