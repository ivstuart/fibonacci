package maths;


import java.math.BigInteger;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TupleMain {

    private static long number = 1000;

    public static void main(String[] args) {
        Tuple<BigInteger, BigInteger> seed = new Tuple<>(BigInteger.ONE, BigInteger.ONE);
        UnaryOperator<Tuple<BigInteger, BigInteger>> f = x -> new Tuple<>(x._2, x._1.add(x._2));
        Stream<BigInteger> fiboStream = Stream.iterate(seed, f)
                .map(x -> x._1)
                .limit(number);

        String result = fiboStream.map(BigInteger::toString).collect(Collectors.joining(", "));
        System.out.println(result);
    }
}
