package designpatterns.structural;

public class SP04Proxy {
    public static void main(String[] args) {
        Document documentProxy1 = new DocumentProxy("Manager");
        documentProxy1.displayDocument();  // Access will be granted

        Document documentProxy2 = new DocumentProxy("Intern");
        documentProxy2.displayDocument();  // Access will be denied
    }

    public interface Document {
        void displayDocument();
    }

    public static class SensitiveDocument implements Document {
        private String documentContent;

        public SensitiveDocument(String documentContent) {
            this.documentContent = documentContent;
            loadDocumentFromDisk(); // Simulate expensive operation
        }

        private void loadDocumentFromDisk() {
            System.out.println("Loading document from disk: " + documentContent);
        }

        @Override
        public void displayDocument() {
            System.out.println("Displaying document: " + documentContent);
        }
    }

    public static class DocumentProxy implements Document {
        private SensitiveDocument sensitiveDocument;
        private String employeeRole;

        public DocumentProxy(String employeeRole) {
            this.employeeRole = employeeRole;
        }

        @Override
        public void displayDocument() {
            if ("Manager".equals(employeeRole)) {
                if (sensitiveDocument == null) {
                    sensitiveDocument = new SensitiveDocument("Sensitive Data - Company Financials");
                }
                sensitiveDocument.displayDocument();
            } else {
                System.out.println("Access denied. You do not have permission to view this document.");
            }
        }
    }

}
