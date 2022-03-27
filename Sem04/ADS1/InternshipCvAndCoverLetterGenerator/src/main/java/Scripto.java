import com.google.common.io.Files;
import org.apache.poi.xwpf.usermodel.*;


import java.io.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

public class Scripto {
    public static void main(String[] args) throws Exception {
        String position = "Software Development Internship";
        String companyName = "Karzo";

        LocalDate now = LocalDate.now();
        int day = now.getDayOfMonth();
        String month = new SimpleDateFormat("MMMM").format(Date.from(now.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        int year = now.getYear();

        String dateExtension = switch (day) {
            case 1 -> "st";
            case 2 -> "nd";
            case 3 -> "rd";
            default -> "th";
        };

        try {
            InputStream systemResourceAsStream = ClassLoader.getSystemResourceAsStream("Cover Letter.docx");
            XWPFDocument doc = new XWPFDocument(systemResourceAsStream);
            for (XWPFParagraph p : doc.getParagraphs()) {
                List<XWPFRun> runs = p.getRuns();
                if (runs != null) {
                    for (XWPFRun r : runs) {
                        replace(position, companyName, day, month, year, dateExtension, r);
                    }
                }
            }

            for (XWPFTable tbl : doc.getTables()) {
                for (XWPFTableRow row : tbl.getRows()) {
                    for (XWPFTableCell cell : row.getTableCells()) {
                        for (XWPFParagraph p : cell.getParagraphs()) {
                            for (XWPFRun r : p.getRuns()) {
                                replace(position, companyName, day, month, year, dateExtension, r);
                            }
                        }
                    }
                }
            }

            String directoriesPath = "D:\\Users\\PC1\\Desktop\\Job Applications\\" + companyName;
            File file = new File(directoriesPath);
            file.mkdirs();

            String docFilePath = directoriesPath + "\\Cover Letter.docx";
            Files.touch(new File(docFilePath));
            doc.write(new FileOutputStream(docFilePath));

            String cvFilePath = directoriesPath + "\\CV.pdf";
            File dest = new File(cvFilePath);

            try (
                    InputStream in = ClassLoader.getSystemResourceAsStream("CV.pdf");
                    OutputStream out = new BufferedOutputStream(
                            new FileOutputStream(dest))) {

                byte[] buffer = new byte[1024];
                int lengthRead;
                while ((lengthRead = in.read(buffer)) > 0) {
                    out.write(buffer, 0, lengthRead);
                    out.flush();
                }
            }


            doc.close();
        } finally {
        }
    }

    private static void replace(String position, String companyName, int day, String month, int year, String dateExtension, XWPFRun r) {
        String text = r.getText(0);
        if (text == null) {
            return;
        }
        replaceIfFound(r, text, "[position]", position);
        replaceIfFound(r, text, "[company]", companyName);
        replaceIfFound(r, text, "[day]", String.valueOf(day));
        replaceIfFound(r, text, "[month]", month);
        replaceIfFound(r, text, "[year]", String.valueOf(year));
//        replaceIfFound(r, text, "[date extension]", dateExtension);
    }

    static void replaceIfFound(XWPFRun run, String text, String key, String replacement) {
        if (text.contains(key)) {
            text = text.replace(key, replacement);
            run.setText(text, 0);
        }
    }
}
