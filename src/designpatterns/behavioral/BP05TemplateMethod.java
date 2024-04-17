package designpatterns.behavioral;

public class BP05TemplateMethod {
    public static void main(String[] args) {
        DataProcessor xmlProcessor = new XMLDataProcessor();
        xmlProcessor.process();

        DataProcessor jsonProcessor = new JSONDataProcessor();
        jsonProcessor.process();
    }

    public abstract static class DataProcessor {
        // Template method
        public final void process() {
            loadData();
            processData();
            saveData();
        }

        // Concrete method
        protected void loadData() {
            System.out.println("Generic load data");
        }

        // Abstract methods to be implemented by subclasses
        protected abstract void processData();

        protected abstract void saveData();
    }

    public static class XMLDataProcessor extends DataProcessor {
        @Override
        protected void processData() {
            System.out.println("Processing XML data");
        }

        @Override
        protected void saveData() {
            System.out.println("Saving XML data to disk");
        }
    }

    public static class JSONDataProcessor extends DataProcessor {
        @Override
        protected void processData() {
            System.out.println("Processing JSON data");
        }

        @Override
        protected void saveData() {
            System.out.println("Saving JSON data to cloud storage");
        }
    }


}
