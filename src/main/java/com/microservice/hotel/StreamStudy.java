//package com.microservice.hotel;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.DoubleStream;
//import java.util.stream.IntStream;
//import java.util.stream.LongStream;
//import java.util.stream.Stream;
//
//public class StreamStudy {
//
//	public static void main(String[] args) {
//
//		List<String> list = List.of("A", "B", "C");
//		Stream<String> stream = list.stream(); // Sequential stream
//		Stream<String> parallelStream = list.parallelStream(); // Parallel stream
//
//		String[] array = { "A", "B", "C" };
//		Stream<String> ArrayStream = Arrays.stream(array);
//
//		Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5);
//
//		Stream<Double> randomNumbers = Stream.generate(Math::random).limit(10); // creates an infinite sequential stream
//																				// Generates 10 random numbers
//
//		Stream<Integer> stream2 = Stream.iterate(1, n -> n + 1).limit(10); // Generates numbers from 1 to 10
//
//		IntStream intStream = IntStream.range(1, 10); // Numbers from 1 to 9
//		IntStream intStreamInclusive = IntStream.rangeClosed(1, 10); // Numbers from 1 to 10
//
//		LongStream longStream = LongStream.rangeClosed(1, 10);
//		DoubleStream doubleStream = DoubleStream.of(1.0, 2.0, 3.0);
//
//		Stream<String> stream3 = Stream.<String>builder().add("A").add("B").add("C").build();
//
//
//		/// INTERMEDIATE METHODS
//
//	}
//}
