package designpatterns.creational;

public class CP03AbstractFactory {

    public static void main(String[] args) {
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDocument = pdfFactory.createDocument();
        Metadata pdfMetadata = pdfFactory.createMetadata();

        pdfDocument.open();
        pdfDocument.save();
        pdfMetadata.readMetadata();
        pdfMetadata.writeMetadata();

        DocumentFactory docxFactory = new DocxDocumentFactory();
        Document docxDocument = docxFactory.createDocument();
        Metadata docxMetadata = docxFactory.createMetadata();

        docxDocument.open();
        docxDocument.save();
        docxMetadata.readMetadata();
        docxMetadata.writeMetadata();
    }

    interface Document {
        void open();

        void save();
    }

    interface Metadata {
        void readMetadata();

        void writeMetadata();
    }

    interface DocumentFactory {
        Document createDocument();

        Metadata createMetadata();
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

    static class PdfMetadata implements Metadata {
        public void readMetadata() {
            System.out.println("Reading PDF metadata");
        }

        public void writeMetadata() {
            System.out.println("Writing PDF metadata");
        }
    }

    static class DocxMetadata implements Metadata {
        public void readMetadata() {
            System.out.println("Reading DOCX metadata");
        }

        public void writeMetadata() {
            System.out.println("Writing DOCX metadata");
        }
    }

    static class PdfDocumentFactory implements DocumentFactory {
        public Document createDocument() {
            return new PdfDocument();
        }

        public Metadata createMetadata() {
            return new PdfMetadata();
        }
    }

    static class DocxDocumentFactory implements DocumentFactory {
        public Document createDocument() {
            return new DocxDocument();
        }

        public Metadata createMetadata() {
            return new DocxMetadata();
        }
    }


}
