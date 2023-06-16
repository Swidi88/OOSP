import java.io.*;

public class model {
    public static final String FILE_HISTORY_OF_EQUATIONS = "equations.txt";
    public static final String FILE_HISTORY_OF_RESULTS = "results.txt";

    protected void writerHistoryFromFile(String equation, Double result) {
        try {
            File fileHistoryOfEquations = new File(FILE_HISTORY_OF_EQUATIONS);
            File fileHistoryOfResults = new File(FILE_HISTORY_OF_RESULTS);

            if (!fileHistoryOfEquations.exists()) {
                fileHistoryOfEquations.createNewFile();
            }
            if (!fileHistoryOfResults.exists()) {
                fileHistoryOfResults.createNewFile();
            }

            FileWriter fileWriterHistoryOfEquations = new FileWriter(fileHistoryOfEquations, true);
            FileWriter fileWriterHistoryOfResults = new FileWriter(fileHistoryOfResults, true);

            BufferedWriter bufferedWriterHistoryOfEquations = new BufferedWriter(fileWriterHistoryOfEquations);
            BufferedWriter bufferedWriterHistoryOfResults = new BufferedWriter(fileWriterHistoryOfResults);

            bufferedWriterHistoryOfEquations.write(equation);
            bufferedWriterHistoryOfResults.write(String.valueOf(result));

            bufferedWriterHistoryOfEquations.newLine();
            bufferedWriterHistoryOfResults.newLine();

            bufferedWriterHistoryOfEquations.flush();
            bufferedWriterHistoryOfResults.flush();

            bufferedWriterHistoryOfEquations.close();
            bufferedWriterHistoryOfResults.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    protected void showHistoryFromFile(String historyFromFile) {
        try {
            File file = new File(historyFromFile);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            if (bufferedReader.ready()) {
                while (bufferedReader.ready()) {
                    System.out.println(bufferedReader.readLine());
                }
            } else {
                System.out.print("Файл" + historyFromFile + " пустой, не содержит никакой информации.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

