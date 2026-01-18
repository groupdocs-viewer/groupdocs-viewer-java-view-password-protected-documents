# GroupDocs Viewer – View Password‑Protected Documents

**Project name:** `groupdocs-viewer-java-view-password-protected-documents`

This is a showcase Maven project that demonstrates how to use **GroupDocs Viewer Java API 25.12** to render a password‑protected document (DOCX) into HTML pages with embedded resources.

---

## Overview

The application:
- Loads a license file (if provided) – otherwise runs in evaluation mode.
- Opens a password‑protected document located in `resources/input/`.
- Renders each page as a separate HTML file into `resources/output/`.
- Uses only relative paths so the project can be run from any location.

---

## Prerequisites

- **Java Development Kit (JDK) 8** or higher
- **Apache Maven** 3.5+ 
- Internet access to download the GroupDocs Maven repository artifacts (first build only)

---

## License

GroupDocs Viewer requires a license file (`GroupDocs.Viewer.Java.lic`).

- **Temporary license:** You can obtain a free 30‑day temporary license at
  https://purchase.groupdocs.com/temporary-license/
- **Placement:** Put the `GroupDocs.Viewer.Java.lic` file in the **project root** (same directory as `pom.xml`).
- **Without a license:** The library works in evaluation mode, which adds watermarks and imposes usage limits.

---

## Project Structure

```
groupdocs-viewer-java-view-password-protected-documents/
│   pom.xml
│   README.md
│   GroupDocs.Viewer.Java.lic   <-- (optional) place your license here
│
├───src/main/java/com/groupdocs/viewer/examples/
│       ViewPasswordProtectedDocuments.java
│
├───resources/
│   ├───input/
│   │       sample.docx   <-- replace with your own password‑protected DOCX
│   └───output/            <-- generated HTML files will appear here
│
└───target/                <-- Maven build output (generated after compile)
```

---

## Setup & Execution

1. **Clone the repository** (or copy the project files to a local folder).
   ```bash
   git clone https://github.com/your-repo/groupdocs-viewer-java-view-password-protected-documents.git
   cd groupdocs-viewer-java-view-password-protected-documents
   ```

2. **Place your license file** (if you have one) in the project root as `GroupDocs.Viewer.Java.lic`.

3. **Add a password‑protected DOCX** to `resources/input/`.
   - The sample file included is only a placeholder.
   - By default the demo expects the password to be `12345`. Change the password in the source code if needed.

4. **Build the project** (download dependencies and compile).
   ```bash
   mvn clean compile
   ```

5. **Run the demo**.
   - Using Maven Exec Plugin:
     ```bash
     mvn exec:java
     ```

6. **Check the results** in `resources/output/`. Each page of the document will be saved as `page_1.html`, `page_2.html`, etc.

---

## Notes

- The password used in the example is hard‑coded (`"12345"`). Adjust `loadOptions.setPassword("12345");` in `ViewPasswordProtectedDocuments.java` to match your document's password.
- The project does **not** include a real DOCX file to avoid licensing issues. Replace the placeholder with your own document before running.
- Ensure that the `resources/output/` directory is writable; the program will create it automatically if missing.

---

## Further Reading

- **GroupDocs Viewer Java Documentation:** https://docs.groupdocs.com/viewer/java/
- **API Reference (v25.12):** https://apireference.groupdocs.com/viewer/java/v25.12

---

Happy coding!
