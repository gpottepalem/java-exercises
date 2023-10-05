import java.io.IOException;

class Scratch {
    // https://www.codejava.net/java-se/file-io/execute-operating-system-commands-using-runtime-exec-methods
    public static void main(String[] args) throws IOException {
        //System.out.println(System.getProperties());
        System.out.println("Java System Property (user.name): " + System.getProperty("user.name"));

        Process process = Runtime.getRuntime().exec("id -F");
        var inputReader = process.inputReader();

        String commandOutputLine;
        while ((commandOutputLine = inputReader.readLine()) != null) {
            System.out.println("Full username from Mac OS user identity command(id -F): " + commandOutputLine);
        }

    }
}
