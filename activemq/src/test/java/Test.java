import java.lang.management.ManagementFactory;
import java.util.List;

public class Test {

    @org.junit.Test
    public void test() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(System.getProperty("java.vendor"));
        buffer.append(" ");
        buffer.append(System.getProperty("java.version"));
        buffer.append(" ");
        buffer.append(System.getProperty("java.home"));
        System.out.println("Java Runtime: " + buffer.toString());

        buffer = new StringBuilder();
        buffer.append("current=");
        buffer.append(Runtime.getRuntime().totalMemory()/1024L);
        buffer.append("k  free=");
        buffer.append(Runtime.getRuntime().freeMemory()/1024L);
        buffer.append("k  max=");
        buffer.append(Runtime.getRuntime().maxMemory()/1024L);
        buffer.append("k");
        System.out.println("  Heap sizes: " + buffer.toString());

        List<String> jvmArgs = ManagementFactory.getRuntimeMXBean().getInputArguments();
        buffer = new StringBuilder();
        for (String arg : jvmArgs) {
            buffer.append(" ").append(arg);
        }
        System.out.println("    JVM args:" + buffer.toString());
    }

}
