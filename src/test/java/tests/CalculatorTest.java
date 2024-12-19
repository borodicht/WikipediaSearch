package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CalculatorTest {

    public int add(int a, int b) {
        return a + b;
    }

    @DataProvider(name = "csvDataProvider")
    public Iterator<Object[]> csvDataProvider() throws IOException {
        List<Object[]> testData = new ArrayList<>();
        String path = "src/test/resources/test-data.csv"; // Путь к файлу
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int number1 = Integer.parseInt(parts[0].trim());
                int number2 = Integer.parseInt(parts[1].trim());
                int result = Integer.parseInt(parts[2].trim());
                testData.add(new Object[]{number1, number2, result});
            }
        }
        return testData.iterator();
    }

    @Test(dataProvider = "csvDataProvider")
    public void testAddition(int number1, int number2, int expectedResult) {
        Assert.assertEquals(
                add(number1, number2),
                expectedResult,
                "Результат сложения некорректен!");
    }
}
