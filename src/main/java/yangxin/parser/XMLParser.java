package yangxin.parser;

import org.dom4j.*;
import org.dom4j.io.SAXReader;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import static org.w3c.dom.Node.ELEMENT_NODE;
import static org.w3c.dom.Node.TEXT_NODE;

/**
 * Created by ryan on 17-8-1.
 */
public class XMLParser{
    private SAXReader reader;

    public XMLParser(){
        reader = new SAXReader();
    }

    public Document openFile(final String fileName) throws DocumentException{
        Document document = reader.read(new File(fileName));
        return document;
    }

    public Document fromString(final String xml) throws DocumentException{
        Document document = DocumentHelper.parseText(xml);
        return document;
    }

    private Map<String, String> treeWalk(Document document) {
        Map<String, String> values = new HashMap<String, String>();
        treeWalk("", document.getRootElement(), values);
        return values;
    }

    private void treeWalk(final String path, Node node, Map<String, String> values){
        short nodeType = node.getNodeType();
        if (nodeType == ELEMENT_NODE){
            Element element = (Element) node;
            String name = path + "/" + element.getQualifiedName();
            values.put(name, "");
            int size = element.nodeCount();
            for (int i = 0; i < size; i++){
                treeWalk(name, element.node(i), values);
            }
        }else if (nodeType == TEXT_NODE){
            String text = node.getText().trim();
            values.put(path, text);
        }else{
            System.out.println(node.getNodeTypeName());
        }
    }
}
