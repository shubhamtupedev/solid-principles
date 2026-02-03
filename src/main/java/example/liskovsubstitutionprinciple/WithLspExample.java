package example.liskovsubstitutionprinciple;

public class WithLspExample {
    public static void main(String[] args) {
        PrintableDocument pdfDocuments = new PDFDocuments();
        pdfDocuments.open("Resume.pdf");
        pdfDocuments.print("Resume.pdf");

        PrintableDocument wordDocuments = new WordDocuments();
        wordDocuments.open("Report.docx");
        wordDocuments.print("Report.docx");

        Documents text = new TextDocuments();
        text.open("shubham.txt");
        text.save("shubham.txt");

    }
}

class Documents {
    private String title;
    private String content;

    public void open(String filename) {
        System.out.println("Opening the Document");
    }

    public void save(String filename) {
        System.out.println("Saving the Document");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

class PrintableDocument extends Documents {
    public void print(String filename) {
        System.out.println("Printing the Document");
    }
}

class PDFDocuments extends PrintableDocument {
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

class WordDocuments extends PrintableDocument {
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

class TextDocuments extends Documents {
    @Override
    public void open(String filename) {
        System.out.println("Opening the Text Document");
    }

    @Override
    public void save(String filename) {
        System.out.println("Saving the Text Document");
    }
    // no need to extend print because parent does not have print()
}


