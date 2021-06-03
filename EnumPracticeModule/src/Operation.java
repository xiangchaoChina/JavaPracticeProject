import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

/**
 * @Description: 符号enum
 * @Author: xiangchao
 * @Version: 1.1.3
 * @Date: 2021/06/03 19:52
 */
public enum Operation {

    PLUS("+"){
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-"){
        @Override
        public double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES("*"){
        @Override
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/"){
        @Override
        public double apply(double x, double y) {
            return x / y;
        }
    };

    private String symbol;
    Operation(String symbol){
        this.symbol = symbol;
    }

    @Override
    public String toString(){
        return symbol;
    }

    public abstract double apply(double x, double y);

    private static final Map<String, Operation> stringToEnum = Stream.of(values()).collect( toMap(Object::toString, e->e) );

    public static Optional<Operation> formString(String symbol){
        return Optional.ofNullable(stringToEnum.get(symbol));
    }

}
