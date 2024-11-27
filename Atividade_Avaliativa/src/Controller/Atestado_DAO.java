
package Controller;

import java.io.FileOutputStream;
import java.io.OutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class Atestado_DAO {
    
    public static void imprime()throws Exception {
 
    Document doc = null;
    OutputStream os = null;
        
    LocalDate data = java.time.LocalDate.now();
    String recebe = data.format(DateTimeFormatter.ISO_DATE);
        
    String nome = JOptionPane.showInputDialog(null, "Digite o seu nome: ");
    String local = JOptionPane.showInputDialog(null, "Digite o local:  ");
    String numero = JOptionPane.showInputDialog(null, "Número da Identidade:");
    String periodo = JOptionPane.showInputDialog(null, "Data de retorno:");
    String motivo = JOptionPane.showInputDialog(null, "Motivo:");
  try {
 
            //cria o documento tamanho A4, margens de 2,54cm
            doc = new Document(PageSize.A4, 72, 72, 72, 72);
 
            //cria a stream de saída
            os = new FileOutputStream("Relatorio1.pdf");
 
            //associa a stream de saída ao
            PdfWriter.getInstance(doc, os);
 
            //abre o documento
            doc.open();
 
            //adiciona o texto ao PDF
            Paragraph par = new Paragraph("ATESTADO MÉDICO   \n Atesto, para os devidos fins, que o Sr.(a) " + nome +", " + "portador da carteira de identidade nº " + numero + ", " + 
                    "esteve sob cuidados médicos no dia: " + recebe + " e deverá se afastar de suas atividades de " + recebe + " até " + periodo + ", por motivo de " + motivo + "." + "\n" + "\n" + "\n");
            doc.add(par);
            Paragraph par2 = new Paragraph("Local: " + local +"      Data: " + recebe);
            doc.add(par2);
 
        } finally {
 
            if (doc != null) {
 
                //fechamento do documento
                doc.close();
            }
 
            if (os != null) {
                //fechamento da stream de saída
                os.close();
            }
        }
        Desktop.getDesktop().open(new File("Relatorio1.pdf"));
    }
    
}
