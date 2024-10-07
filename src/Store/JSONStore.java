package Store;

/*
* made by: gabo2105MS
*/

import Number.CompanyNumber;
import static Number.CompanyNumber.DELL;
import static Number.CompanyNumber.HP;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;

public class JSONStore {
    
    Gson gson = new Gson();
    File dellFile = new File("./src/Store/DELLRules.json");
    File hpFile = new File("./src/Store/HPRules.json");
    
    /**
     * Default constructor for JSONStore.
     */
    public JSONStore() {}
    
    /**
     * Retrieves the FileEntity object for a specific company type by reading the corresponding JSON file.
     * @return The FileEntity object populated with the file data, or null if an error occurs.
     * @throws IOException if there is an issue accessing the file.
     */
    public FileEntity GetFile(CompanyNumber companyType) throws IOException {
        try { 
            File selectedFile = null;
            switch(companyType) {
                case DELL:
                    selectedFile = dellFile;
                    break;
                case HP:
                    selectedFile = hpFile;
                    break;
            }
            FileReader myreader = new FileReader(selectedFile);
            FileEntity file = gson.fromJson(myreader, FileEntity.class);
            myreader.close();
            return file;
        } catch (IOException e) {
            return null;
        }
    }
    
    /**
     * Writes the given FileEntity to the appropriate file based on the company type.
     * @throws IOException if there is an issue writing to the file.
     */
    public void setFile(FileEntity file, CompanyNumber companyType) throws IOException {
        try {
            File selectedFile = null;
            switch(companyType) {
                case DELL:
                    selectedFile = dellFile;
                    break;
                case HP:
                    selectedFile = hpFile;
                    break;
            }
            FileWriter fileWriter = new FileWriter(selectedFile);
            gson.toJson(file, fileWriter);
            fileWriter.close();
        } catch (IOException e) {
        }
    }
}
