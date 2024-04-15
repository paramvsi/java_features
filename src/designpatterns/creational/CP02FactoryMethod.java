package designpatterns.creational;

public class CP02FactoryMethod {
    interface Document {
        void open();

        void save();
    }

    static class PdfDocument implements Document {
        public void open() {
            System.out.println("Opening PDF document");
        }

        public void save() {
            System.out.println("Saving PDF document");
        }
    }

    static class DocxDocument implements Document {
        public void open() {
            System.out.println("Opening DOCX document");
        }

        public void save() {
            System.out.println("Saving DOCX document");
        }
    }

    static class TxtDocument implements Document {
        public void open() {
            System.out.println("Opening TXT document");
        }

        public void save() {
            System.out.println("Saving TXT document");
        }
    }

    // Next, we define the DocumentConverterFactory interface
    // and its implementations to create converters for each document format:

    interface DocumentConverterFactory {
        Document createDocument();
    }

    static class PdfConverterFactory implements DocumentConverterFactory {
        public Document createDocument() {
            return new PdfDocument();
        }
    }

    static class DocxConverterFactory implements DocumentConverterFactory {
        public Document createDocument() {
            return new DocxDocument();
        }
    }

    static class TxtConverterFactory implements DocumentConverterFactory {
        public Document createDocument() {
            return new TxtDocument();
        }
    }

    public static void main(String[] args) {
        DocumentConverterFactory pdfFactory = new PdfConverterFactory();
        Document pdfDocument = pdfFactory.createDocument();
        pdfDocument.open();
        pdfDocument.save();

        DocumentConverterFactory docxFactory = new DocxConverterFactory();
        Document docxDocument = docxFactory.createDocument();
        docxDocument.open();
        docxDocument.save();

        DocumentConverterFactory txtFactory = new TxtConverterFactory();
        Document txtDocument = txtFactory.createDocument();
        txtDocument.open();
        txtDocument.save();
    }


}
