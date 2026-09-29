import java.io.FileWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;


public class GenerarXML {
    public static void main(String[] args) throws Exception {
        String ruta = "/home/dam26/AD/autores.xml";
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = factory.createXMLStreamWriter(new FileWriter(ruta));
        writer.writeStartDocument("1.0");


        // raiz: autores
        writer.writeStartElement("autores");


        writer.writeStartElement("autor");
        writer.writeAttribute("codigo", "a1");


        writer.writeStartElement("nome");
        writer.writeCharacters("Alexandre Dumas");
        writer.writeEndElement();


        writer.writeStartElement("titulo");
        writer.writeCharacters("El conde de montecristo");
        writer.writeEndElement();


        writer.writeStartElement("titulo");
        writer.writeCharacters("Los miserables");
        writer.writeEndElement();


        writer.writeEndElement();


        writer.writeStartElement("autor");
        writer.writeAttribute("codigo", "a2");


        writer.writeStartElement("nome");
        writer.writeCharacters("Fiodor Dostoyevski");
        writer.writeEndElement();


        writer.writeStartElement("titulo");
        writer.writeCharacters("El idiota");
        writer.writeEndElement();


        writer.writeStartElement("titulo");
        writer.writeCharacters("Noches blancas");
        writer.writeEndElement();
        writer.writeEndElement();


        // </autores>
        writer.writeEndElement();

        writer.writeEndDocument();
        writer.flush();
        writer.close();


        System.out.println("Ficheiro XML xerado correctamente.");
    }
}
