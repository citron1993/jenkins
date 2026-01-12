import sys
import datetime

# קבלת פרמטרים
name = sys.argv[1]               # שם התלמיד (string)
score = int(sys.argv[2])         # ציון (number)
passed = sys.argv[3].lower() == "true"  # עבר/נכשל (boolean)
exam_date = sys.argv[4]          # תאריך בחינה (string)

# בדיקת תקינות
if not name:
    print("Error: שם תלמיד לא מוזן")
    sys.exit(1)
if score < 0 or score > 100:
    print("Error: ציון לא חוקי")
    sys.exit(1)

# חישוב סטטוס
status = "עבר" if passed else "נכשל"

# תאריך נוכחי
now = datetime.datetime.now()

# יצירת HTML
html_content = f"""
<html>
<body>
<h1>דוח תלמיד</h1>
<p>שם: {name}</p>
<p>ציון: {score}</p>
<p>סטטוס: {status}</p>
<p>תאריך בחינה: {exam_date}</p>
<p>דוח נוצר: {now}</p>
</body>
</html>
"""

with open("report.html", "w", encoding="utf-8") as f:
    f.write(html_content)

# יצירת קובץ לוג
with open("log.txt", "a", encoding="utf-8") as log:
    log.write(f"{now} - {name} - {score} - {status} - {exam_date}\n")

print("Script executed successfully!")
