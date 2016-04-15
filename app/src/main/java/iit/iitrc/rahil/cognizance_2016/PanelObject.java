package iit.iitrc.rahil.cognizance_2016;

import com.parse.ParseFile;

/**
 * Created by rahil on 3/11/2016.
 */
public class PanelObject {
    String name;
    String subname;
   ParseFile file;

    public ParseFile getFile() {
        return file;
    }

    public void setFile(ParseFile file) {
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getSubname() {
        return subname;
    }

    public void setSubname(String subname) {
        this.subname = subname;
    }
}
