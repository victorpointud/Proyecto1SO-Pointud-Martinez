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
    
    public JSONStore() {}
    
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
