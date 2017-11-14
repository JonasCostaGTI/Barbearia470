package barbearia470.br.com.model;

import barbearia470.br.com.DAO.ConfEmailDAO;
import barbearia470.br.com.conexao.Conexao;
import barbearia470.br.com.mail.Mail;
import barbearia470.br.com.view.RelatorioGeral;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.TemporalAdjusters.nextOrSame;
import static java.time.temporal.TemporalAdjusters.previousOrSame;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

/**
 * @author jonascosta
 * @date 26/10/2017
 *
 */
public class EnvioAutomaticoEmail implements ActionListener {

    boolean emailEnviado;

    @Override
    public void actionPerformed(ActionEvent e) {

        verificaVariavelControle();

        
        if (verificaEstaNoHorario() && !emailEnviado) {
            enviaEmail();
        }
    }

    private boolean verificaEstaNoHorario() {

        ConfEmailDAO confEmailDAO = new ConfEmailDAO();
        ConfiguracaoEmail configuracaoEmail = confEmailDAO.pegaConfiguracao();

        SimpleDateFormat hora = new SimpleDateFormat("HH:mm");
        String now = hora.format(new Date());

        String horaAgendada = configuracaoEmail.getHorario().split(":")[0];
        String minutoAgendado = configuracaoEmail.getHorario().split(":")[1];

        String horaAtual = now.split(":")[0];
        String minutoAtual = now.split(":")[1];

        int minutoAgendadoInt = Integer.parseInt(minutoAgendado);
        int minutoAtualInt = Integer.parseInt(minutoAtual);

        //range minimo deve ser menor que tempo de verificação 300000 = 5min
        int rangeMinuto = minutoAgendadoInt - minutoAtualInt;

        if (configuracaoEmail != null) {
            if (horaAtual.equals(horaAgendada) && rangeMinuto > - 1 && emailEnviado == false) {
                return true;
            }
        }

        return false;
    }

    private void enviaEmail() {

        ConfEmailDAO confEmailDAO = new ConfEmailDAO();
        ConfiguracaoEmail configuracaoEmail = confEmailDAO.pegaConfiguracao();

        if (configuracaoEmail != null) {
            //gera PDF
            geraPDF();
            String pdfPath = "src/reports/auto_report.pdf";

            Mail mail = new Mail(configuracaoEmail.getEmail(), configuracaoEmail.getSenha());
            String[] toArr = {configuracaoEmail.getEmail()};
            mail.set_from(configuracaoEmail.getEmail());

            LocalDate now = LocalDate.now();
            LocalDate first = now.with(previousOrSame(DayOfWeek.MONDAY));
            DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            mail.set_subject("Relatorio Automatico periodo " + first.format(formatters) + " até " + now.format(formatters));

            mail.set_to(toArr);

            try {
                mail.addAttachment(pdfPath);
            } catch (Exception ex) {
                Logger.getLogger(RelatorioGeral.class.getName()).log(Level.SEVERE, null, ex);
            }

            mail.setBody("Obrigado");

            try {
                mail.send();
                emailEnviado = true;
                

            } catch (Exception ex) {
                Logger.getLogger(RelatorioGeral.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private void geraPDF() {

        try {
            Document document = new Document(PageSize.LEGAL.rotate());
            PdfWriter.getInstance(document, new FileOutputStream("src/reports/auto_report.pdf"));

            document.open();

            Image img = Image.getInstance("src/icon/logo_barbearia_470.png");
            img.scaleAbsolute(50f, 50f);
            document.add(img);

            Paragraph titulo = new Paragraph("Relatorio Automático");
            titulo.setAlignment(Element.ALIGN_CENTER);
            document.add(titulo);

            document.add(new Paragraph(" "));
            PdfPTable table = criaCorpoPDF();
            document.add(table);

            document.close();
        } catch (DocumentException ex) {
            Logger.getLogger(RelatorioGeral.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RelatorioGeral.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RelatorioGeral.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private PdfPTable criaCorpoPDF() {

        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        PdfPTable table = new PdfPTable(9);
        table.setWidthPercentage(100);

        PdfPCell cell = new PdfPCell(new Phrase("Funcionário"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Total"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Total Bebidas"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Total Produtos"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Total Serviços"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Total Outros"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Total Dinheiro"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Total Cartão"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Atendimentos"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
        table.setHeaderRows(1);

        String sql = "SELECT  nomeFuncionario, "
                + "SUM(CASE WHEN totalVenda != '' THEN totalVenda ELSE 0 END) as totalDia, "
                + "SUM(CASE WHEN totalBebidas != '' THEN totalBebidas ELSE 0 END) as totalBebidas, "
                + "SUM(CASE WHEN totalProdutos != '' THEN totalProdutos ELSE 0 END) as totalProdutos, "
                + "SUM(CASE WHEN totalServico != '' THEN totalServico ELSE 0 END) as totalServicos, "
                + "SUM(CASE WHEN valorOutros != '' THEN valorOutros ELSE 0 END) as totalOutros, "
                + "SUM(CASE WHEN pagamento = 'Dinheiro' THEN totalVenda ELSE 0 END) as totalDinheiro, "
                + "SUM(CASE WHEN pagamento = 'Cartão' THEN totalVenda ELSE 0 END) as totalCartao, "
                + "count(*) as atendimentos FROM vendas "
                + "WHERE data BETWEEN ? AND ? GROUP BY nomeFuncionario;";

        try (PreparedStatement pst = conn.prepareStatement(sql)) {

            LocalDate now = LocalDate.now();
            LocalDate first = now.with(previousOrSame(DayOfWeek.MONDAY));
            LocalDate last = now.with(nextOrSame(DayOfWeek.SUNDAY));

            DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            pst.setString(1, first.format(formatters));
            pst.setString(2, last.format(formatters));

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                CurrencyUnit real = CurrencyUnit.of("BRL");
                Money totalDia = Money.of(real, rs.getBigDecimal("totalDia"));
                Money totalBebidas = Money.of(real, rs.getBigDecimal("totalBebidas"));
                Money totalProdutos = Money.of(real, rs.getBigDecimal("totalProdutos"));
                Money totalServicos = Money.of(real, rs.getBigDecimal("totalServicos"));
                Money totalOutros = Money.of(real, rs.getBigDecimal("totalOutros"));
                Money totalDinheiro = Money.of(real, rs.getBigDecimal("totalDinheiro"));
                Money totalCartao = Money.of(real, rs.getBigDecimal("totalCartao"));

                cell.setColspan(4);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(BaseColor.GREEN);

                table.addCell(rs.getString("nomeFuncionario"));
                table.addCell(totalDia.toString());
                table.addCell(totalBebidas.toString());
                table.addCell(totalProdutos.toString());
                table.addCell(totalServicos.toString());
                table.addCell(totalOutros.toString());
                table.addCell(totalDinheiro.toString());
                table.addCell(totalCartao.toString());
                table.addCell(rs.getString("atendimentos"));

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        conexao.desconectar();

        return table;

    }

    private void verificaVariavelControle() {

        Date d = new Date();
        Calendar c = new GregorianCalendar();
        c.setTime(d);
        String nome = "";
        int dia = c.get(c.DAY_OF_WEEK);
        switch (dia) {
            case Calendar.SUNDAY:
                nome = "Domingo";
                break;
            case Calendar.MONDAY:
                nome = "Segunda-feira";
                break;
            case Calendar.TUESDAY:
                nome = "Terça-feira";
                break;
            case Calendar.WEDNESDAY:
                nome = "Quarta-feira";
                break;
            case Calendar.THURSDAY:
                nome = "Quinta-feira";
                break;
            case Calendar.FRIDAY:
                nome = "Sexta-feira";
                break;
            case Calendar.SATURDAY:
                nome = "sábado";
                break;

        }

        ConfEmailDAO confEmailDAO = new ConfEmailDAO();
        ConfiguracaoEmail configuracaoEmail = confEmailDAO.pegaConfiguracao();

        
        if (!configuracaoEmail.getDiaSemana().equals(nome)) {
            emailEnviado = false;
        }

    }

}
