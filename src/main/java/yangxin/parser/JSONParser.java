package yangxin.parser;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;


/**
 * Created by ryan on 17-8-1.
 */
public class JSONParser{

    public Document fromString(final String json) throws DocumentException {
        Object document = Configuration.defaultConfiguration().jsonProvider().parse(json);
    }
}
