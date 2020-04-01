package di;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Graph {
    private static Injector injector;

    private Graph() {
    }

    public static Injector createInjector() {
        injector = Guice.createInjector(new TestModule());
        return injector;
    }

    public static Injector getInjector() {
        return injector;
    }
}
