package di;

import com.google.inject.Guice;
import com.google.inject.Injector;
import lombok.Getter;

public class Graph {

    @Getter
    private static Injector injector;

    private Graph() {
    }

    public static Injector createInjector() {
        injector = Guice.createInjector(new TestModule());
        return injector;
    }
}
