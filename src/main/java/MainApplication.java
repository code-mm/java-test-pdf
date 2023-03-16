import com.itextpdf.awt.AsianFontMapper;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import javax.print.Doc;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class MainApplication {


    public static void main12(String[] args) throws Exception{


        //Create Document instance.
        Document document = new Document();

        //Create OutputStream instance.
        OutputStream outputStream =
                new FileOutputStream(new File("14.pdf"));

        //Create PDFWriter instance.
        PdfWriter.getInstance(document, outputStream);

        //Open the document.
        document.open();

        //Create Anchor object
        Anchor anchor = new Anchor("https://www.baidu.com/");
        anchor.setReference("https://www.w3schools.blog/");

        //Add content to the document using Anchor object.
        document.add(anchor);

        //Close document and outputStream.
        document.close();
        outputStream.close();

        System.out.println("Pdf created successfully.");
    }

    public static void main(String[] args) throws Exception{


        Document document = new Document();
        OutputStream outputStream = new FileOutputStream(new File("16.pdf"));
        PdfWriter pdfWriter = PdfWriter.getInstance(document, outputStream);

        // 打开
        document.open();

        document.addTitle("test addTitle");
        document.addAuthor("test addAuthor");
        document.addCreator("test addCreator");
        document.addSubject("test PDF addSubject");
        document.addCreationDate();
        document.addHeader("addHeader","test addHeader");

        // 新建页面
        document.newPage();
        document.setPageCount(0);
        document.add(new Paragraph("添加文字"));

        // 新建页面
        document.newPage();
        document.setPageCount(1);

        // 创建图片
        Image image = Image.getInstance("2.png");
        // 设置图片大小
        Rectangle rectangle = new Rectangle(50,50);
        image.scaleToFit(rectangle);
        document.add(image);


        document.newPage();
        document.setPageCount(2);

        document.add(new Phrase("Test Phrase."));
        document.add(new Chunk("Test Chunk1."));
        document.add(new Chunk("Test Chunk2."));

        document.newPage();
        document.setPageCount(3);
        Anchor anchor = new Anchor("https://www.baidu.com/");
        anchor.setReference("https://www.baidu.com/");
        document.add(anchor);


        document.close();
        outputStream.close();


        // 添加水印
        PdfReader pdfReader = new PdfReader("16.pdf");
        // 读取源文件，输出到新文件
        PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream("16_1.pdf"));

        BaseFont font = BaseFont.createFont();
        BaseColor baseColor = BaseColor.GRAY;
        PdfGState pdfGState = new PdfGState();
        pdfGState.setFillOpacity(0.2f);
        PdfContentByte overContent = pdfStamper.getOverContent(1);
        overContent.setFontAndSize(font, 40);
        overContent.beginText();
        overContent.setColorFill(baseColor);
        overContent.setGState(pdfGState);

        overContent.setGState(pdfGState);

        // 添加水印
        overContent.showTextAligned(0, "tests", 100, 100, 45);
        overContent.showTextAligned(0, "tests", 100, 200, 45);
        overContent.showTextAligned(0, "tests", 100, 300, 45);
        overContent.showTextAligned(0, "tests", 100, 400, 45);
        overContent.showTextAligned(0, "tests", 100, 500, 45);


        overContent.endText();
        pdfStamper.close();
        pdfReader.close();

    }


    private static void cc() {


            try {
                //Create Document instance.
                Document document = new Document();

                //Create OutputStream instance.
                OutputStream outputStream =
                        new FileOutputStream(new File("1.pdf"));

                //Create PDFWriter instance.
                PdfWriter.getInstance(document, outputStream);

                //Open the document.
                document.open();

                //Create Paragraph objects
                Paragraph paragraph1 = new Paragraph("Test Paragraph1.");
                Paragraph paragraph2 = new Paragraph("Test Paragraph2.");

                //Set alignment, spacing etc on Paragraph2
                paragraph2.setSpacingAfter(35);
                paragraph2.setSpacingBefore(35);
                paragraph2.setAlignment(Element.ALIGN_CENTER);
                paragraph2.setIndentationLeft(40);
                paragraph2.setIndentationRight(40);

                //Add content to the document using Paragraph objects.
                document.add(paragraph1);
                document.add(paragraph2);

                //Close document and outputStream.
                document.close();
                outputStream.close();

                System.out.println("Pdf created successfully.");
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    private static void createText() {

        try {

            Document document = new Document();

            //Create OutputStream instance.
            OutputStream outputStream =
                    new FileOutputStream(new File("TestFile.pdf"));

            //Create PDFWriter instance.
            PdfWriter.getInstance(document, outputStream);

            //Open the document.
            document.open();

            //Add content to the document.
            document.add(new Paragraph("Hello world, " +
                    "this is a test pdf file."));

            //Close document and outputStream.
            document.close();
            outputStream.close();

            System.out.println("Pdf created successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
