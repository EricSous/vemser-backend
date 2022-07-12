package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dtos.EnderecoDTO;
import br.com.vemser.pessoaapi.dtos.PessoaDTO;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class EmailService {

    private final freemarker.template.Configuration fmConfiguration;

    @Value("${spring.mail.username}")
    private String from;

    private final JavaMailSender emailSender;

    @Autowired
    private PessoaService pessoaService;

    public void sendSimpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo(from);
        message.setSubject("Assunto 1");
        message.setText("Meu e-mail!");
        emailSender.send(message);
    }

    public void sendWithAttachment() throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message,
                true);

        helper.setFrom(from);
        helper.setTo(from);
        helper.setSubject("Assunto 1");
        helper.setText("Meu e-mail!");

        // Forma 1
//        File file1 = new File("imagem.jpg");
//        FileSystemResource file
//                = new FileSystemResource(file1);
//        helper.addAttachment(file1.getName(), file);

        // Forma 2
        ClassLoader classLoader = getClass().getClassLoader();
        File file2 = new File(classLoader.getResource("imagem.jpg").getFile());
        FileSystemResource file = new FileSystemResource(file2);
        helper.addAttachment(file2.getName(), file);

//        System.out.println("F: " + file2.getPath());
        // src/main/resources/imagem.jpg

        emailSender.send(message);
    }

    public void sendEmail() {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(from);
            mimeMessageHelper.setSubject("Assunto 3");
            mimeMessageHelper.setText(getContentFromTemplate(), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }

    }

    public String getContentFromTemplate() throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", "MeuNome");
        dados.put("email", "aaa@aaa");

        Template template = fmConfiguration.getTemplate("email-template.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    public String getPessoaTemplate(PessoaDTO pessoaDTO, String templateNome) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoaDTO.getNome());
        dados.put("id", pessoaDTO.getIdPessoa());
        dados.put("email", this.from);

        Template template = fmConfiguration.getTemplate(templateNome);
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    public void enviarEmailCrud(PessoaDTO pessoaDTO, String nomeTemplate){
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(from);
            mimeMessageHelper.setSubject("Atualização de dados");
            mimeMessageHelper.setText(this.getPessoaTemplate(pessoaDTO,nomeTemplate), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
            System.out.println("Email enviado com sucesso");
        } catch (MessagingException | TemplateException | IOException e) {
            e.printStackTrace();
        }
    }

    public String getEnderecoTemplate(EnderecoDTO enderecoDTO, String templateNome) throws IOException, TemplateException, RegraDeNegocioException {
        Map<String, Object> dados = new HashMap<>();

        dados.put("logradouro", enderecoDTO.getLogradouro());
        dados.put("nome", pessoaService.pessoaPorId(enderecoDTO.getIdPessoa()).getNome());
        dados.put("email", this.from);
        dados.put("EnderecoDTO", enderecoDTO.toString());

        Template template = fmConfiguration.getTemplate(templateNome);
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    public void enviarEmailCrudEndereco(EnderecoDTO enderecoDTO, String nomeTemplate){
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(from);
            mimeMessageHelper.setSubject("Atualização de dados");
            mimeMessageHelper.setText(this.getEnderecoTemplate(enderecoDTO,nomeTemplate), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
            System.out.println("Email enviado com sucesso");
        } catch (MessagingException | TemplateException | IOException | RegraDeNegocioException e) {
            e.printStackTrace();
        }
    }
}


