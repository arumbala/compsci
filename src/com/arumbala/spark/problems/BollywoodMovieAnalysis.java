package com.arumbala.spark.problems;

import org.apache.spark.sql.Column;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import static org.apache.spark.sql.functions.*;

// Spark Read a CSV, explore schema, and perform basic DataFrame operations.
public class BollywoodMovieAnalysis {

    public static void main(String[] args) {
        SparkSession spark = SparkSession.builder()
                .appName("BollywoodMovieAnalysis")
                .master("local[*]")
                .getOrCreate();

        spark.sparkContext().setLogLevel("ERROR");

        // 1. Read CSV into a DataFrame
        Dataset<Row> movies = spark.read()
                .format("csv")
                .option("header", "true")
                .option("inferSchema", "true")
                .load("data/BollywoodMovieDetail.csv");

        // 2. Print schema
        movies.printSchema();

        // 3. List all columns
        String[] columns = movies.columns();
        for (String c : columns) {
            System.out.println(c);
        }

        // 4. Access a column - returns Column object
        Column ratingCol = movies.col("hitFlop");

        // 5. Show first 10 rows
        movies.show(10);

        // 6. Select specific columns
        movies.select("title", "hitFlop", "genre").show();

        // 7. Filter rows
        movies.filter(col("hitFlop").equalTo("Hit")).show();

        // 8. Group by and count
        movies.groupBy("genre").count().show();

        // 9. Order by a column descending
        movies.orderBy(col("releaseYear").desc()).show();

        // 10. Add a new derived column
        movies.withColumn("isHit", col("hitFlop").equalTo("Hit")).show();

        spark.stop();
    }
}