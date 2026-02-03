package example.liskovsubstitutionprinciple;

public class WithoutLspExample {
    public static void main(String[] args) {
        Document document = new Document();
        document.print("ABC.extension");

        document = new TextDocument();
        document.print("ABC.txt");
    }
}

class Document {
    public void open(String filename) {
        System.out.println("Opening the document");
    }

    public void save(String filename) {
        System.out.println("Saving the document");
    }

    public void print(String filename) {
        System.out.println("Printing the document");
    }
}


class PDFDocument extends Document {
    @Override
    public void open(String filename) {
        System.out.println("Opening the PDF Document");
    }

    @Override
    public void save(String filename) {
        System.out.println("Saving the PDF Document");
    }

    @Override
    public void print(String filename) {
        System.out.println("Printing the PDF Document");
    }
}

class WordDocument extends Document {
    @Override
    public void open(String filename) {
        System.out.println("Opening the Word Document");
    }

    @Override
    public void save(String filename) {
        System.out.println("Saving the Word Document");
    }

    @Override
    public void print(String filename) {
        System.out.println("Printing the Word Document");
    }
}

class TextDocument extends Document {
    @Override
    public void open(String filename) {
        System.out.println("Opening the Text Document");
    }

    @Override
    public void save(String filename) {
        System.out.println("Saving the Text Document");
    }

    @Override
    public void print(String filename) {
        throw new UnsupportedOperationException(); // 🚨 Violation!
    }
}

