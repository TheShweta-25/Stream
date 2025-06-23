package EPAMStreamPractice;

import java.util.List;

public class MixedLogic {
    public static void main(String[] args) {

        //From a list of filenames, filter only .txt files and sort them by name
        List<String> filenames = List.of(
                "notes.txt",
                "report.pdf",
                "summary.docx",
                "data.txt",
                "readme.txt",
                "image.png"
        );

        System.out.println(filenames.stream().filter(f -> f.contains(".txt")).sorted().toList());

        /*
        From a list of filenames, filter only .txt files and sort them by name.

        Given a list of people objects, group them by age.
        
        Filter emails that are valid (e.g., using regex) from a list.

        Find common elements between two lists using streams.

        From a list of strings, return the one with maximum vowels.
         */
    }
}
