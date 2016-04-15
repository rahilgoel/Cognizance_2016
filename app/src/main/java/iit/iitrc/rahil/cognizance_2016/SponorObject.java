package iit.iitrc.rahil.cognizance_2016;

import android.graphics.Bitmap;

import com.parse.ParseFile;

/**
 * Created by rahil on 2/9/2016.
 */
public class SponorObject {
    public ParseFile getFile() {
        return file;
    }

    public void setFile(ParseFile file) {
        this.file = file;
    }

    ParseFile file;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;


}
