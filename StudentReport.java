import java.io.*;
import java.time.LocalDateTime;

public class StudentReport {

    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Error: יש להזין 4 פרמטרים: שם, ציון, עבר/נכשל, תאריך בחינה");
            System.exit(1);
        }

        String name = args[0];
        int score = Integer.parseInt(args[1]);
        boolean passed = Boolean.parseBoolean(args[2]);
        String examDate = args[3];

        // בדיקת תקינות
        if (name.isEmpty()) {
            System.out.println("Error: שם תלמיד לא מוזן");
            System.exit(1);
        }
        if (score < 0 || score > 100) {
            System.out.println("Error: ציון לא חוקי");
            System.exit(1);
        }

        String status = passed ? "עבר" : "נכשל";
        LocalDateTime now = LocalDateTime.now();

        // יצירת HTML
        String htmlContent = "<html><body>"
                + "<h1>דוח תלמיד</h1>"
                + "<p>שם: " + name + "</p>"
                + "<p>ציון: " + score + "</p>"
                + "<p>סטטוס: " + status + "</p>"
                + "<p>תאריך בחינה: " + examDate + "</p>"
                + "<p>דוח נוצר: " + now + "</p>"
                + "</body></html>";

        try {
            // שמירת HTML
            BufferedWriter htmlWriter = new BufferedWriter(new FileWriter("report.html"));
            htmlWriter.write(htmlContent);
            htmlWriter.close();

            // שמירת לוג
            BufferedWriter logWriter = new BufferedWriter(new FileWriter("log.txt", true));
            logWriter.write(now + " - " + name + " - " + score + " - " + status + " - " + examDate + "\n");
            logWriter.close();

            System.out.println("Script executed successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
