//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package advocatehelperv1;

import java.io.IOException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.XmlToken.Factory;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline;

public class CustomXWPFDocument extends XWPFDocument {
    public CustomXWPFDocument() throws IOException {
    }

    public void createPictureCxCy(String blipId, int id, long cx, long cy) {
        CTInline inline = this.createParagraph().createRun().getCTR().addNewDrawing().addNewInline();
        String picXml = "<a:graphic xmlns:a=\"http://schemas.openxmlformats.org/drawingml/2006/main\">   <a:graphicData uri=\"http://schemas.openxmlformats.org/drawingml/2006/picture\">      <pic:pic xmlns:pic=\"http://schemas.openxmlformats.org/drawingml/2006/picture\">         <pic:nvPicPr>            <pic:cNvPr id=\"" + id + "\" name=\"Generated\"/>" + "            <pic:cNvPicPr/>" + "         </pic:nvPicPr>" + "         <pic:blipFill>" + "            <a:blip r:embed=\"" + blipId + "\" xmlns:r=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships\"/>" + "            <a:stretch>" + "               <a:fillRect/>" + "            </a:stretch>" + "         </pic:blipFill>" + "         <pic:spPr>" + "            <a:xfrm>" + "               <a:off x=\"0\" y=\"0\"/>" + "               <a:ext cx=\"" + cx + "\" cy=\"" + cy + "\"/>" + "            </a:xfrm>" + "            <a:prstGeom prst=\"rect\">" + "               <a:avLst/>" + "            </a:prstGeom>" + "         </pic:spPr>" + "      </pic:pic>" + "   </a:graphicData>" + "</a:graphic>";
        XmlToken xmlToken = null;

        try {
            xmlToken = Factory.parse(picXml);
        } catch (XmlException var12) {
            var12.printStackTrace();
        }

        inline.set(xmlToken);
        inline.setDistT(0L);
        inline.setDistB(0L);
        inline.setDistL(0L);
        inline.setDistR(0L);
        CTPositiveSize2D extent = inline.addNewExtent();
        extent.setCx(cx);
        extent.setCy(cy);
        CTNonVisualDrawingProps docPr = inline.addNewDocPr();
        docPr.setId((long)id);
        docPr.setName("Picture " + id);
        docPr.setDescr("Generated");
    }

    public void createPicture(String blipId, int id, int width, int height) {
        //int EMU = true;
        width *= 9525;
        height *= 9525;
        this.createPictureCxCy(blipId, id, (long)width, (long)height);
    }
}
