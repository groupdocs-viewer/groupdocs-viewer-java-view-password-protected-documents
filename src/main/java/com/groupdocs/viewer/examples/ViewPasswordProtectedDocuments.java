package com.groupdocs.viewer.examples;

import com.groupdocs.viewer.License;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.options.LoadOptions;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Demonstrates how to render a password‑protected document using GroupDocs Viewer.
 * <p>
 * The example expects an input file placed in {@code resources/input/} directory.
 * Rendered HTML pages are saved to {@code resources/output/} directory.
 * </p>
 */
public class ViewPasswordProtectedDocuments {

    /**
     * Loads the GroupDocs license if the license file exists.
     *
     * @param licensePath path to the license file (e.g., "GroupDocs.Viewer.lic")
     * @throws Exception if the license file is found but cannot be loaded
     */
    public static void loadLicense(String licensePath) throws Exception {
        File licenseFile = new File(licensePath);
        if (licenseFile.exists()) {
            // To get a temporary license, visit: https://purchase.groupdocs.com/temporary-license/
            // Place the license file in the project root directory.
            // Without a license, the library works in evaluation mode with limitations.
            new License().setLicense(licensePath);
            System.out.println("License loaded from " + licensePath);
        } else {
            System.out.println("License file not found at " + licensePath + ". Running in evaluation mode.");
        }
    }

    /**
     * Renders a password‑protected document to HTML pages.
     * <p>
     * The method:
     * <ul>
     *   <li>Loads the document from {@code resources/input/sample.docx}</li>
     *   <li>Applies the password (hard‑coded as "12345" for demonstration)</li>
     *   <li>Exports each page as an HTML file into {@code resources/output/}</li>
     * </ul>
     * </p>
     *
     * @throws Exception if an error occurs during rendering
     */
    public static void renderPasswordProtectedDocument() throws Exception {
        // Define relative paths
        Path inputPath = Paths.get("resources", "input", "sample.docx");
        Path outputDir = Paths.get("resources", "output");

        // Verify input file exists
        if (!Files.exists(inputPath)) {
            throw new IllegalArgumentException("Input file not found: " + inputPath.toAbsolutePath());
        }

        // Ensure output directory exists
        if (!Files.exists(outputDir)) {
            Files.createDirectories(outputDir);
        }
        Path pageFilePathFormat = outputDir.resolve("page_{0}.html");
        // Viewer load options – set the password for the protected document
        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setPassword("12345"); // Replace with actual password as needed

        // Create Viewer instance with settings
        try (Viewer viewer = new Viewer(inputPath.toString(), loadOptions)) {
            // Configure HTML output options – each page will be saved as a separate HTML file
            HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);

            // Render the document
            viewer.view(viewOptions);
        }

        System.out.println("Document rendered successfully. Output saved to " + outputDir.toAbsolutePath());
    }

    public static void main(String[] args) {
        try {
            // Load license if it exists in the project root
            loadLicense("GroupDocs.Viewer.Java.lic");

            // Execute the core demo functionality
            renderPasswordProtectedDocument();
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
